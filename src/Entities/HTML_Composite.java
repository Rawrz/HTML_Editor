
package Entities;

import javax.swing.text.*;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTML.Tag;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLDocument.*;


public class HTML_Composite extends HTML_Construct{
    
    public HTML_Composite(HTMLDocument htmlDocument, HTML_Construct ele,
            AttributeSet a, Tag eTag) {
        super(htmlDocument, ele, a, eTag);
        // TODO Auto-generated constructor stub
    }

    
    public void add(Tag tag,String content){
        if(tag.equals(Tag.CONTENT) && !content.equals("")){
            HTML_Text ele = new HTML_Text(htmlDoc,this,null,Tag.CONTENT);
            ele.setContent(content);
        }
        else{
            HTML_Composite ele = new HTML_Composite(htmlDoc,this,null,tag);
        }
    }
}

