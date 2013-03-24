package Commands;

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
		htmlEditor.openDocument();
	}

    @Override
    public void execute(Tag tag) {
        // TODO Auto-generated method stub
        
    }

}
