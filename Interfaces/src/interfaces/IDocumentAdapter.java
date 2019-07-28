package interfaces;

import java.io.IOException;

public interface IDocumentAdapter {
	public void setAdaptee(String fileExtension);
	public void openDocument(String fileName) throws IOException;
}
