package interfaces;

/**
 *
 * @author ricardeck
 */
public interface IPlugin {
	
	public boolean initialize(ICore core);

	public String getType();
}
