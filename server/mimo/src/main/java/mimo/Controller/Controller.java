package mimo.Controller;

import java.util.Set;

import mimo.Controller.PluginManager.Plugin;
import mimo.Controller.PluginManager.PluginManager;
import plugins.Spotify.Spotify;

public class Controller {
    
    private Set<Plugin> mPluginsSet;
    private PluginManager mPluginManager;

    public Controller() {
        initPlugins();
    }

    private void initPlugins() {
        mPluginManager = new PluginManager();
        mPluginsSet = mPluginManager.getPluginSet();
    }

    private void registerPlugins() {
        mPluginsSet.add(new Spotify());
    }
}
