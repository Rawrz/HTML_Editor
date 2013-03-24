package Commands;

import Entities.Document;
import Entities.Menu_Option;

public class CutCommand implements Menu_Option{
	
	private Document doc;
	
	public CutCommand(Document document){
		doc = document;
	}
	@Override
	public void execute() {
		doc.cut();
	}

}
