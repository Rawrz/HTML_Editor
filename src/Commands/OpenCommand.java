package Commands;

import java.io.File;

import javax.swing.text.html.HTML.Tag;

import Entities.HTML_Editor;
import Entities.Menu_Option;

public class OpenCommand implements Menu_Option{
	
	private HTML_Editor htmlEditor;
	public OpenCommand(HTML_Editor editor){
		htmlEditor = editor;
	}
	
	@Override
	public void execute() {
		File placeholder = new File("Placeholder");
		htmlEditor.openDocument(placeholder);
	}

    @Override
    public void execute(Tag tag) {
        // TODO Auto-generated method stub
        
    }

}
