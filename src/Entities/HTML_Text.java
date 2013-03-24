package Entities;

import javax.swing.text.AttributeSet;
import javax.swing.text.Element;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLDocument.RunElement;

public class HTML_Text extends RunElement{
    
    private RunElement element;
    private HTML.Tag tag;
    private String content;
    
    public HTML_Text(HTMLDocument htmlDocument, Element ele, AttributeSet a, HTML.Tag eTag, String theContent) {
        htmlDocument.super(ele, a, 0, 0);
        tag = HTML.Tag.CONTENT;
        theContent = content;
    }
    
    public String getTag(){
        return tag.toString();
    }
    
    public Element getElement(){
        return element;
    } 
    
    public String getContent(){
        return content;
    }
}
