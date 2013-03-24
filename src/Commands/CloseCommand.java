package Commands;

import javax.swing.text.html.HTML.Tag;

import Entities.HTML_Editor;
import Entities.Menu_Option;

public class CloseCommand implements Menu_Option{
	private HTML_Editor htmlEditor;
	
	public CloseCommand(HTML_Editor editor){
		htmlEditor = editor;
	}
	@Override
	public void execute() {
		//TODO: Put real document int in here
		int i = 0;
		htmlEditor.closeDocument(i);
	}
    @Override
    public void execute(Tag tag) {
        // TODO Auto-generated method stub
        
    }

}
