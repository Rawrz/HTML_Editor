
package Entities;

import java.util.ArrayList;

import javax.swing.text.*;
import javax.swing.text.html.HTML.Tag;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLDocument.BlockElement;


public class HTMLComposite extends BlockElement implements HTMLConstruct{
    
    private ArrayList<HTMLConstruct> children;
    private Tag tag;
    private HTMLDocument doc;
    
    public HTMLComposite(HTMLDocument htmlDocument, HTMLConstruct ele, AttributeSet a, Tag eTag) {
        htmlDocument.super(ele, a);
        tag = eTag;
        children = new ArrayList<HTMLConstruct>();
        doc = htmlDocument;
    }

    @Override
    public void add(HTML.Tag tag) {
        HTMLComposite ele = new HTMLComposite(doc,this,null,tag);
        children.add(ele);
    }
    
    public void add(String content){
        HtmlText ele = new HtmlText(doc,this,null, 0 , 0);
        children.add(ele);
    }
    
    public static void main(String args[]){
        
    }

}


