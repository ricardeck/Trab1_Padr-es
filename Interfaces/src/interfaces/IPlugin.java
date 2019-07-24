package interfaces;

/**
 *
 * @author aluno
 */
public interface IPlugin {
	
	public boolean initialize(ICore core);

	public String getType();
}
