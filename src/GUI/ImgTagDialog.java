package GUI;


import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class ImgTagDialog extends JDialog{
	private JPanel myPanel;
	private JButton createButton, cancelButton;
	private JTextField srcField,altField;
	private JLabel srcLabel, altLabel;
	
	private JTextArea textArea;
	private ImgDialogListener dialogListener = new ImgDialogListener();
	
	public ImgTagDialog(Frame aFrame,JTextArea theTextArea){
		super(aFrame, true);
		textArea = theTextArea;
		
		//Setup Components
		createButton = new JButton("Create");
		createButton.addActionListener(dialogListener);		
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(dialogListener);
		srcLabel = new JLabel("SRC:");
		altLabel = new JLabel("alt:");
		srcField = new JTextField(30);
		altField = new JTextField(30);
		//Setup Panels
		JPanel hrefPanel = new JPanel(new GridLayout(1,2));
		hrefPanel.add(srcLabel);
		hrefPanel.add(srcField);
		
		JPanel aTagPanel = new JPanel(new GridLayout(1,2));
		aTagPanel.add(altLabel);
		aTagPanel.add(altField);
		
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
	private class ImgDialogListener implements ActionListener{		
		@Override
		public void actionPerformed(ActionEvent e){
			if(createButton == e.getSource()){
				String output = "<img src=\"" + srcField.getText( ) +"\" alt=\""+altField.getText()+"\"></img>";
				textArea.insert(output,textArea.getCaretPosition());
				dispose();
			} else{
				dispose();
			}
		}
		
	}
}
