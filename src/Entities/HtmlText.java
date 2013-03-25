package Entities;

import javax.swing.text.AttributeSet;
import javax.swing.text.Element;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTML.Tag;
import javax.swing.text.html.HTMLDocument.RunElement;

public class HtmlText extends RunElement implements HTMLConstruct {

    public HtmlText(HTMLDocument htmlDocument, HTMLConstruct arg0, AttributeSet arg1, int arg2, int arg3) {
        htmlDocument.super(arg0, arg1, arg2, arg3);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void add(HTML.Tag tag) { 
    }  
    
    public void add(String content){
        
    }
}
