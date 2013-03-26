package Entities;

import java.io.BufferedReader;
import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.html.HTML.Tag;


public class Document extends DefaultStyledDocument{
	
	private boolean isWrapped;
	private boolean isIndented;
	private boolean isSaved;
	private String name;
	private File file;
	private String filepath;
	private StringBuffer content = new StringBuffer();
	private HTMLConstruct tree;
	
	
	public Document(File htmlFile) {
	    
		file = htmlFile;
		isWrapped = false;
		isIndented = false;
		isSaved = true;
		name = htmlFile.getName();
		filepath = htmlFile.getPath();	
		/*
		tree = new HTMLComposite(this,Tag.HTML,null);
        HTMLConstruct bod = new HTMLComposite(this,Tag.BODY,tree);
        HTMLConstruct p = new HTMLComposite(this,Tag.P,bod);
        HTMLConstruct h1 = new HTMLComposite(this,Tag.H1,bod);
        tree.add(bod);
        bod.add(p);
        bod.add(h1);
        HTMLText text = new HTMLText(this, "Blahblahblah",p);
        p.add(text);
        */
		//Testing stream
		try{
			BufferedReader fileReader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = fileReader.readLine()) != null){
				content.append(line);
			}
		}
		catch(FileNotFoundException e){		
		}
		catch(IOException e){
			
		}
	}
		
	//Test Constructor
	public Document(String newFileName){
	    
	}
	
	public void insert(Tag tag){
	    
	}
	
	public HTMLConstruct getTree(){
	    return tree;
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
	
	

	public static void main(String args[]){
	   /* Document doc = new Document("Test");
	    HTMLConstruct tree = doc.getTree();
	    JFrame f = new JFrame();
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    Container content = f.getContentPane();
	    JTree t = new JTree(tree);
	    JScrollPane scrollPane = new JScrollPane(t);
	    content.add(scrollPane, BorderLayout.CENTER);
	    f.setSize(300, 200);
	    f.setVisible(true);
	    Enumeration e = tree.preorderEnumeration();
	      
	    while (e.hasMoreElements())  
	    {  
	        HTMLConstruct element = (HTMLConstruct) e.nextElement();  
	        int lvl = element.getLevel();
	        for(int i = 0; i < lvl; i++){
	            System.out.print("  ");
	        }
	        System.out.println(element);
	    }
	    
	*/
	}
}
