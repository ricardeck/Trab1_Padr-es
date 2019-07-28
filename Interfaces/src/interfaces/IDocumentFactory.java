package interfaces;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;

/**
 *
 * @author ricardeck
 */
public interface IDocumentFactory {

	public IDocumentSerializer createSerializer();

	public IDocumentEditor createEditor();

	public IDocumentValidator createValidator();
}