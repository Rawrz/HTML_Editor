package Commands;

import Entities.Document;
import Entities.Menu_Option;

public class PasteCommand implements Menu_Option{
	
	private Document doc;
	
	public PasteCommand(Document document){
		doc = document;
	}
	@Override
	public void execute() {
		doc.paste();		
	}

}
