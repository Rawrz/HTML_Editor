
package Entities;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

public class TreeView extends JPanel {
    private JTree tree;
    private DocumentGUI doc;
    private String title;
    private JScrollPane scrollPane;
    
    public TreeView(DocumentGUI docParam, String titleParam, DefaultMutableTreeNode node){
        setLayout(new BorderLayout());
    	tree = new JTree(node);
    	for (int i = 0; i < tree.getRowCount(); i++) {
            tree.expandRow(i);
    	}
        scrollPane = new JScrollPane(tree);
        add(scrollPane);
        //this.title = titleParam;
        //this.add(tree);
        setPreferredSize(new Dimension(300, 500));
        //his.setVisible(true);
    }

}

