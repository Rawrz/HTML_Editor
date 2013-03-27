package Entities;

import java.io.BufferedReader;
import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.html.HTML.Tag;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;


public class TheDocument extends DefaultStyledDocument{
	
	private boolean isWrapped;
	private boolean isIndented;
	private boolean isSaved;
	private String name;
	private File file;
	private String filepath;
	private Document domDoc;
	private Node tree;
    
	
	
	public TheDocument(String htmlFile) {
	    
		file = new File(htmlFile);
		isWrapped = false;
		isIndented = false;
		isSaved = true;
		name = file.getName();
		filepath = htmlFile;
		//Testing stream
		try{
    		DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
    		DocumentBuilder builder = fact.newDocumentBuilder();
    		System.out.println(file.exists());
    		domDoc = builder.parse(file);
    		//System.out.print("CRAP");
    		tree = domDoc.getDocumentElement();
		}catch(Exception e){
		    System.out.println("Crap Something didn't bode well.");
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
	
	

	public static void main(String args[]){
	    //TheDocument doc = new TheDocument("src/Entities/herp.txt");
	    
	}
}
