package interfaces;

import java.util.List;

/**
 *
 * @author aluno
 */
public interface IPluginController {
	public boolean initialize(ICore core);

	public List<IPlugin> getLoadedPlugins();

	public <T> List<T> getPluginsByType(T t, ICore core);
}