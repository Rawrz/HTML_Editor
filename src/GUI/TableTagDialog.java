package GUI;

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
public class TableTagDialog extends JDialog{
	
	private JPanel myPanel;
	private JButton createButton, cancelButton;
	private JSpinner rowSpinner, colSpinner;
	
	private JTextArea textArea;
	private TableDialogListener dialogListener = new TableDialogListener();
	
	public TableTagDialog(Frame aFrame,JTextArea theTextArea){
		super(aFrame, true);
		textArea = theTextArea;
		
		//Setup Components
		JLabel row = new JLabel("Rows:");
		JLabel col = new JLabel("Cols:");
		createButton = new JButton("Create");
		createButton.addActionListener(dialogListener);		
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(dialogListener);
		rowSpinner = new JSpinner();
		colSpinner = new JSpinner();
		//Setup Panel 
		myPanel = new JPanel(new GridLayout(3,1));
		JPanel spinnerPanel = new JPanel(new GridLayout(1,4));
		spinnerPanel.add(row);
		spinnerPanel.add(rowSpinner);
		spinnerPanel.add(col);
		spinnerPanel.add(colSpinner);
		JPanel buttonPanel = new JPanel(new GridLayout(1,2));
		buttonPanel.add(createButton);
		buttonPanel.add(cancelButton);
		
		myPanel.add(spinnerPanel);
		myPanel.add(buttonPanel);
		getContentPane().add(myPanel);
		
	}
	
	/**
	 * Generated the String representing the html table
	 * @param rows
	 * @param cols
	 * @return
	 */
	private String outputTable(int rows, int cols){
		String output = "\n\t<table>";
		for (int i = 0;i < rows; i++){
			output += "\n\t\t<tr>";
			for (int j = 0; j < cols; j++){
				output += "\n\t\t\t<td></td>";
			}
			output += "\n\t\t</tr>";
		}
		output += "\n\t</table>";
		return output;
	}
	
	/**
	 * Action Listener for the Dialog
	 * @author Ben Kantor (bdk3079@rit.edu)
	 */
	private class TableDialogListener implements ActionListener{
		
		
		@Override
		public void actionPerformed(ActionEvent e){
			if(createButton == e.getSource()){
				Integer cols = (Integer) colSpinner.getValue();
				Integer rows = (Integer) rowSpinner.getValue();
				String output = outputTable(rows,cols);
				textArea.insert(output,textArea.getCaretPosition());
				dispose();
			} else{
				dispose();
			}
		}
		
	}
}
