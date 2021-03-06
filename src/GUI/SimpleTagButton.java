package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.text.html.HTML.Tag;

import Entities.TheDocument;

/**
 * Custom JButton class for tag insertions
 * @author Ben Kantor (bdk3079@rit.edu) *
 */
@SuppressWarnings("serial")
public class SimpleTagButton extends JButton{
	
	private Tag tag;
	private JTextArea textArea;
	private TheDocument thisDoc;
	
	/**
	 * Constructor for a SimpleTagButton
	 * @param jTextArea - JTextArea that the button adds text to
	 * @param buttonName - String representing the button's label
	 * @param htmlTag - Specific HTML tag for the button
	 */
	public SimpleTagButton(JTextArea jTextArea,String buttonName,Tag htmlTag, TheDocument doc){
		super(buttonName);
		textArea = jTextArea;
		tag = htmlTag;		
		thisDoc = doc;
		setBackground(Color.WHITE);
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
		} else if(tag.equals(Tag.A)){
			LinkTagListener linkListener = new LinkTagListener();
			addActionListener(linkListener);
		} else if(tag.equals(Tag.IMG)){
			ImgTagListener imgListener = new ImgTagListener();
			addActionListener(imgListener);
		} else{		
			SimpleListener buttonListener = new SimpleListener();
			addActionListener(buttonListener);
		}
		this.addActionListener(new InsertTagListener());
	}
	
	/**
	 * General dialog for normal tags
	 * @param tag
	 */
	private void launchGenDialog(Tag tag){
		GeneralTagDialog dialog = new GeneralTagDialog(null,tag,textArea);
		dialog.setLocationRelativeTo(null);
		dialog.pack();
		dialog.setVisible(true);
		
	}

	/**
	 * Table dialog for table tag
	 */
	private void launchTableDialog(){
		TableTagDialog dialog = new TableTagDialog(null,textArea);
		dialog.setLocationRelativeTo(null);
		dialog.pack();
		dialog.setVisible(true);
	}
	/**
	 * Dialog for header tag
	 */
	private void launchHeaderDialog(){
		HeaderTagDialog dialog = new HeaderTagDialog(null,textArea);
		dialog.setLocationRelativeTo(null);
		dialog.pack();
		dialog.setVisible(true);
	}
	/**
	 * Dialog for link tag
	 */
	private void launchLinkDialog(){
		LinkTagDialog dialog = new LinkTagDialog(null,textArea);
		dialog.setLocationRelativeTo(null);
		dialog.pack();
		dialog.setVisible(true);
	}
	/**
	 * Dialog fr image tag
	 */
	private void launchImgDialog(){
		ImgTagDialog dialog = new ImgTagDialog(null,textArea);
		dialog.setLocationRelativeTo(null);
		dialog.pack();
		dialog.setVisible(true);
	}
	
	/**
	 * Dialog for list tag
	 */
	private void launchListDialog(){
		ListTagDialog dialog = new ListTagDialog(null,textArea);
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
	/**
	 * listener to launch table tag
	 * @author Roseline Okpara
	 *
	 */
	private class TableTagListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			launchTableDialog();
		}
		
	}
	/**
	 * Dialog to launch list tag dialog
	 * @author Roseline Okpara
	 *
	 */
	private class ListTagListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			launchListDialog();
		}
			
	}
	/**
	 * Dialog to launch Header Tag
	 * @author Roseline Okpara
	 *
	 */
	private class HeaderTagListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			launchHeaderDialog();
		}
		
	}
	
	/**
	 * Dialog tag to launch link dialog
	 * @author Roz
	 *
	 */
	private class LinkTagListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			launchLinkDialog();
		}
		
	}
	/**
	 * Dialog to launch image tag
	 * @author Roseline Okpara
	 *
	 */
	private class ImgTagListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			launchImgDialog();
		}
		
	}
	/**
	 * Creates a momento whenever a tag is inserted.
	 * @author Roseline Okpara
	 *
	 */
	private class InsertTagListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent arg0) {
            thisDoc.setXml(textArea.getText());
            thisDoc.createMomento();
            thisDoc.getCareTaker().storeState(thisDoc.getMomento());
            
        }
	    
	}
	
}
