package textfactoryplugin;

import interfaces.IDocumentEditor;

public class TextEditor implements IDocumentEditor {

	private TextEditor() {
	}

	private static TextEditor instance = null;

	public static TextEditor getInstance() {
		if (instance == null)
			instance = new TextEditor();
		return instance;
	}

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
