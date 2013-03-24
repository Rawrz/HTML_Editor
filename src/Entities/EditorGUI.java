package Entities;

import java.awt.*;
import javax.swing.*;
import Commands.*;

public class EditorGUI extends JFrame{
	
	private HTML_Editor editor;
	private EditorMenu editorMenu;
	private JPanel menuPanel = new JPanel(new GridLayout(1, 4));
	private JTabbedPane docsPanel = new JTabbedPane();
	private JButton newDocBtn = new JButton("New Doc");
	private JButton openDocBtn = new JButton("Open Doc");
	private JButton closeDocBtn = new JButton("Close Doc");
	private JButton terminateBtn = new JButton("Close Program");
	
	
	public EditorGUI(HTML_Editor htmlEditor){
		editor = htmlEditor;
		editorMenu = createEditorMenu();
		BorderLayout thisLayout = new BorderLayout();
		this.setLayout(thisLayout);
		
		//Window Settings
		menuPanel.add(newDocBtn);
		menuPanel.add(openDocBtn);
		menuPanel.add(closeDocBtn);
		menuPanel.add(terminateBtn);
		add(menuPanel, thisLayout.NORTH);
		
		docsPanel.add(new DocumentGUI(new Document("newDoc.html")), "newDoc.html");
		docsPanel.add(new DocumentGUI(new Document("twoDoc.html")), "twoDoc.html");
		add(docsPanel, thisLayout.CENTER);
		
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
}