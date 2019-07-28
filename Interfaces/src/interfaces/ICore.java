package interfaces;

import application.AutenticationController;

/**
 *
 * @author ricardeck
 */
public interface ICore {
	public IUIController getUIController();

	public IPluginController getPluginController();
	
	public IAutenticationController getAutenticationController();
}
