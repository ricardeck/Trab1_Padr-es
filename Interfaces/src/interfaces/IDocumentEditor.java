package interfaces;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;

public interface IDocumentEditor {

	public boolean open(String fileName) throws InvalidPasswordException, IOException;

	public String namePlugin();
}
