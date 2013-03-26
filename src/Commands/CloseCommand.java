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
	public void execute() {}
	
    @Override
    public void execute(Object obj) {
        htmlEditor.closeDocument((Integer)obj);
    }

}
