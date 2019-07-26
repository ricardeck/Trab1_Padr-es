package pdffactoryplugin;

import interfaces.IDocumentValidator;

public class PDFValidator implements IDocumentValidator {

	@Override
	public boolean validate(String fileExtension) {
		fileExtension = fileExtension.split("\\.")[1];
		for (String str : this.getSupportedExtensions().split("\\|")) {
			if (str.equals(fileExtension))
				return true;
		}
		return false;
	}
	
	public String getSupportedExtensions() {
		return "pdf";
	}

	public boolean isExtensionSupported(String fileExtension) {
		fileExtension = fileExtension.split("\\.")[1];
		for (String str : this.getSupportedExtensions().split("\\|")) {
			if (str.equals(fileExtension)) {
//				createEditor().open();
//				createSerializer().load();
//				createSerializer().save();
//				createValidator().validate();
				return true;
			}
		}

		return false;
	}

}
