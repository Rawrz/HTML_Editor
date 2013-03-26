package Entities;

import java.util.ArrayList;

import javax.swing.text.AttributeSet;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTML.Tag;
import javax.swing.text.html.HTMLDocument.RunElement;

public class HtmlText extends HTMLConstruct {

    private Tag tag;
    private Document doc;
    String text;
    HTMLConstruct parent;
    
    public HtmlText(Document doc, String text, HTMLConstruct parent) {
        super(doc, text, parent);
        this.parent = parent;
        this.text = text;
        this.doc = doc;
        this.tag = Tag.CONTENT;
        // TODO Auto-generated constructor stub
    }

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
        return null;
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
    
   /* public HtmlText(HTMLDocument htmlDocument, HTMLConstruct parent, Tag eTag, AttributeSet arg1, int arg2, int arg3) {
        htmlDocument.super(parent, arg1, arg2, arg3);
        
        tag = eTag;
        doc = htmlDocument;
    }

    @Override
    public Tag getTag() {
        // TODO Auto-generated method stub
        return this.tag;
    }

    @Override
    public HTMLDocument getDoc() {
        // TODO Auto-generated method stub
        return doc;
    }
    
    public ArrayList<HTMLConstruct> getChildren(){
        return null;
    }
    
    public boolean hasChildren(){
        return false;
    }

    @Override
    public void add(Tag tag) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void add(String content) {
        // TODO Auto-generated method stub
        
    }*/

}
