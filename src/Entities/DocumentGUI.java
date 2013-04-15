package Entities;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import Commands.CutCommand;
import Commands.IndentCommand;
import Commands.InsertCommand;
import Commands.PasteCommand;
import Commands.SaveAsCommand;
import Commands.SaveCommand;
import Commands.ToggleIndentCommand;
import Commands.ToggleWrapCommand;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * GUI for each document
 * @author Chris Timmons
 *
 */
@SuppressWarnings("serial")
public class DocumentGUI extends JPanel{
	
	private TheDocument thisDoc;
	private DocumentMenu docMenu;
	private LinkView linkView;
	
	private JPanel menuPanel,insertPanel,docMenuPanel; 
	private JPanel indentPanel,wordWrapPanel;
	private JButton saveBtn,saveAsBtn,cutBtn,pasteBtn, linkViewBtn;
	private InsertButton insertBoldBtn,insertItalicsBtn,insertHeaderBtn,insertListBtn,insertTableBtn,insertTextBtn;
	private JRadioButton wordWrapOn,wordWrapOff,indentOn,indentOff;
	private JLabel wordWrapLabel = new JLabel("Word-Wrap:      ");
	private JLabel indentLabel = new JLabel("Auto-Indent:      ");
	private final JTextArea textArea;
	
	/**
	 * creates a new GUI for the given document
	 * @param docParam
	 */
	public DocumentGUI(TheDocument docParam) {		
		thisDoc = docParam;
		docMenu = createDocumentMenu(thisDoc);
		
		DocumentMenuListener docMenuListener = new DocumentMenuListener();
		InsertListener insertListener = new InsertListener();
		this.setLayout(new BorderLayout());
		
		//Create Panels
		menuPanel = new JPanel();
		//treePanel = new JPanel();
		insertPanel = new JPanel(new BorderLayout());
		indentPanel = new JPanel(new GridLayout(1,3));
		wordWrapPanel = new JPanel(new GridLayout(1, 3));
		docMenuPanel = new JPanel(new GridLayout(2,1));
		
		
		//Create Buttons
		saveBtn = new JButton("Save");
		saveAsBtn = new JButton("Save As");
		cutBtn = new JButton("Cut");
		pasteBtn = new JButton("Paste");
		linkViewBtn = new JButton("Create Link View");
		
		wordWrapOn = new JRadioButton("On ", true);
		wordWrapOff = new JRadioButton("Off ");
		indentOn = new JRadioButton("On", true);
		indentOff = new JRadioButton("Off");
		
		insertBoldBtn = new InsertButton("<b> Bold </b>","BOLD");
		insertItalicsBtn = new InsertButton("<i> Italic </i>","ITALIC");
		insertHeaderBtn = new InsertButton("<h1> Header </h1>","HEADER");
		insertListBtn = new InsertButton("Insert List","LIST");
		insertTableBtn = new InsertButton("Insert Table","TABLE");
		insertTextBtn = new InsertButton("Text","Tag");
		
		//Add Listeners
		saveBtn.addActionListener(docMenuListener);
		saveAsBtn.addActionListener(docMenuListener);
		cutBtn.addActionListener(docMenuListener);
		pasteBtn.addActionListener(docMenuListener);
		indentOn.addActionListener(docMenuListener);
		indentOff.addActionListener(docMenuListener);
		wordWrapOn.addActionListener(docMenuListener);
		wordWrapOff.addActionListener(docMenuListener);
		
		insertBoldBtn.addActionListener(insertListener);
		insertItalicsBtn.addActionListener(insertListener);
		insertHeaderBtn.addActionListener(insertListener);
		insertListBtn.addActionListener(insertListener);
		insertTableBtn.addActionListener(insertListener);
		insertTextBtn.addActionListener(insertListener);
		linkViewBtn.addActionListener(new ActionListener() {
			/**
			 * Checks if the LinkView for the Current Doc has been created yet. If not, the LinkView is created
			 */
			public void actionPerformed(ActionEvent e) {
				if ((linkView == null) || (!linkView.isShowing())) {
					linkView = new LinkView(DocumentGUI.this, "Link View: " + thisDoc.getName());
				}
			}
		});

		//Define WordWrapPanel		
		wordWrapPanel.add(wordWrapLabel);
		wordWrapPanel.add(wordWrapOn);
		wordWrapPanel.add(wordWrapOff);
		ButtonGroup wordWrapGroup = new ButtonGroup();
		wordWrapGroup.add(wordWrapOn);
		wordWrapGroup.add(wordWrapOff);
		
		//Define IndentWrapPanel
		
		indentPanel.add(indentLabel);
		indentPanel.add(indentOn);
		indentPanel.add(indentOff);
		ButtonGroup indentGroup = new ButtonGroup();
		indentGroup.add(indentOn);
		indentGroup.add(indentOff);
		
		//Define MenuPanel
		menuPanel.setLayout(new GridLayout(1,6));
		menuPanel.add(saveBtn);
		menuPanel.add(saveAsBtn);
		menuPanel.add(cutBtn);
		menuPanel.add(pasteBtn);
		menuPanel.add(indentPanel);
		menuPanel.add(wordWrapPanel);
		
		//Define Insert Panel
		JLabel insertLabel = new JLabel("Insert");
		JPanel insertButtons = new JPanel(new GridLayout(1,6));
		insertButtons.add(insertTextBtn);
		insertButtons.add(insertBoldBtn);
		insertButtons.add(insertBoldBtn);
		insertButtons.add(insertItalicsBtn);
		insertButtons.add(insertHeaderBtn);
		insertButtons.add(insertListBtn);
		insertButtons.add(insertTableBtn);
		insertButtons.add(linkViewBtn);
		insertPanel.add(insertLabel,BorderLayout.NORTH);
		insertPanel.add(insertButtons,BorderLayout.SOUTH);		
		
		//Define docMenuPanel
		docMenuPanel.add(menuPanel);
		docMenuPanel.add(insertPanel);
		
		//Setup Main Panel
		textArea = new JTextArea();
		textArea.setEditable(true);
		textArea.setText(thisDoc.getXml());
		JScrollPane textPane = new JScrollPane(textArea);
		add(docMenuPanel,BorderLayout.NORTH);
		add(textPane,BorderLayout.CENTER);	
		
	}
	
