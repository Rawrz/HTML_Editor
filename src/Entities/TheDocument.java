package Entities;

import java.awt.BorderLayout;
import java.awt.Container;
import java.io.BufferedReader;
import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.logging.XMLFormatter;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Element;
import javax.swing.text.html.HTML.Tag;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


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
                    e.printStackTrace();
                }
            }
    		else{
    		//Testing stream
        		try{
            		DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
            		DocumentBuilder builder = fact.newDocumentBuilder();
            		//System.out.println(file.exists());
            		domDoc = builder.parse(file);
            		//System.out.print("CRAP");
            		tree = domDoc.getDocumentElement();
        		}catch(Exception e){
        		    System.out.println("Crap Something didn't bode well.");
        		}
    		}
    		FileInputStream stream = null;
    		try {
    		     stream = new FileInputStream(file);
    		  
    		    FileChannel fc = stream.getChannel();
    		    MappedByteBuffer bb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());
    		    /* Instead of using default, pass in a decoder. */
    		    xml = Charset.defaultCharset().decode(bb).toString();
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
	
	public void changeWrap(boolean wrapParam) {
		isWrapped = wrapParam;
	}
	
	public void changeIndent(boolean indentParam) {
		isIndented = indentParam;
	}
	
	public boolean getWrap() {
		return isWrapped;
	}
	
	public boolean getIndent() {
		return isIndented;
	}
	
	public boolean getSaved() {
		return isSaved;
	}
	public String getName() {
		return file.getName();	
	}
	
	public Node getNode(){
	   return this.tree;
	}
	
	
	public String getXml(){
	    return xml;
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
	    //doc.createQueue(node);
	    /*TreeNode tree =  new DefaultMutableTreeNode(node);
	    JTree j = new JTree(tree);
	    JFrame f = new JFrame();
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    Container content = f.getContentPane();
	    JScrollPane scrollPane = new JScrollPane(j);
	    content.add(scrollPane, BorderLayout.CENTER);
	    f.setSize(300, 200);
	    f.setVisible(true);*/
	    

	    
	    //System.out.println(doc.getNode().getNodeName());
	}
}
