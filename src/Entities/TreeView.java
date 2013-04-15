
package Entities;

import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class TreeView extends JFrame {
    JTree tree;
    
    public TreeView(DefaultMutableTreeNode node){
        tree = new JTree(node);
        this.add(tree);
        this.setSize(500, 500);
        this.setVisible(true);
        this.pack();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}

