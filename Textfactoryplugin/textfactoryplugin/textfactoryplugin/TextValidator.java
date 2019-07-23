package textfactoryplugin;

import interfaces.IDocumentValidator;

public class TextValidator implements IDocumentValidator {

	private static TextValidator instance = null;
	
	public TextValidator getInstance() {
		if (instance ==  null)
			instance = new TextValidator();
		return instance;
	}
	
	
	@Override
	public boolean validate() {
		System.out.println("documento validado");
		return false;
	}

}
