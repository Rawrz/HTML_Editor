package GUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.text.html.HTML.Tag;

/**
 * @author Ben Kantor (bdk3079@rit.edu) *
 */
@SuppressWarnings("serial")
public class SimpleTagButton extends JButton{
	
	private Tag tag;
	private JTextArea textArea;
	
	public SimpleTagButton(JTextArea jTextArea,String buttonName,Tag htmlTag){
		super(buttonName);
		textArea = jTextArea;
		tag = htmlTag;
		setPreferredSize(new Dimension(25,25));
		if (tag.isBlock()){
			BlockListener blockListener = new BlockListener();
			addActionListener(blockListener);
		} else{		
			SimpleListener buttonListener = new SimpleListener();
			addActionListener(buttonListener);
		}
	}
	
	private class SimpleListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			int pos = textArea.getCaretPosition();
			String insertString = "<"+tag.toString()+"> </"+tag.toString()+">";
			textArea.insert(insertString, pos);
		}
		
	}
	
	private class BlockListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			int pos = textArea.getCaretPosition();
			String insertString = "\n\t<"+tag.toString()+">\n\n\t</"+tag.toString()+">";
			textArea.insert(insertString, pos);
		}
		
	}
	
	
}
