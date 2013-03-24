
package Entities;

import javax.swing.text.AttributeSet;
import javax.swing.text.Element;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLDocument.BlockElement;


public abstract class HTML_Construct extends BlockElement{
       
    protected Element parent;
    protected HTML.Tag tag;
    HTMLDocument htmlDoc;
    
    public HTML_Construct(HTMLDocument htmlDocument, HTML_Construct ele, AttributeSet a, HTML.Tag eTag) {
        htmlDocument.super(ele, a);
        tag = eTag;
        parent = ele;
        htmlDoc = htmlDocument;
        
    }
    
    public String getTag() {
        return null;
    }
    
    public Element getElement() {
        return null;
    }

}

