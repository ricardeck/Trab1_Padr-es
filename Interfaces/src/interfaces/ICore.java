package interfaces;

import application.AutenticationController;

/**
 *
 * @author aluno
 */
public interface ICore {
	public IUIController getUIController();

	public IPluginController getPluginController();
	
	public AutenticationController getAutenticationController();
}
