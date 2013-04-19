
package Entities;
import org.w3c.dom.*;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * 
 * @author Roseline Okpara
 *
 */
public class HtmlTree{
    Document dom;
    public HtmlTree(Document dom){
        this.dom = dom;          
    }
    
    public DefaultMutableTreeNode createTree(){
        Element rootNode = (Element) dom.getFirstChild();
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(rootNode.getTagName());
        Element elm = dom.getDocumentElement();
        if(elm.hasChildNodes()){
            NodeList children = elm.getChildNodes();
            for(int i=0;i<children.getLength();i++){
                Node child = children.item(i);
                traverse(child,root);
            }
        }  
        return root;
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


