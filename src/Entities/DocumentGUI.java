package Entities;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

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
import java.util.Enumeration;


public class DocumentGUI extends JPanel{
	
	private TheDocument thisDoc;
	private DocumentMenu docMenu;
	
	private JPanel menuPanel,treePanel,insertPanel,docMenuPanel; 
	private JPanel indentPanel,wordWrapPanel;
	private JButton saveBtn,saveAsBtn,cutBtn,pasteBtn;
	private InsertButton insertBoldBtn,insertItalicsBtn,insertHeaderBtn,insertListBtn,insertTableBtn,insertTextBtn;
	private JRadioButton wordWrapOn,wordWrapOff,indentOn,indentOff;
	private JLabel wordWrapLabel = new JLabel("Word-Wrap:      ");
	private JLabel indentLabel = new JLabel("Auto-Indent:      ");
	
	
	public DocumentGUI(TheDocument docParam) {		
		thisDoc = docParam;
		docMenu = createDocumentMenu(thisDoc);
		
		DocumentMenuListener docMenuListener = new DocumentMenuListener();
		InsertListener insertListener = new InsertListener();
		this.setLayout(new BorderLayout());
		
		//Create Panels
		menuPanel = new JPanel();
		treePanel = new JPanel();
		insertPanel = new JPanel(new BorderLayout());
		indentPanel = new JPanel(new GridLayout(1,3));
		wordWrapPanel = new JPanel(new GridLayout(1, 3));
		docMenuPanel = new JPanel(new GridLayout(2,1));
		
		
		//Create Buttons
		saveBtn = new JButton("Save");
		saveAsBtn = new JButton("Save As");
		cutBtn = new JButton("Cut");
		pasteBtn = new JButton("Paste");
		
		wordWrapOn = new JRadioButton("On ", true);
		wordWrapOff = new JRadioButton("Off ");
		indentOn = new JRadioButton("On", true);
		indentOff = new JRadioButton("Off");
		
		insertBoldBtn = new InsertButton("<b> Bold </b>","BOLD");
		insertItalicsBtn = new InsertButton("<i> Italic </i>","ITALIC");
		insertHeaderBtn = new InsertButton("Insert Header","HEADER");
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
		insertPanel.add(insertLabel,BorderLayout.NORTH);
		insertPanel.add(insertButtons,BorderLayout.SOUTH);		
		
		//Define docMenuPanel
		docMenuPanel.add(menuPanel);
		docMenuPanel.add(insertPanel);
		
		//Setup Main Panel
		JTextArea textArea = new JTextArea();
		textArea.setEditable(true);
		textArea.setText(thisDoc.getXml());
		textArea.setPreferredSize(new Dimension(200,400));
		JScrollPane textPane = new JScrollPane(textArea);
		add(docMenuPanel,BorderLayout.NORTH);
		add(textPane,BorderLayout.CENTER);		
		   
	}
	
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
	
	private class DocumentMenuListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String action = e.getActionCommand();
			if(action == "Save"){
				docMenu.save();
			} else if(action == "SaveAs"){
				docMenu.saveNew();
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
	
	private class InsertListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			InsertButton inB = (InsertButton)e.getSource();
			String insertTag = inB.getHtmlTag();
			docMenu.insert();
			
			
		}
		
	}
	
	private class InsertButton extends JButton{
		private String htmlTag;
		public InsertButton(String name,String tag){
			super(name);
			htmlTag = tag;
		}
		public String getHtmlTag(){
			return htmlTag;
		}
	}
	
	
}
