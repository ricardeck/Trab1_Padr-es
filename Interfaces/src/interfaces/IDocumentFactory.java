/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author aluno
 */
public interface IDocumentFactory {
	// Metodos para criacao dos tres produtos

	public IDocumentSerializer createSerializer();

	public IDocumentEditor createEditor();

	public IDocumentValidator createValidator();

	public String getSupportedExtensions(); // return "gif|png|jpg";

	public boolean isExtensionSupported(String fileExtension);
}