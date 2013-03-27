package Entities;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

import java.io.FileInputStream;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.html.HTML.Tag;
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
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;


public class TheDocument extends DefaultStyledDocument{
	
	private boolean isWrapped;
	private boolean isIndented;
	private boolean isSaved;
	private String name;
	private File file;
	private String filepath;
	private Document domDoc;
	private Node tree;
	private Queue<String> queue = new LinkedList<String>();
	private Stack<String> stack = new Stack<String>();
	private String xml;
    
	
	
	public TheDocument(String htmlFile) {
	    
		    file = new File(htmlFile);
    		isWrapped = false;
    		isIndented = false;
    		isSaved = true;
    		name = file.getName();
    		filepath = htmlFile;
    		
    		if(!file.exists()){
                try {
                    file.createNewFile();
                    DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
                    DocumentBuilder builder = fact.newDocumentBuilder();
                    //System.out.println(file.exists());
                    domDoc = builder.newDocument();
                } catch (IOException e) {
                    System.out.println("Cannot create new file.");
                } catch (ParserConfigurationException e) {
                    // TODO Auto-generated catch block
                    System.out.println("Didn't Parse right");
                }
            }
    		else{
    		//Testing stream
        		try{
            		DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
            		DocumentBuilder builder = fact.newDocumentBuilder();
            		//System.out.println(file.exists());
            		domDoc = builder.parse(file);		
            		tree = domDoc.getDocumentElement();
        		}catch(Exception e){
        		    
        		}
    		}
    		
    		FileInputStream stream = null;
    		try {
    		     stream = new FileInputStream(file);
    		  
    		    FileChannel fc = stream.getChannel();
    		    MappedByteBuffer bb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());
    		    // Instead of using default, pass in a decoder. */
    		    //System.out.print(Charset.defaultCharset().decode(bb).toString());
    		    setXml(Charset.defaultCharset().decode(bb).toString(),"2");
    		  } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
    		  finally {
    		    try {
                    stream.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
    		  }

		
	}
		
	
	public void insert(Tag tag){
	    
	}
	


	public void cut() {
		
		
	}

	
	public void paste() {
		// TODO Auto-generated method stub
		
	}

	
	public void save() {
		if (isSaved) {
			return;
		}
		else {
			//To Add
		}
	}

	
	public void saveAs() {
		save();
		
	}

	
	public void close() {
		// TODO Auto-generated method stub
		
	}
	
	public void indent() {
		if (isIndented) {
			//To Add
		}
		else {
			return;
		}
	}
	
	public void toggleWrap() {
		if (isWrapped == true){
			isWrapped = false;
		}else{
			isWrapped = true;
		}
	}
	
	public void toggleIndent() {
		if (isIndented == true){
			isIndented = false;
		}else{
			isIndented = true;
		}
	}
	
	public boolean getWrap() {
		return this.isWrapped;
	}
	
	public boolean getIndent() {
		return this.isIndented;
	}
	
	public boolean getSaved() {
		return this.isSaved;
	}
	public String getName() {
		return this.file.getName();	
	}
	
	public Node getNode(){
	   return this.tree;
	}
	
	
	public String getXml(){
	    return this.xml;
	}
	
	public void setXml(String xml,String indent){

	        System.out.print(xml);
	        SAXParserFactory factory = SAXParserFactory.newInstance();
	        factory.setNamespaceAware(false);
	        factory.setValidating(false);
	        
            try {
                XMLReader reader  = factory.newSAXParser().getXMLReader();
	        Source xmlInput = new SAXSource(reader, new InputSource(new StringReader(xml)));
	        StringWriter stringWriter = new StringWriter();
	        StreamResult xmlPretty = new StreamResult(stringWriter);   
	        Transformer transformer = TransformerFactory.newInstance().newTransformer();
	        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	        transformer.setOutputProperty(OutputKeys.METHOD, "html");
	        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
	        transformer.transform(xmlInput, xmlPretty);
	        this.xml = xmlPretty.getWriter().toString();
            } catch (SAXException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (ParserConfigurationException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (TransformerConfigurationException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (TransformerFactoryConfigurationError e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (TransformerException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
	    
	}
	
	/*public void createQueue(Node node){
	    if(node.getNodeType() == Node.ELEMENT_NODE){
    	    queue.add("<"+node.getNodeName()+">");
    	    System.out.println("<"+node.getNodeName()+">");
    	    if(!node.getNodeName().equals("br")){
    	        stack.push("</"+node.getNodeName()+">");
    	    }
	    }
	    else{
	        queue.add(node.getTextContent());
	    }
	    NodeList nl = node.getChildNodes();
	    for (int i = 0; i < nl.getLength(); i++) {
	        Node x = nl.item(i);
	        createQueue(x);
	    }
	    
	    
	}*/

	public static void main(String args[]){
	    TheDocument doc = new TheDocument("src/Entities/crap.txt");
	    System.out.println(doc.getXml());
	    //OutputStream out = n();
	    
	    

	    
	    //System.out.println(doc.getNode().getNodeName());
	}
}
