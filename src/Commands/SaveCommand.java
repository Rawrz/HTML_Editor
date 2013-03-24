package Commands;

import Entities.Document;
import Entities.Menu_Option;

public class SaveCommand implements Menu_Option{
	private Document doc;
	public SaveCommand(Document document){
		doc = document;
	}
	@Override
	public void execute() {
		doc.save();
	}

}
