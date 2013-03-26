
package Entities;

import javax.swing.text.*;
import javax.swing.text.Document;
import javax.swing.text.html.HTML.Tag;

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
    
}


