package interfaces;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;

/**
 *
 * @author aluno
 */
public interface IDocumentFactory {

	public IDocumentSerializer createSerializer();

	public IDocumentEditor createEditor();

	public IDocumentValidator createValidator();

	public String getSupportedExtensions();

	public boolean isExtensionSupported(String fileExtension) throws InvalidPasswordException, IOException;
}