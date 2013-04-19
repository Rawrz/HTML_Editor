package GUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
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
	
	private void launchDialog(Tag tag){
		GeneralTagDialog ghj = new GeneralTagDialog(null,tag,textArea);
		ghj.setLocationRelativeTo(null);
		ghj.pack();
		ghj.setVisible(true);
		
	}
	
	/**
	 * Action Listener for one line HTML tags
	 * @author Ben Kantor(bdk3079@rit.edu)
	 */
	private class SimpleListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			launchDialog(tag);
		}
		
	}
	
	/**
	 * Action Listener for block HTML tags
	 * @author Ben Kantor (bdk3079@rit.edu)
	 */
	private class BlockListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			int pos = textArea.getCaretPosition();
			String insertString = "\n\t<"+tag.toString()+">\n\n\t</"+tag.toString()+">";
			textArea.insert(insertString, pos);
		}
		
	}
	
	private class TableTagListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			int pos = textArea.getCaretPosition();
			String insertString = "\n\t<"+tag.toString()+">\n\n\t</"+tag.toString()+">";
			textArea.insert(insertString, pos);
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
			Object[] choices = {"H1","H2","H3","H4","H5","H6"};
			JOptionPane selector= new JOptionPane(choices);
			int choice = JOptionPane.showOptionDialog(null,null,
													"Header",
													JOptionPane.DEFAULT_OPTION,
													JOptionPane.QUESTION_MESSAGE,													
													null,choices,JOptionPane.UNINITIALIZED_VALUE);
			int pos = textArea.getCaretPosition();
			String insertString = "\n\t<"+tag.toString()+">\n\n\t</"+tag.toString()+">";
			textArea.insert(insertString, pos);
		}
		
	}
	
}
