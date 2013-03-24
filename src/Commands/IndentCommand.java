package Commands;

import Entities.Document;
import Entities.Menu_Option;

public class IndentCommand implements Menu_Option{
	private Document doc;
	
	public IndentCommand(Document document){
		doc = document;
	}

	@Override
	public void execute() {
		doc.indent();		
	}

}
