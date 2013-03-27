package Entities;

import java.util.*;

public class HTML_Editor extends Observable{
	
	private ArrayList<TheDocument> docs;
	private int currentDoc;
	
	public HTML_Editor(){
		docs = new ArrayList<TheDocument>();
	}
	
	public static void main(String[] args) {
		HTML_Editor e = new HTML_Editor();
		e.launch();
	}

    public void newDocument(String htmlFilePath) {
    	TheDocument newDoc = new TheDocument(htmlFilePath);
    	docs.add(newDoc);
    	Integer location = new Integer(docs.size() -1); 
    	setChanged();
    	notifyObservers(location);
    }

    public void openDocument(String htmlFilePath) {
    	TheDocument openedDoc = new TheDocument(htmlFilePath);
    	docs.add(openedDoc);
    	Integer location = new Integer(docs.size()-1);
    	setChanged();
    	notifyObservers(location);
    }
    
    public void closeDocument(int i) {
    	docs.get(i).close();
    	docs.remove(i);
    	setChanged();
    	notifyObservers(i);
    }
    
    public void terminate(){
    	for (int i=0;i<docs.size();i++){
    		closeDocument(i);
    	}
    }
    
    public void launch() {
    	new EditorGUI(this);
    }
    
    public ArrayList<TheDocument> getDocs(){
    	return docs;
    }
    
    public int getCurDoc(){
        return currentDoc;
    }

}
