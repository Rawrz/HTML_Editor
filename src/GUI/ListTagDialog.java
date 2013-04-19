package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * Custom dialog for inserting a table.
 * @author Ben Kantor (bdk3079@rit.edu)
 */
@SuppressWarnings("serial")
public class ListTagDialog extends JDialog{
	
	private JPanel myPanel;
	private JButton createButton, cancelButton;
	private JSpinner itemSpinner;
	private JRadioButton olBtn, ulBtn;
	private ButtonGroup buttonGroup = new ButtonGroup();
	
	private JTextArea textArea;
	private ListDialogListener dialogListener = new ListDialogListener();
	private ButtonGroupListener buttonListener = new ButtonGroupListener();
	private String selectedTag = "";
	
	public ListTagDialog(Frame aFrame,JTextArea theTextArea){
		super(aFrame, true);
		textArea = theTextArea;
		
		//Setup Components
		createButton = new JButton("Create");
		createButton.addActionListener(dialogListener);		
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(dialogListener);
		olBtn = new JRadioButton("ol");
		olBtn.addActionListener(buttonListener);
		buttonGroup.add(olBtn);
		ulBtn = new JRadioButton("ul");
		ulBtn.addActionListener(buttonListener);
		buttonGroup.add(ulBtn);
		JLabel numItemsLabel = new JLabel("Number of List Items");
		itemSpinner = new JSpinner();
		
		//Setup Panel
		JPanel listSelectPanel = new JPanel(new FlowLayout());
		listSelectPanel.add(olBtn);
		listSelectPanel.add(ulBtn);
		
		JPanel itemSelectPanel = new JPanel(new BorderLayout());
		itemSelectPanel.add(numItemsLabel);
		itemSelectPanel.add(itemSpinner);
		
		JPanel buttonPanel = new JPanel(new GridLayout(1,2));
		buttonPanel.add(createButton);
		buttonPanel.add(cancelButton);
		
		myPanel = new JPanel(new GridLayout(3,1));
		myPanel.add(listSelectPanel);
		myPanel.add(itemSelectPanel);
		myPanel.add(buttonPanel);
		
		getContentPane().add(myPanel);
		
	}
	
	private String outputList(int items){
		String output = "\n\t<"+selectedTag+">";
		for (int i = 0;i < items; i++){
			output +="\n\t\t<li></li>";
		}
		output += "\n\t</"+selectedTag+">";
		return output;
	}
	
	/**
	 * Action Listener for the Dialog
	 * @author Ben Kantor (bdk3079@rit.edu)
	 */
	private class ListDialogListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e){
			if(createButton == e.getSource()){
				Integer items = (Integer) itemSpinner.getValue();
				String output = outputList(items);
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
	 */
	private class ButtonGroupListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String source = e.getActionCommand();
			selectedTag = source;
		}
		
	}
}
