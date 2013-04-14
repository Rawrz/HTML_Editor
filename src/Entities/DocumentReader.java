
package Entities;

import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class DocumentReader {

       public DocumentReader(){
           
       }
       
       public Node buildTree(File file){
           Node tree = null;
           try{
               DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
               DocumentBuilder builder = fact.newDocumentBuilder();
               Document domDoc = builder.parse(file);       
               tree = domDoc.getDocumentElement();
           }catch(Exception e){
               
           }
           return tree;
       }
       
       public Document newDocument(){
               DocumentBuilder builder = null;
            try {
               DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
               builder = fact.newDocumentBuilder();
            } catch (ParserConfigurationException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
               return builder.newDocument();
       }
       
       public boolean quickParse(String xml){
           String newXml = xml.replaceAll("\\s+", " ").trim();
           //System.out.println(xml);
           SAXParserFactory factory = SAXParserFactory.newInstance();
           factory.setNamespaceAware(false);
           factory.setValidating(false);           
           try {
               factory.newSAXParser().getXMLReader();
               //reader.setContentHandler(new ParseHandler());
               InputSource input = new InputSource(new StringReader(newXml));
               DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
               DocumentBuilder builder = fact.newDocumentBuilder();
               builder.parse(input);        
               
           }catch(Exception e){
               return false;
           }          
           return true;
       }
       
       public String parseAndPretty(String xml,String indent){
           
           String newXml = xml.replaceAll("\\s+", " ").trim();
           //System.out.println(xml);
           SAXParserFactory factory = SAXParserFactory.newInstance();
           factory.setNamespaceAware(false);
           factory.setValidating(false);   
           StreamResult format = null;
           try {
               XMLReader reader  = factory.newSAXParser().getXMLReader();
               Source input = new SAXSource(reader, new InputSource(new StringReader(newXml)));
               StringWriter stringWriter = new StringWriter();
               format = new StreamResult(stringWriter);   
               Transformer transformer = TransformerFactory.newInstance().newTransformer();
               transformer.setOutputProperty(OutputKeys.INDENT, "yes");
               transformer.setOutputProperty(OutputKeys.METHOD, "html");
               transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", indent);
               transformer.transform(input, format);
           } catch (SAXException e) {
               // TODO Auto-generated catch block
                    
           } catch (ParserConfigurationException e) {
               // TODO Auto-generated catch block
               //e.printStackTrace();
           } catch (TransformerConfigurationException e) {
               // TODO Auto-generated catch block
              // e.printStackTrace();
           } catch (TransformerFactoryConfigurationError e) {
               // TODO Auto-generated catch block
              // e.printStackTrace();
           } catch (TransformerException e) {
               // TODO Auto-generated catch block
               
           }
           return format.getWriter().toString();
       }
       
}

