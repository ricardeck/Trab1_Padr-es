package pdffactoryplugin;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import adapter.Adapter;
import interfaces.IDocumentAdapter;
import interfaces.IDocumentEditor;

public class PDFEditor implements IDocumentEditor {

	private IDocumentAdapter documentAdapter;

	public PDFEditor() {
		this.documentAdapter = new Adapter();
	}

	@Override
	public boolean open(String fileName) throws InvalidPasswordException, IOException {
		String fileExtension = fileName.split("\\.")[1];
		documentAdapter.setAdaptee(fileExtension);
		documentAdapter.openDocument(fileName);
		return true;
	}

	@Override
	public String namePlugin() {
		return "Editor de PDF";
	}

}
