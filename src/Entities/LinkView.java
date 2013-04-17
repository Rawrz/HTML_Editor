package Entities;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * LinkView for showing links in the document
 * @author Chris Timmons
 *
 */
@SuppressWarnings("serial")
public class LinkView extends JPanel {
	
	private DocumentGUI doc;
	private JPanel buttons;
	private JButton rfrsh;
	private JRadioButton abc;
	private JRadioButton pos;
	private JTextArea linkArea;
	private String curView;
	
	/**
	 * Creates the View and sets listeners
	 * @param docParam, the docGUI that opened the LinkView
	 * @param titleParam, the Title of the document
	 */
	public LinkView(DocumentGUI docParam, String titleParam) {
		
		doc = docParam;
		
		//Create Components
		setLayout(new BorderLayout());
		buttons = new JPanel();
		abc = new JRadioButton("Sort by Alphabet");
		pos = new JRadioButton("Sort by Position", true);
		rfrsh = new JButton("Refresh");
		ButtonGroup views = new ButtonGroup();
		views.add(abc);
		views.add(pos);
		linkArea = new JTextArea();
		
		//Set Component Behaviors
		linkArea.setEditable(false);
		pos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				curView = "pos";
				displayLinksPosition();
			}
		});
		abc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				curView = "abc";
				displayLinksAlphabet();
			}
		});
		rfrsh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (curView == "abc") {
					displayLinksAlphabet();
				}
				else {
					displayLinksPosition();
				}
			}
		});
		
		//Set Layout of Components
		buttons.setLayout(new FlowLayout());
		buttons.add(rfrsh);
		buttons.add(abc);
		buttons.add(pos);
		
		add(buttons,BorderLayout.NORTH);
		add(linkArea,BorderLayout.CENTER);
		
		//Set Window Behavior
		//setTitle(titleParam);
		//setPreferredSize(new Dimension(500, 500));
		//setResizable(false);
		//pack();
		curView = "pos";
		displayLinksPosition();
		setVisible(true);
		//setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	/**
	 * Sorts the links alphabetically
	 */
	private void displayLinksAlphabet() {
		LinkViewStrategy strategy;
		ArrayList<String> links = new ArrayList<String>();
		strategy = new LinkViewAlphabet();
		links = strategy.getSortedURLs(doc.getText());
		printLinks(links);
	}
	
	/**
	 * Sorts the links by position
	 */
	private void displayLinksPosition() {
		LinkViewStrategy strategy;
		ArrayList<String> links = new ArrayList<String>();
		strategy = new LinkViewPosition();
		links = strategy.getSortedURLs(doc.getText());
		printLinks(links);
	}
	
	/**
	 * Prints the links on the link view
	 * @param links, the list of URLs
	 */
	private void printLinks(ArrayList<String> links) {
		linkArea.setText("");
		for (int i=0; i<links.size(); i++) {
			linkArea.setText(linkArea.getText() + links.get(i) + "\n");
		}
		refresh();
	}
	
	/**
	 * Refreshes the view
	 */
	private void refresh() {
		validate();
		repaint();
	}

}
