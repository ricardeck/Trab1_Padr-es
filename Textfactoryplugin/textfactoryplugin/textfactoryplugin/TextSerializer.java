package textfactoryplugin;

import interfaces.IDocumentSerializer;

public class TextSerializer implements IDocumentSerializer {

	private static TextSerializer instance = null;
	
	public TextSerializer getInstance() {
		if (instance ==  null)
			instance = new TextSerializer();
		return instance;
	}
	
	@Override
	public boolean load() {
		System.out.println("documento resgatado");
		return false;
	}

	@Override
	public boolean save() {
		System.out.println("documento salvo");
		return false;
	}

}
