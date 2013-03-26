
package Entities;


import java.util.Vector;

import javax.swing.text.Element;
import javax.swing.text.html.HTML.Tag;
import javax.swing.tree.DefaultMutableTreeNode;


public abstract class HTMLConstruct extends DefaultMutableTreeNode implements Element  {
    
    public HTMLConstruct(javax.swing.text.Document doc, Tag tag,HTMLConstruct parent){
        super(tag);
    }
    
    public HTMLConstruct(javax.swing.text.Document doc, String text,HTMLConstruct parent){
        super(text,false);
    }
    
    public Vector<HTMLComposite> getChildren(){
        return this.children;
    }
    /*public void setNewParent(HTMLConstruct newChild){
        this.theParent = this;
    }*/
       
    /*public ArrayList<HTMLConstruct> getChildren();
    
    public Tag getTag();
    
    public HTMLDocument getDoc(); 
    
   public boolean hasChildren();
   
   public void add(HTML.Tag tag);
   
   public void add(String content);
    */
}

