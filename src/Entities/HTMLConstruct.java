
package Entities;

import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.Element;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.AbstractDocument.AbstractElement;


public interface HTMLConstruct extends Element{
       
    public void add(HTML.Tag tag);
    
    public void add(String text);
    
    
}

