package Entities;

import java.util.ArrayList;

import javax.swing.text.AttributeSet;
import javax.swing.text.Element;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTML.Tag;
import javax.swing.text.html.HTMLDocument.RunElement;

public class HtmlText extends RunElement implements HTMLConstruct {

    private Tag tag;
    private HTMLDocument doc;
    
    public HtmlText(HTMLDocument htmlDocument, HTMLConstruct parent, Tag eTag, AttributeSet arg1, int arg2, int arg3) {
        htmlDocument.super(parent, arg1, arg2, arg3);
        
        tag = eTag;
        doc = htmlDocument;
    }

    @Override
    public Tag getTag(Tag tag) {
        // TODO Auto-generated method stub
        return this.tag;
    }

    @Override
    public HTMLDocument getDoc() {
        // TODO Auto-generated method stub
        return doc;
    }

}
