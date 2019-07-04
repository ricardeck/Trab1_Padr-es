/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import interfaces.ICore;
import interfaces.IPluginController;
import interfaces.IUIController;

/**
 *
 * @author aluno
 */
public class Core implements ICore {

	public Core() {
		uiController = new UIController();
		pluginController = new PluginController();
		uiController.initialize();
		pluginController.initialize(this);

	}

	@Override
	public IUIController getUIController() {
		return uiController;
	}

	@Override
	public IPluginController getPluginController() {
		return pluginController;
	}

	private IUIController uiController;
	private IPluginController pluginController;
}
