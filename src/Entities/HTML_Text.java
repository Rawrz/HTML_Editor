package Entities;

import javax.swing.text.AttributeSet;
import javax.swing.text.Element;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTML.Tag;

public class HTML_Text extends HTML_Construct{
    
    private String content;
    
    public HTML_Text(HTMLDocument htmlDocument, HTML_Construct ele, AttributeSet a, Tag eTag) {
        super(htmlDocument, ele, a, eTag);
    }
    
    public void setContent(String con){
        content = con;
    }
    public String getContent(){
        return content;
    }
    
    public String getName(){
        return tag.toString(); 
    }
    
    public boolean isLeaf(){
        return true;
    }
   
}
