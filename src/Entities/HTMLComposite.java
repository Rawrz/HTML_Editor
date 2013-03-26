
package Entities;

import javax.swing.text.*;
import javax.swing.text.Document;
import javax.swing.text.html.HTML.Tag;

public class HTMLComposite extends HTMLConstruct{
    //private Vector<HTMLConstruct> theChildren;
    
    //HTMLComposite theParent;
    
    public HTMLComposite(Document doc, Tag tag, HTMLConstruct parent) {
        super(doc, tag, parent);
        //this.theParent = parent;
        
        //this.theChildren = new Vector<HTMLConstruct>();
    }
    
    @Override
    public AttributeSet getAttributes() {
        // TODO Auto-generated method stub
        
        return null;
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


