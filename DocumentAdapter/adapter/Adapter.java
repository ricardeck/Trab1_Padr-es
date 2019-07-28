package adapter;

import java.io.IOException;

import adaptee.Adaptee;
import interfaces.IDocumentAdaptee;
import interfaces.IDocumentAdapter;

public class Adapter implements IDocumentAdapter{

	private IDocumentAdaptee documentAdaptee;
	
	@Override
	public void setAdaptee(String fileExtension) {
		if(fileExtension.equalsIgnoreCase("Pdf"))
			documentAdaptee = new Adaptee();
	}

	@Override
	public void openDocument(String fileName) throws IOException {
		if(documentAdaptee != null)
			documentAdaptee.open(fileName);
	}

}
