package Commands;

import Entities.Document;
import Entities.Menu_Option;

public class SaveAsCommand implements Menu_Option{
	private Document doc;
	public SaveAsCommand(Document document){
		doc = document;
	}

	@Override
	public void execute() {
		doc.saveAs();
	}

}
