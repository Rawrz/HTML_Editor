package GUI;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * Custom Dialog for inserting link tags
 * @author Ben Kantor (bdk3079@rit.edu)
 */
@SuppressWarnings("serial")
public class LinkTagDialog extends JDialog{
	
	private JPanel myPanel;
	private JButton createButton, cancelButton;
	private JTextField hrefField, aTagField;
	private JLabel hrefLabel, aTagLabel;
	
	private JTextArea textArea;
	private LinkDialogListener dialogListener = new LinkDialogListener();
	
	public LinkTagDialog(Frame aFrame,JTextArea theTextArea){
		super(aFrame, true);
		textArea = theTextArea;
		
		//Setup Components
		createButton = new JButton("Create");
		createButton.addActionListener(dialogListener);		
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(dialogListener);
		hrefLabel = new JLabel("Href:");
		aTagLabel = new JLabel("Text:");
		hrefField = new JTextField(30);
		aTagField = new JTextField(30);
		//Setup Panels
		JPanel hrefPanel = new JPanel(new GridLayout(1,2));
		hrefPanel.add(hrefLabel);
		hrefPanel.add(hrefField);
		
		JPanel aTagPanel = new JPanel(new GridLayout(1,2));
		aTagPanel.add(aTagLabel);
		aTagPanel.add(aTagField);
		
		JPanel buttonPanel = new JPanel(new GridLayout(1,2));
		buttonPanel.add(createButton);
		buttonPanel.add(cancelButton);
		
		myPanel = new JPanel(new GridLayout(3,1));
		myPanel.add(hrefPanel);
		myPanel.add(aTagPanel);
		myPanel.add(buttonPanel);
		getContentPane().add(myPanel);
		
	}
	
	/**
	 * Action Listener for the Dialog
	 * @author Ben Kantor (bdk3079@rit.edu)
	 */
	private class LinkDialogListener implements ActionListener{		
		@Override
		public void actionPerformed(ActionEvent e){
			if(createButton == e.getSource()){
				String output = "<a href=\""+hrefField.getText()+"\">"+aTagField.getText()+"</a>";
				textArea.insert(output,textArea.getCaretPosition());
				dispose();
			} else{
				dispose();
			}
		}
		
	}
}
