package Entities;

import java.util.*;

public class HTML_Editor {
	
	private ArrayList<Document> docs;
	private int currentDoc;
	
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    
    public void newDocument() {
    	Proxy_Document proxy = new Proxy_Document();
    	docs.add(proxy);
    }
    
    public void openDocument() {
    	
    }
    
    public void closeDocument(int i) {
    	docs.get(i).close();
    	docs.remove(i);
    }
    
    public void terminate(){
    	
    }

}

