package mimo.Controller.PluginManager;

import plugins.GenshinImpact.GenshinImpact;
import plugins.Satisfactory.Satisfactory;
import plugins.Spotify.Spotify;

public class PluginManager {
    private PluginSet mPluginsSet;

    public PluginManager() {
        initPluginManager();
        registerPlugins();
    }

    private void initPluginManager() {
        mPluginsSet = new PluginSet();
    }

    private void registerPlugins() {
        mPluginsSet.add(new Spotify());
        mPluginsSet.add(new Satisfactory());
        mPluginsSet.add(new GenshinImpact());
    }

    public void startPlugins() {
        mPluginsSet.startPlugins();
    }

    public void runPlugins() {
        mPluginsSet.runPlugins();
    }
}
