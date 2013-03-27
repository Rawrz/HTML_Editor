package Commands;

import Entities.Menu_Option;
import Entities.TheDocument;

public class ToggleWrapCommand implements Menu_Option {
	
	private TheDocument doc;
	
	public ToggleWrapCommand(TheDocument theDocument){
		doc = theDocument;
	}
	
	@Override
	public void execute() {
	}

	@Override
	public void execute(Object obj) {
	}

}
