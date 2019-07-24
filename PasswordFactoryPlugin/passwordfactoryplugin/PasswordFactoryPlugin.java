package passwordfactoryplugin;

import interfaces.IAutenticationBackEnd;
import interfaces.ICore;
import interfaces.IPlugin;

public class PasswordFactoryPlugin implements IPlugin, IAutenticationBackEnd{

	private static PasswordFactoryPlugin instance = null;
	
	public static PasswordFactoryPlugin getInstance() {
		if (instance == null)
			instance = new PasswordFactoryPlugin();
		return instance;
	}
	
	private PasswordFactoryPlugin() {
	}
	
	@Override
	public boolean initialize(ICore core) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAutentication() {
		return "Usando autenticação via password";
	}

}
