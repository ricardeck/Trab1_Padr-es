package textfactoryplugin;

import interfaces.IDocumentValidator;

public class TextValidator implements IDocumentValidator {

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
		return "txt|doc|odt";
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
