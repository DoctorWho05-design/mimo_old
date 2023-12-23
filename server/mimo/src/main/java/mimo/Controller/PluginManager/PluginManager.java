package mimo.Controller.PluginManager;

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
    }

    public PluginSet getPluginSet() {return mPluginsSet;}
}
