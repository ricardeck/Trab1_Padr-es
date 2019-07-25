package adapter;

import interfaces.IDocumentEditor;
import interfaces.IDocumentFactory;
import interfaces.IDocumentSerializer;
import interfaces.IDocumentValidator;

public class AdapterPDF implements IDocumentFactory{

	@Override
	public IDocumentSerializer createSerializer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IDocumentEditor createEditor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IDocumentValidator createValidator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSupportedExtensions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isExtensionSupported(String fileExtension) {
		// TODO Auto-generated method stub
		return false;
	}

}
