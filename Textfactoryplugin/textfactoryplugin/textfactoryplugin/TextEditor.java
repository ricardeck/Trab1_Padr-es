package textfactoryplugin;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import interfaces.IDocumentEditor;

public class TextEditor implements IDocumentEditor {

	@Override
	public boolean open(String fileName) throws IOException {
//		System.out.println("documento aberto");
		Desktop desktop = null;
		if (Desktop.isDesktopSupported()) {
			desktop = Desktop.getDesktop();
			File file = new File(fileName);
			desktop.open(file);
		}
		return true;
	}

	@Override
	public String namePlugin() {
		return "Editor de Texto";
	}

}
