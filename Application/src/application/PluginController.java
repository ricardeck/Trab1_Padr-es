package application;

import interfaces.ICore;
import interfaces.IPlugin;
import interfaces.IPluginController;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aluno
 */
public class PluginController implements IPluginController {

	private List<IPlugin> loadedPlugins = new ArrayList<IPlugin>();

	@SuppressWarnings("deprecation")
	@Override
	public boolean initialize(ICore core) throws NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, InstantiationException, IllegalAccessException {
		File currentDir = new File("./Application/plugins");
		String[] plugins = currentDir.list();
		int i;
		URL[] jars = new URL[plugins.length];
		System.out.println("Encontrei " + plugins.length + " plugins instalados!");
		for (i = 0; i < plugins.length; i++)
			try {
				jars[i] = (new File("./plugins/" + plugins[i])).toURL();
			} catch (MalformedURLException ex) {
				Logger.getLogger(PluginController.class.getName()).log(Level.SEVERE, null, ex);
			}
		URLClassLoader ulc = new URLClassLoader(jars);
		
		for (i = 0; i < plugins.length; i++) {
			String pluginName = plugins[i].split("\\.")[0];
			IPlugin plugin = null;
			Object o = null;
			try {
				Class c = Class.forName(pluginName.toLowerCase() + "." + pluginName, true, ulc);
				Constructor constructor = c.getDeclaredConstructor();
				if(Modifier.isPrivate(constructor.getModifiers())) {
					Method singleton = c.getDeclaredMethod("getInstance");
					o = singleton.invoke(null, null);
				}else
					o = (IPlugin) Class.forName(pluginName.toLowerCase() + "." + pluginName, true, ulc).newInstance();
			} catch (ClassNotFoundException ex) {
				Logger.getLogger(PluginController.class.getName()).log(Level.SEVERE, null, ex);
			}
			if (o != null)
				if (((IPlugin) o).initialize(core))
					loadedPlugins.add((IPlugin) o);
		}
		return true;
	}

	@Override
	public List<IPlugin> getLoadedPlugins() {
		return loadedPlugins;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> getPluginsByType(T t, ICore core) {
		List<T> loadedPluginsByType = new ArrayList<>();

		for (IPlugin plugin : core.getPluginController().getLoadedPlugins()) {

			if (t.toString().contains(plugin.getType())) {
				loadedPluginsByType.add((T) plugin);
			}
			System.out.println();
		}
		return loadedPluginsByType;
	}
}
