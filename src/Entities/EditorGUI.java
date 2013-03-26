package Entities;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;

import Commands.*;

public class EditorGUI extends JFrame{
	
	private HTML_Editor editor;
	private EditorMenu editorMenu;
	private JPanel menuPanel = new JPanel(new GridLayout(1, 4));
	private JTabbedPane docsPanel = new JTabbedPane();
	private JPanel bottomPanel = new JPanel();
	private JButton newDocBtn = new JButton("New Doc");
	private JButton openDocBtn = new JButton("Open Doc");
	private JButton closeDocBtn = new JButton("Close Doc");
	private JButton terminateBtn = new JButton("Close Program");
	private JFileChooser fileChooser;
	
	
	public EditorGUI(HTML_Editor htmlEditor){
		editor = htmlEditor;
		editorMenu = createEditorMenu();
		EditorMenuListener editMenuListener = new EditorMenuListener();
		BorderLayout thisLayout = new BorderLayout();
		this.setLayout(thisLayout);
		
		//File Chooser
		fileChooser = new JFileChooser();
		HTMLFileFilter htmlFilter = new HTMLFileFilter();
		fileChooser.setFileFilter(htmlFilter);
		
		//Add Listeners
		newDocBtn.addActionListener(editMenuListener);
		openDocBtn.addActionListener(editMenuListener);
		
		menuPanel.add(newDocBtn);
		menuPanel.add(openDocBtn);
		menuPanel.add(closeDocBtn);
		menuPanel.add(terminateBtn);
		add(menuPanel, thisLayout.NORTH);
		
		add(docsPanel, thisLayout.CENTER);
		
		bottomPanel.add(new JLabel("Copyright 2013 TKO Productions"));
		add(bottomPanel, thisLayout.SOUTH);
		
		//Window Settings
		setTitle("HTML Editor");
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	private EditorMenu createEditorMenu(){
		NewCommand newFile = new NewCommand(editor);
		OpenCommand open = new OpenCommand(editor);
		CloseCommand close = new CloseCommand(editor);
		TerminateCommand terminate = new TerminateCommand(editor);
		EditorMenu editorMenu = new EditorMenu(newFile,open,close,terminate);
		return editorMenu;
	}
	
	private void newDocumentGUI(File fileParam) {
		Document newDoc = editor.newDocument(fileParam);
		docsPanel.add(new DocumentGUI(newDoc));
		revalidate();
		repaint();
		pack();
	}
	
	private class EditorMenuListener implements ActionListener{
		
		private JFrame newDocGUI;
		private JTextField newDocField;
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String action = e.getActionCommand();
			if (action == "New Doc"){
				newDocGUI = new JFrame("New Document");
				JLabel newdocLabel = new JLabel("Document Name: ");
				newDocField = new JTextField();
				JLabel fileTypeLabel = new JLabel(".html");
				JButton createNewBtn = new JButton("Accept");
				JButton cancelBtn = new JButton("Cancel");
				createNewBtn.addActionListener(new NewDocListener());
				cancelBtn.addActionListener(new NewDocListener());
				
				newDocGUI.setLayout(new GridLayout(2, 3));
				newDocGUI.add(newdocLabel);
				newDocGUI.add(newDocField);
				newDocGUI.add(fileTypeLabel);
				newDocGUI.add(createNewBtn);
				newDocGUI.add(new JLabel());
				newDocGUI.add(cancelBtn);
				
				newDocGUI.setResizable(false);
				newDocGUI.setLocationRelativeTo(null);
				newDocGUI.pack();
				newDocGUI.setVisible(true);
				
			} else if(action == "Open Doc"){
				HTMLFileFilter htmlFilter = new HTMLFileFilter();
				fileChooser = new JFileChooser();
				fileChooser.setFileFilter(htmlFilter);
		        int returnValue = fileChooser.showOpenDialog(null);
		        if (returnValue == JFileChooser.APPROVE_OPTION) {
		          File selectedFile = fileChooser.getSelectedFile();
		        }
			} else if(action == "Close Doc"){
				
			}
		}
		
		private class NewDocListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				String action = e.getActionCommand();
				if (action == "Accept") {
					if ((newDocField.getText().matches("[a-zA-Z0-9]+")) && (newDocField.getText().length() > 0)) {
						String newDocName = newDocField.getText() + ".html";
						EditorGUI.this.newDocumentGUI(new File(newDocName));
						newDocGUI.dispose();
					}
				}
				else {
					newDocGUI.dispose();
				}
			}
		}
		
	}
	
	private class HTMLFileFilter extends FileFilter{

		@Override
		public boolean accept(File f) {
			return f.isDirectory() || f.getName().toLowerCase().endsWith(".html");
		}

		@Override
		public String getDescription() {
			return ".html limiter";
		}
		
	}
}