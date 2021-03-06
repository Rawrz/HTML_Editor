
package Entities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

/**
 * 
 * @author Roseline Okpara
 *
 */
public class DocumentReader {

       public DocumentReader(){
           
       }
       
       public DefaultMutableTreeNode buildTree(Document domDoc) throws ParserConfigurationException{
           HtmlTree t = new HtmlTree(domDoc);
           return t.createTree();
       }
       
       public Document buildDocument(File file) throws ParserConfigurationException, SAXException, IOException{
           DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
           fact.setIgnoringElementContentWhitespace(true);
           DocumentBuilder builder = fact.newDocumentBuilder();
           Document domDoc = builder.parse(file); 
           return domDoc;
       }
       
       public Document buildDocument(InputStream is) throws ParserConfigurationException, SAXException, IOException{
           DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
           DocumentBuilder builder = fact.newDocumentBuilder();
           Document domDoc = builder.parse(is); 
           return domDoc;
       }
       
       public Document newDocument(File file) throws IOException, ParserConfigurationException{
           file.createNewFile();
           FileWriter fw = new FileWriter(file.getAbsoluteFile());
           BufferedWriter bw = new BufferedWriter(fw);
           bw.write("<html><body> </body></html>");
           bw.close();
           DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
           DocumentBuilder builder = fact.newDocumentBuilder();
           //System.out.println(file.exists());
           return builder.newDocument();
       }
       
       public void quickParse(String xml) throws SAXException, IOException, ParserConfigurationException{
           String newXml = xml.replaceAll("\\s+", " ").trim();
           SAXParserFactory factory = SAXParserFactory.newInstance();
           factory.setNamespaceAware(false);
           factory.setValidating(false);           
               factory.newSAXParser().getXMLReader();
               //reader.setContentHandler(new ParseHandler());
               InputSource input = new InputSource(new StringReader(newXml));
               DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
               DocumentBuilder builder = fact.newDocumentBuilder();
               builder.parse(input);                 
       }
       
       public String parseAndPretty(String xml,String indent) throws SAXException, ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException{
           
           String newXml = xml.replaceAll("\\s+", " ").trim();
           //System.out.println(xml);
           SAXParserFactory factory = SAXParserFactory.newInstance();
           factory.setNamespaceAware(false);
           factory.setValidating(false);   
           StreamResult format = null;
               XMLReader reader  = factory.newSAXParser().getXMLReader();
               Source input = new SAXSource(reader, new InputSource(new StringReader(newXml)));
               StringWriter stringWriter = new StringWriter();
               format = new StreamResult(stringWriter);   
               Transformer transformer = TransformerFactory.newInstance().newTransformer();
               transformer.setOutputProperty(OutputKeys.INDENT, "yes");
               transformer.setOutputProperty(OutputKeys.METHOD, "html");
               transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", indent);
               transformer.transform(input, format);
           return format.getWriter().toString();
       }
       
       
       
}

