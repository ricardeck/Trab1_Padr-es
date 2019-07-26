package application;

import java.lang.reflect.InvocationTargetException;

import interfaces.ICore;
import interfaces.IPluginController;
import interfaces.IUIController;

/**
 *
 * @author aluno
 */
public class Core implements ICore {

	private static Core instance = null;
	private IUIController uiController;
	private IPluginController pluginController;
	private AutenticationController autenticationController;
	private DocumentController documentController;

	private Core() throws NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, InstantiationException, IllegalAccessException {
		uiController = new UIController();
		pluginController = new PluginController();
		autenticationController = new AutenticationController();
		documentController = new DocumentController();
		autenticationController.initialize();
		uiController.initialize();
		pluginController.initialize(this);
		documentController.initialize(this);
	}

	public static Core getInstance() throws NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, InstantiationException, IllegalAccessException {
		if (instance == null)
			instance = new Core();
		return instance;
	}

	@Override
	public IUIController getUIController() {
		return uiController;
	}

	@Override
	public IPluginController getPluginController() {
		return pluginController;
	}

	@Override
	public AutenticationController getAutenticationController() {
		return autenticationController;
	}
}
