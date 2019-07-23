package interfaces;

/**
 *
 * @author aluno
 */
public interface IDocumentFactory {

	public IDocumentSerializer createSerializer();

	public IDocumentEditor createEditor();

	public IDocumentValidator createValidator();

	public String getSupportedExtensions();

	public boolean isExtensionSupported(String fileExtension);
}