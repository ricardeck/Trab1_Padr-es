package textfactoryplugin;

import application.PluginController;
import interfaces.IDocumentEditor;

public class TextEditor implements IDocumentEditor {

	private static TextEditor instance = null;
	
	public TextEditor getInstance() {
		if (instance ==  null)
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
