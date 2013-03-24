package Entities;

import java.awt.*;
import javax.swing.*;

public class EditorGUI extends JFrame{
	
	private HTML_Editor editor;
	private Container container = getContentPane();
	
	public EditorGUI(HTML_Editor htmlEditor){
		editor = htmlEditor;
		
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
}