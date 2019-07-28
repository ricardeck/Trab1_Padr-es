package pdffactoryplugin;

import interfaces.ICore;
import interfaces.IDocumentEditor;
import interfaces.IDocumentFactory;
import interfaces.IDocumentSerializer;
import interfaces.IDocumentValidator;
import interfaces.IPlugin;

public class PDFFactoryPlugin implements IPlugin, IDocumentFactory {
	private static PDFFactoryPlugin instance = null;

	private PDFFactoryPlugin() {
	}

	public static PDFFactoryPlugin getInstance() {
		if (instance == null)
			instance = new PDFFactoryPlugin();
		return instance;
	}

	@Override
	public boolean initialize(ICore core) {
		return true;
	}

	@Override
	public IDocumentSerializer createSerializer() {
		return new PDFSerializer();
	}

	@Override
	public IDocumentEditor createEditor() {
		return new PDFEditor();
	}

	@Override
	public String getType() {
		return "DocumentFactory";
	}

	@Override
	public IDocumentValidator createValidator() {
		return new PDFValidator();
	}

}
