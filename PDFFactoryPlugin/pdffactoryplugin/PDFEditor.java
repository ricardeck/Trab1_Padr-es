package pdffactoryplugin;

import interfaces.IDocumentEditor;

public class PDFEditor implements IDocumentEditor{

	@Override
	public boolean open() {
		System.out.println("documento PDF aberto");
		return true;
	}

	@Override
	public String namePlugin() {
		return "Editor de PDF";
	}

}
