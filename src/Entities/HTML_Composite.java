
package Entities;

import javax.swing.text.*;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLDocument.*;


public class HTML_Composite extends BlockElement{
    
    private BlockElement element;
    private HTML.Tag tag;
    
    public HTML_Composite(HTMLDocument htmlDocument, Element ele, AttributeSet a, HTML.Tag eTag) {
        htmlDocument.super(ele, a);
        tag = eTag;
    }
    
    public String getTag(){
        return tag.toString();
    }
    
    public Element getElement(){
        return element;
    }
    
    
}

