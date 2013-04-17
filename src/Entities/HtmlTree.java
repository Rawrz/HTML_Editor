
package Entities;


import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

import java.io.*;

public class HtmlTree extends JFrame{
    Document dom;
    public HtmlTree(Document dom){
        this.dom = dom;          
    }
    
    public DefaultMutableTreeNode createTree(){
        Element rootNode = (Element) dom.getFirstChild();
        DefaultMutableTreeNode node = new DefaultMutableTreeNode(rootNode.getTagName());
        Element elm = dom.getDocumentElement();
        if(elm.hasChildNodes()){
            DefaultMutableTreeNode root = new DefaultMutableTreeNode("<" + elm.getTagName() + ">");
            NodeList children = elm.getChildNodes();
            for(int i=0;i<children.getLength();i++){
                Node child = children.item(i);
                traverse(child,node);
            }
        }  
        return node;
    }

    public void traverse(Node child,DefaultMutableTreeNode parent){
        int type = child.getNodeType();
        if(type == Node.ELEMENT_NODE){
            Element elm = (Element)child;
            DefaultMutableTreeNode node = new DefaultMutableTreeNode("<" + elm.getTagName() + ">");
            parent.add(node);
            if(elm.hasChildNodes()){
                NodeList list = elm.getChildNodes();
                for(int i=0; i<list.getLength(); i++){
                    traverse(list.item(i),node);
                }
            }
        }
        else if(type == Node.TEXT_NODE){
            Text t = (Text)child;
            String textContent = t.getTextContent().trim();
            if(!textContent.equals("")){
                DefaultMutableTreeNode node = new DefaultMutableTreeNode(textContent);
                parent.add(node);
            }
        }
    }
}  


