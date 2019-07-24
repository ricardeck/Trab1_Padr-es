package biometryfactoryplugin;

import interfaces.IAutenticationBackEnd;
import interfaces.ICore;
import interfaces.IPlugin;

public class BiometryFactoryPlugin implements IPlugin, IAutenticationBackEnd {

	private static BiometryFactoryPlugin instance = null;
	
	private BiometryFactoryPlugin() {
	}
	
	public static BiometryFactoryPlugin getInstance() {
		if (instance == null)
			instance = new BiometryFactoryPlugin();
		return instance;
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
		return "Usando autenticação via biometria";
	}

}
