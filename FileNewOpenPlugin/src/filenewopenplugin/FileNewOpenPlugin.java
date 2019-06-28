/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filenewopenplugin;

import interfaces.ICore;
import interfaces.IPlugin;
import interfaces.IUIController;
import javax.swing.JMenuItem;

/**
 *
 * @author aluno
 */
public class FileNewOpenPlugin implements IPlugin {

    @Override
    public boolean initialize(ICore core) {
        IUIController uiController = core.getUIController();

        JMenuItem fileNewItem = uiController.addMenuItem("File", "New");
        fileNewItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.out.println("Voce clicou no File->New");
            }
        });        
        
        JMenuItem fileOpenItem = uiController.addMenuItem("File", "Open");
        fileOpenItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.out.println("Voce clicou no File->Open");
            }
        });        

        return true;
    }
}
