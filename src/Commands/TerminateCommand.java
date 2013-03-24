package Commands;

import Entities.HTML_Editor;
import Entities.Menu_Option;

public class TerminateCommand implements Menu_Option{
	
	private HTML_Editor htmlEditor;
	
	public TerminateCommand(HTML_Editor editor){
		htmlEditor = editor;
	}
	@Override
	public void execute(){
		htmlEditor.terminate();
	}
}
