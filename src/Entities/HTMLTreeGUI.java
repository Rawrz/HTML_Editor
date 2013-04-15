
package Entities;

import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class HTMLTreeGUI extends JFrame {
    JTree tree;
    public HTMLTreeGUI(DefaultMutableTreeNode node){
        tree = new JTree(node);
        this.add(tree);
        this.setVisible(true);
        this.pack();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}

