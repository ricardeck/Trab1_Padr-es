package textfactoryplugin;

import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;

import application.Core;
import interfaces.ICore;
import interfaces.IDocumentEditor;
import interfaces.IDocumentFactory;
import interfaces.IDocumentSerializer;
import interfaces.IDocumentValidator;
import interfaces.IPlugin;
import interfaces.IUIController;

public class TextFactoryPlugin implements IPlugin, IDocumentFactory {
	private String fileExtension;
	private static TextFactoryPlugin instance = null;
	
	private TextFactoryPlugin() {
	}
	
	public static TextFactoryPlugin getInstance() {
		if (instance == null)
			instance = new TextFactoryPlugin();
		return instance;
	}
	
	@Override
	public boolean initialize(ICore core) {
		return true;
	}
	
	@Override
	public IDocumentSerializer createSerializer() {
		return new TextSerializer();
	}

	@Override
	public IDocumentEditor createEditor() {
		return new TextEditor();
	}

	@Override
	public IDocumentValidator createValidator() {
		return new TextValidator();
	}

	@Override
	public String getType() {
		return "DocumentFactory";
	}

}
