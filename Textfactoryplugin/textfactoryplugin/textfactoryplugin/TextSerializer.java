package textfactoryplugin;

import interfaces.IDocumentSerializer;

public class TextSerializer implements IDocumentSerializer {

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
