package GUI;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * Custom Dialog menu for tables
 * @author Ben Kantor (bdk3079@rit.edu) *
 */
@SuppressWarnings("serial")
public class HeaderTagDialog extends JDialog{
	
	private JPanel myPanel;
	private JRadioButton h1,h2,h3,h4,h5,h6;
	private JButton createButton, cancelButton;
	private ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField = new JTextField(35);
	
	private JTextArea textArea;
	private HeaderDialogListener dialogListener = new HeaderDialogListener();
	private ButtonGroupListener buttonListener = new ButtonGroupListener();
	private String selectedTag = "";
	
	/**
	 * Constructor for dialog
	 * @param aFrame Parent frame for dialog
	 * @param theTextArea TextArea where tag is being inserted
	 */
	public HeaderTagDialog(Frame aFrame,JTextArea theTextArea){
		super(aFrame, true);
		textArea = theTextArea;
		
		//Setup Components
		createButton = new JButton("Create");
		createButton.addActionListener(dialogListener);		
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(dialogListener);
		h1 = new JRadioButton("h1");
		h1.addActionListener(buttonListener);
		buttonGroup.add(h1);
		h2 = new JRadioButton("h2");
		h2.addActionListener(buttonListener);
		buttonGroup.add(h2);
		h3 = new JRadioButton("h3");
		h3.addActionListener(buttonListener);
		buttonGroup.add(h3);
		h4 = new JRadioButton("h4");
		h4.addActionListener(buttonListener);
		buttonGroup.add(h4);
		h5 = new JRadioButton("h5");
		h5.addActionListener(buttonListener);
		buttonGroup.add(h5);
		h6 = new JRadioButton("h6");
		h6.addActionListener(buttonListener);
		buttonGroup.add(h6);
		JPanel headType = new JPanel(new FlowLayout());
		headType.add(h1);
		headType.add(h2);
		headType.add(h3);
		headType.add(h4);
		headType.add(h5);
		headType.add(h6);
		JPanel buttonPanel = new JPanel(new GridLayout(1,2));
		buttonPanel.add(createButton);
		buttonPanel.add(cancelButton);
		
		myPanel = new JPanel(new GridLayout(3,1));
		myPanel.add(headType);
		myPanel.add(textField);
		myPanel.add(buttonPanel);
		getContentPane().add(myPanel);
	}
	
	/**
	 * Action Listener for the Dialog
	 * @author Ben Kantor (bdk3079@rit.edu)
	 */
	private class HeaderDialogListener implements ActionListener{
		
		
		@Override
		public void actionPerformed(ActionEvent e){
			if(createButton == e.getSource()){
				String output = "\n<"+selectedTag+">" + textField.getText() + "</" + selectedTag +">";
				textArea.insert(output,textArea.getCaretPosition());
				dispose();
			} else{
				dispose();
			}
		}
		
	}
	
	/**
	 * Custom Action Listener for Header Type selection button group
	 * @author Ben Kantor (bdk3079@rit.edu)
	 *
	 */
	private class ButtonGroupListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String source = e.getActionCommand();
			selectedTag = source;
		}
		
	}
}
