package Entities;

import javax.swing.*;
import java.awt.*;


public class DocumentGUI extends JPanel{
	
	private Document thisDoc;
	private JPanel menuPanel = new JPanel();
	private JPanel docPanel = new JPanel();
	private JButton saveBtn = new JButton("Save");
	private JButton saveAsBtn = new JButton("Save As");
	private JButton copyBtn = new JButton("Copy");
	private JButton cutBtn = new JButton("Cut");
	private JButton pasteBtn = new JButton("Paste");
	private JButton insertBoldBtn = new JButton("Insert Bold");
	private JButton insertItalicsBtn = new JButton("Insert Italics");
	private JButton insertHeaderBtn = new JButton("Insert Header");
	private JButton insertListBtn = new JButton("Insert List");
	private JButton insertTableBtn = new JButton("Insert Table");
	
	public DocumentGUI(Document docParam) {
		thisDoc = docParam;
		menuPanel.setLayout(new GridLayout(2, 5));
		menuPanel.add(saveBtn);
		menuPanel.add(saveAsBtn);
		menuPanel.add(copyBtn);
		menuPanel.add(cutBtn);
		menuPanel.add(pasteBtn);
		menuPanel.add(insertBoldBtn);
		menuPanel.add(insertItalicsBtn);
		menuPanel.add(insertHeaderBtn);
		menuPanel.add(insertListBtn);
		menuPanel.add(insertTableBtn);
		add(menuPanel);
		setVisible(true);
	}
	
	
}
