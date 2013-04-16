
package Entities;

import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class TreeView extends JFrame {
    private JTree tree;
    private DocumentGUI doc;
    private String title;
    
    public TreeView(DocumentGUI docParam, String titleParam, DefaultMutableTreeNode node){
        tree = new JTree(node);
        this.title = titleParam;
        this.add(tree);
        this.setSize(500, 500);
        this.setVisible(true);
    }

}

