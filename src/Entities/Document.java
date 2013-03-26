package Entities;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.text.html.HTML.Tag;
import javax.swing.text.html.HTMLDocument;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

public class Document extends HTMLDocument{
	
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
		
	public Document(String newFileName){
	    tree = new HTMLComposite(this,Tag.HTML,null);
	    HTMLConstruct bod = new HTMLComposite(this,Tag.BODY,tree);
	    HTMLConstruct p = new HTMLComposite(this,Tag.P,bod);
        HTMLConstruct h1 = new HTMLComposite(this,Tag.H1,bod);
        tree.add(bod);
        bod.add(p);
        bod.add(h1);
        HtmlText text = new HtmlText(this, "Blahblahblah",p);
        p.add(text);
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

	/*public static void main(String args[]){
	    Document doc = new Document("Test");
	    HTMLConstruct tree = doc.getTree();
	    JFrame f = new JFrame();
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    Container content = f.getContentPane();
	    JTree t = new JTree(tree);
	    JScrollPane scrollPane = new JScrollPane(t);
	    content.add(scrollPane, BorderLayout.CENTER);
	    f.setSize(300, 200);
	    f.setVisible(true);
	    
	}*/
}
