/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