	/**
	 * creates a doc menu for the document
	 * @param theDocument
	 * @return
	 */
	private DocumentMenu createDocumentMenu(TheDocument theDocument){
		CutCommand cut = new CutCommand(theDocument);
		PasteCommand paste = new PasteCommand(theDocument);
		InsertCommand insert = new InsertCommand(theDocument);
		IndentCommand indent = new IndentCommand(theDocument);
		SaveCommand save = new SaveCommand(theDocument);
		SaveAsCommand saveAs = new SaveAsCommand(theDocument);
		ToggleWrapCommand toggleWrap = new ToggleWrapCommand(theDocument);
		ToggleIndentCommand toggleIndent = new ToggleIndentCommand(theDocument);
		DocumentMenu docMenu = new DocumentMenu(cut,paste,insert,indent,save,saveAs,toggleWrap,toggleIndent);
		return docMenu;
	}
	

	/**
	 * Gets the text in the JTextArea
	 * @return the text
	 */
	public String getText() {
		return textArea.getText();
	}
	
	/**
	 * listener for each of the document buttons
	 * @author Chris Timmons
	 *
	 */
	private class DocumentMenuListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String action = e.getActionCommand();
			if(action == "Save"){
			    try {
                    thisDoc.getReader().quickParse(textArea.getText());
                } catch (Exception ex){
                    thisDoc.setWellFormed(false);
                }
			    
			    if(thisDoc.isWellFormed() == true){
			        thisDoc.save(textArea.getText());
			    }
			    else{
			        int dialogButton = JOptionPane.YES_NO_OPTION;
	                int result = JOptionPane.showConfirmDialog (null, "This document is not well formed. To save anyway, click YES. For auto-fix, click NO.","Warning",dialogButton);

			        if (result == JOptionPane.YES_OPTION){
			            thisDoc.save(textArea.getText());
			        }
			        else{
			            thisDoc.setXml(textArea.getText(),"2");
			            textArea.setText(thisDoc.getXml());
			            thisDoc.setWellFormed(true);
			        }
			    }
			} else if(action == "SaveAs"){
			    try {
                    thisDoc.getReader().quickParse(textArea.getText());
                } catch (Exception ex){
                    thisDoc.setWellFormed(false);
                }
                if(thisDoc.isWellFormed() == true){
                    thisDoc.save(textArea.getText());
                }
                else{
                    int dialogButton = JOptionPane.YES_NO_OPTION;
                    int result = JOptionPane.showConfirmDialog (null, "This document is not well formed. To save anyway, click YES. For auto-fix, click NO.","Warning",dialogButton);

                    if (result == JOptionPane.YES_OPTION){
                        thisDoc.save(textArea.getText());
                    }
                    else{
                        thisDoc.setXml(textArea.getText(),"2");
                        textArea.setText(thisDoc.getXml());
                        thisDoc.setWellFormed(true);
                    }
                }
			} else if(action == "Copy"){
			} else if(action == "Cut"){
				docMenu.cut();
			} else if(action == "Paste"){
				docMenu.paste();
			} else if (action == "On "){
				docMenu.toggleWrap();
			} else if (action == "Off "){
				docMenu.toggleWrap();
			} else if (action == "On"){
				docMenu.toggleIndent();
			} else if (action == "Off"){
				docMenu.toggleIndent();
			}
		}		
	}
	
	/**
	 * listener for each of the inserts
	 * @author Chris Timmons
	 *
	 */
	private class InsertListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			InsertButton inB = (InsertButton)e.getSource();
			//String insertTag = inB.getHtmlTag();
			String action = e.getActionCommand();
			int pos = textArea.getCaretPosition();
			if ((action.equals("<b> Bold </b>")) || (action.equals("<i> Italic </i>")) || (action.equals("<h1> Header </h1>"))) {
				docMenu.insert();
				textArea.insert(inB.getName() + "\n", pos);
			}
			else if (action.equals("Insert Table")) {
				textArea.insert("\n\t</table>\n", pos);
				for (int i=0;i<3;i++) {
					textArea.insert("\n\t\t</tr>", pos);
					for (int j=0;j<3;j++) {
						textArea.insert("\n\t\t\t<td></td>", pos);
					}
					textArea.insert("\n\t\t<tr>", pos);
				}
				textArea.insert("\n\t<table>", pos);
			}
			else if (action.equals("Insert List")) {
				textArea.insert("\n\t</ul>\n\n", pos);
				for (int i=0;i<5;i++) {
					textArea.insert("\n\t\t<li></li>", pos);
				}
				textArea.insert("\n\t<ul>", pos);
			}
		}
		
	}
	
	/**
	 * extends JButtons to have names and html tags
	 * @author Chris Timmons
	 *
	 */
    private class InsertButton extends JButton{
		private String htmlTag;
		private String name;
		
		/**
		 * creates the button based on the parameters
		 * @param nameParam
		 * @param tag
		 */
		public InsertButton(String nameParam,String tag){
			super(nameParam);
			name = nameParam;
			htmlTag = tag;
		}
		
		/**
		 * 
		 * @return htmlTag
		 */
		@SuppressWarnings("unused")
        public String getHtmlTag(){
			return htmlTag;
		}
		
		/**
		 * @return name
		 */
		@Override
        public String getName() {
			return name;
		}
	}

	
}
