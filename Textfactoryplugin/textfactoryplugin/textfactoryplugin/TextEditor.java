package textfactoryplugin;

import interfaces.IDocumentEditor;

public class TextEditor implements IDocumentEditor {

	@Override
	public boolean open() {
		System.out.println("documento aberto");
		return true;
	}

	@Override
	public String namePlugin() {
		return "Editor de Texto";
	}

}
