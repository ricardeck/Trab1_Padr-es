package textfactoryplugin;

import interfaces.IDocumentValidator;

public class TextValidator implements IDocumentValidator {

	@Override
	public boolean validate() {
		System.out.println("documento validado");
		return false;
	}

}
