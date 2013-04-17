package Entities;

import java.util.*;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Main class, runs program and creates GUI
 * @author Rosaline Okpara
 *
 */
public class HTML_Editor extends Observable{
	
	private ArrayList<TheDocument> docs;
	private int currentDoc;
	
	/**
	 * Creates the class and initializes the docList
	 */
	public HTML_Editor(){
		docs = new ArrayList<TheDocument>();
	}
	
	/**
	 * Main method, runs the program
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}
		HTML_Editor e = new HTML_Editor();
		e.launch();
	}
	
	/**
	 * Creates a new document, adds it to the doc list, and updates the EditorGUI
	 * @param htmlFilePath
	 */
    public void newDocument(String htmlFilePath) {
    	TheDocument newDoc = new TheDocument(htmlFilePath);
    	docs.add(newDoc);
    	Integer location = new Integer(docs.size() -1); 
    	setChanged();
    	notifyObservers(location);
    }
    
    /**
     * Opens an existing document, adds it to the doc list, and updates the EditorGUI
     * @param htmlFilePath
     */
    public void openDocument(String htmlFilePath) {
    	TheDocument openedDoc = new TheDocument(htmlFilePath);
    	docs.add(openedDoc);
    	Integer location = new Integer(docs.size()-1);
    	setChanged();
    	notifyObservers(location);
    }
    
    /**
     * closes the document in the index at the given int, updates the EditorGUI
     * @param i
     */
    public void closeDocument(int i) {
    	docs.get(i).close();
    	docs.remove(i);
    	setChanged();
    	notifyObservers(i);
    }
    
    /**
     * closes all documents, closes the program
     */
    public void terminate(){
    	for (int i=0;i<docs.size();i++){
    		closeDocument(i);
    	}
    }
    
    /**
     * creates the GUI
     */
    public void launch() {
    	new EditorGUI(this);
    }
    
    /**
     * 
     * @return list of documents
     */
    public ArrayList<TheDocument> getDocs(){
    	return docs;
    }
    
    /**
     * 
     * @return the current document
     */
    public int getCurDoc(){
        return currentDoc;
    }

}
