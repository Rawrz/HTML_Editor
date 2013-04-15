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
public class LinkView extends JFrame {
	
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
				displayLinks("pos");
			}
		});
		abc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayLinks("abc");
			}
		});
		rfrsh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayLinks(curView);
			}
		});
		
		//Set Layout of Components
		buttons.setLayout(new FlowLayout());
		buttons.add(rfrsh);
		buttons.add(abc);
		buttons.add(pos);
		setLayout(new FlowLayout());
		add(buttons);
		add(linkArea);
		
		//Set Window Behavior
		setTitle(titleParam);
		pack();
		curView = "pos";
		displayLinks(curView);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	/**
	 * Takes in the Document string and displays the links according to the current strategy
	 * @param view, the Document shown on the Doc GUI
	 */
	public void displayLinks(String view) {
		curView = view;
		LinkViewStrategy strategy;
		ArrayList<String> links = new ArrayList<String>();
		if (view == "pos") {
			strategy = new LinkViewPosition();
			links = strategy.getURLs(doc.getText());
		}
		else if (view == "abc") {
			strategy = new LinkViewAlphabet();
			links = strategy.getURLs(doc.getText());
		}
		
		linkArea.setText("");
		for (int i=0; i<links.size(); i++) {
			linkArea.setText(linkArea.getText() + links.get(i) + "\n");
		}
		refresh();
	}
	
	/**
	 * refreshes the view
	 */
	public void refresh() {
		validate();
		repaint();
		pack();
	}

}
