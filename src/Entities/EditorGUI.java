package Entities;

import java.awt.*;
import javax.swing.*;
import Commands.*;

public class EditorGUI extends JFrame{
	
	private HTML_Editor editor;
	private EditorMenu editorMenu;
	private Container container = getContentPane();
	
	
	public EditorGUI(HTML_Editor htmlEditor){
		editor = htmlEditor;
		editorMenu = createEditorMenu();
		
		//Window Settings
		setTitle("HTML Editor");
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public static void main(String[] args) {
		HTML_Editor aEditor = new HTML_Editor();
		new EditorGUI(aEditor);

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