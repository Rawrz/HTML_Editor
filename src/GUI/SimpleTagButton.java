package GUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.text.html.HTML.Tag;

/**
 * Custom JButton class for tag insertions
 * @author Ben Kantor (bdk3079@rit.edu) *
 */
@SuppressWarnings("serial")
public class SimpleTagButton extends JButton{
	
	private Tag tag;
	private JTextArea textArea;
	
	/**
	 * Constructor for a SimpleTagButton
	 * @param jTextArea - JTextArea that the button adds text to
	 * @param buttonName - String representing the button's label
	 * @param htmlTag - Specific HTML tag for the button
	 */
	public SimpleTagButton(JTextArea jTextArea,String buttonName,Tag htmlTag){
		super(buttonName);
		textArea = jTextArea;
		tag = htmlTag;
		setPreferredSize(new Dimension(25,25));
		if(tag.equals(Tag.TABLE)){
			TableTagListener tableListener = new TableTagListener();
			addActionListener(tableListener);
		} else if (tag.equals(Tag.OL)) {
			ListTagListener listListener = new ListTagListener();
			addActionListener(listListener);
		} else if (tag.equals(Tag.H1)){
			HeaderTagListener headerListener = new HeaderTagListener();
			addActionListener(headerListener);
		} else{		
			SimpleListener buttonListener = new SimpleListener();
			addActionListener(buttonListener);
		}
	}
	
	private void launchGenDialog(Tag tag){
		GeneralTagDialog dialog = new GeneralTagDialog(null,tag,textArea);
		dialog.setLocationRelativeTo(null);
		dialog.pack();
		dialog.setVisible(true);
		
	}
	
	private void launchTableDialog(){
		TableTagDialog dialog = new TableTagDialog(null,textArea);
		dialog.setLocationRelativeTo(null);
		dialog.pack();
		dialog.setVisible(true);
	}
	
	/**
	 * Action Listener for one line HTML tags
	 * @author Ben Kantor(bdk3079@rit.edu)
	 */
	private class SimpleListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			launchGenDialog(tag);
		}
		
	}
	
	private class TableTagListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			launchTableDialog();
		}
		
	}
	
	private class ListTagListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			int pos = textArea.getCaretPosition();
			String insertString = "\n\t<"+tag.toString()+">\n\n\t</"+tag.toString()+">";
			textArea.insert(insertString, pos);
		}
		
	
		
	}
	private class HeaderTagListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

		}
		
	}
	
}
