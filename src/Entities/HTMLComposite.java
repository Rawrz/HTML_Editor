
package Entities;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.text.*;
import javax.swing.text.Document;
import javax.swing.text.html.HTML.Tag;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLDocument.BlockElement;


public class HTMLComposite extends HTMLConstruct{
    //private Vector<HTMLConstruct> theChildren;
    private Tag tag;
    private Document doc;
    HTMLConstruct parent;
    //HTMLComposite theParent;
    
    public HTMLComposite(Document doc, Tag tag, HTMLConstruct parent) {
        super(doc, tag, parent);
        //this.theParent = parent;
        this.doc = doc;
        this.tag = tag;
        this.parent = parent;
        //this.theChildren = new Vector<HTMLConstruct>();
    }
    
    @Override
    public AttributeSet getAttributes() {
        // TODO Auto-generated method stub
        
        return null;
    }
    @Override
    public Document getDocument() {
        // TODO Auto-generated method stub
        return this.doc;
    }
    @Override
    public Element getElement(int index) {
        // TODO Auto-generated method stub
        //return this.theChildren.get(index);
        return (HTMLConstruct) this.getChildAt(index);
    }
    @Override
    public int getElementCount() {
        // TODO Auto-generated method stub
        return this.getChildCount();
    }
    @Override
    public int getElementIndex(int offset) {
        // TODO Auto-generated method stub
        return 0;
    }
    @Override
    public int getEndOffset() {
        // TODO Auto-generated method stub
        return 0;
    }
    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return tag.toString();
    }
    @Override
    public Element getParentElement() {
        // TODO Auto-generated method stub
        //return this.theParent;
        return (HTMLComposite) this.getParent();
    }
    @Override
    public int getStartOffset() {
        // TODO Auto-generated method stub
        return 0;
    }
    
    /*@SuppressWarnings("unchecked")
    public void add(HTMLConstruct newChild){
        this.add(newChild);
        children.addElement(newChild);
    }*/
    
    /*public HTMLComposite(HTMLDocument htmlDocument, HTMLConstruct ele, AttributeSet a, Tag eTag) {
        htmlDocument.super(ele, a);
        tag = eTag;
        children = new ArrayList<HTMLConstruct>();
        doc = htmlDocument;
    }

    public void add(HTML.Tag tag) {
        HTMLComposite ele = new HTMLComposite(doc,this,null,tag);
        children.add(ele); 
    }
    
    public void add(String content){
        HtmlText ele = new HtmlText(doc,this,Tag.CONTENT,null, 0 , 0);
        children.add(ele);
    }
    
    public ArrayList<HTMLConstruct> getChildren(){
        return this.children;
    }

    @Override
    public Tag getTag() {
        // TODO Auto-generated method stub
        return this.tag;
    }

    @Override
    public HTMLDocument getDoc() {
        // TODO Auto-generated method stub
        return this.doc;
    }
    
    public boolean hasChildren(){
        if (this.children.size() == 0){
            return false;
        }
            return true;
    }
    
    public void printChildren(){
        for(int i = 0 ; i < children.size(); i++){
            children.get(i).getTag();
        }
    }*/
}


