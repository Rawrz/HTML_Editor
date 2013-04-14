package Entities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.StringReader;
import java.io.StringWriter;

import java.io.FileInputStream;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import javax.swing.text.DefaultStyledDocument;
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

/**
 * document for editing and saving
 * @author Roseline Okpara
 */
@SuppressWarnings("serial")
public class TheDocument {
	
	private boolean isWrapped;
	private boolean isIndented;
	private boolean isSaved;
	private boolean isWellFormed = true;
	private File file;
	private String filepath;
	private Document domDoc;
	private DocumentReader reader;
	private Node tree;
	private String xml;
    
	
	/**
	 * creates the document for the given string
	 * @param htmlFile
	 */
	public TheDocument(String htmlFile) {
	    
		    file = new File(htmlFile);
    		isWrapped = false;
    		isIndented = true;
    		isSaved = true;
    		setName(file.getName());
    		setFilepath(htmlFile);
    		
    		if(!file.exists()){
                try {
                    //Create a new file
                    file.createNewFile();
                    FileWriter fw = new FileWriter(file.getAbsoluteFile());
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write("<html><body> </body></html>");
                    bw.close();
                }
                catch (IOException e) {
                    System.out.println("Cannot create new file.");
                }
            }	
    		//Create the document tree
    		try {
                tree = reader.buildTree(file);
            } catch (Exception e){
                System.err.println("Could not create tree");
            }
    		
    		FileInputStream stream = null;
    		try {
    		    //Make html nice and pretty
    		    stream = new FileInputStream(file);
    		    FileChannel fc = stream.getChannel();
    		    MappedByteBuffer bb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());
    		    xml = reader.parseAndPretty(Charset.defaultCharset().decode(bb).toString(), "2");	    
    		} 
    		catch (IOException e) {
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
	
	public DocumentReader getReader(){
	    return reader;
	}

	public void insert(String tagName){
	    
	}
	


	public void cut() {
		
		
	}

	
	public void paste() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * saves the given text to the file
	 * @param writeText
	 */
	public void save(String writeText) {
		try {
			FileWriter fileWrite = new FileWriter(file);
			BufferedWriter out = new BufferedWriter(fileWrite);
			out.write(writeText);
			out.close();
		} catch (IOException e) {
			System.out.println("File is in use somewhere else");		}
	}

	/**
	 * saves the text
	 * @param writeText
	 */
	public void saveAs(String writeText) {
		save(writeText);
	}

	public void close() {
		
	}
	
	public void indent() {
		if (isIndented) {
			//To Add
		}
		else {
			return;
		}
	}
	
	/**
	 * changes the word wrap for the document
	 */
	public void toggleWrap() {
		if (isWrapped == true){
			isWrapped = false;
		}else{
			isWrapped = true;
		}
	}
	
	/**
	 * changes the indent for the document
	 */
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
	/**
	 * 
	 * @return boolean of well formed
	 */
	public boolean isWellFormed(){
	    return this.isWellFormed;
	}

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setName(String name) {
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


}
