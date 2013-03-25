package Entities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class HTML_Editor {
	
	private ArrayList<Document> docs;
	private int currentDoc;
	
	public HTML_Editor(){
		
	}
	
	public static void main(String[] args) {
		HTML_Editor e = new HTML_Editor();
		e.launch();
	}
    
    public void newDocument() {
    	Document doc = new Document("newDoc.html");
    	docs.add(doc);
    }
    
    public void openDocument(String fileName) {
    	Document openedDoc = new Document(fileName);
    	docs.add(openedDoc);
    }
    
    public void closeDocument(int i) {
    	docs.get(i).close();
    	docs.remove(i);
    }
    
    public void terminate(){
    	
    }
    
    public void launch() {
    	new EditorGUI(this);
    }

}
