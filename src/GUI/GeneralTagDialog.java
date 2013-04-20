package GUI;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.html.HTML.Tag;

/**
 * Custom Dialog menu for inserting basic single line and block tags
 * @author Ben Kantor (bdk3079@rit.edu) *
 */
@SuppressWarnings("serial")
public class GeneralTagDialog extends JDialog{
	
	private JPanel jPanel;
	private JButton createButton,cancelButton;
	private Tag tag;
	private JTextField textField;
	private JTextArea theTextArea;
	private GenDialogListener dialogListener = new GenDialogListener();
	
	/**
	 * Constructor for dialog
	 * @param aFrame Parent frame for dialog
	 * @param htmlTag Specific Html tag related to this Dialog
	 * @param textArea TextArea where tag is being inserted
	 */
	public GeneralTagDialog(Frame aFrame,Tag htmlTag,JTextArea textArea){
		super(aFrame, true);
		theTextArea = textArea;
		tag = htmlTag;
		
		//Setup Panel
		jPanel = new JPanel();
		createButton = new JButton("Create");
		createButton.addActionListener(dialogListener);
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(dialogListener);
		textField = new JTextField(40);
		jPanel.add(new JLabel("Set tag text"));
		JPanel buttonPanel = new JPanel(new GridLayout(1,2));
		buttonPanel.add(createButton);
		buttonPanel.add(cancelButton);
		jPanel.add(buttonPanel);
		jPanel.add(textField);
		getContentPane().add(jPanel);				
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	/**
	 * Action Listener for the Dialog
	 * @author Ben Kantor (bdk3079@rit.edu)
	 */
	private class GenDialogListener implements ActionListener{
		
		
		@Override
		public void actionPerformed(ActionEvent e){
			if(createButton == e.getSource()){
				String input = textField.getText();
				String output;
				if (tag.isBlock() == true){
					output = "\n\t<"+tag.toString()+">"+input+"\n\t</"+tag.toString()+">";
				}else{
					output = "<"+tag.toString()+">"+input+"</"+tag.toString() + ">";
				}				
				theTextArea.insert(output,theTextArea.getCaretPosition());
				dispose();
			} else{
				dispose();
			}
		}
		
	}
}
