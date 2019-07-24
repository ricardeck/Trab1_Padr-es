package interfaces;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 *
 * @author aluno
 */
public interface IPluginController {
	public boolean initialize(ICore core) throws NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, InstantiationException, IllegalAccessException;

	public List<IPlugin> getLoadedPlugins();

	public <T> List<T> getPluginsByType(T t, ICore core);
}