package Commands;

import java.io.File;

import javax.swing.text.html.HTML.Tag;

import Entities.HTML_Editor;
import Entities.Menu_Option;

public class NewCommand implements Menu_Option{	
	private HTML_Editor htmlEditor;
	
	public NewCommand (HTML_Editor editor){
		htmlEditor = editor;
	}
	@Override
	public void execute() {}
		
    @Override
    public void execute(Object obj) {
    	String filePath = (String)obj;
    	htmlEditor.newDocument(filePath);
    }

}
