package mimo.Controller.PluginManager;

import plugins.Discord.Discord;
import plugins.GenshinImpact.GenshinImpact;
import plugins.NexusChronicals.NexusChronicals;
import plugins.Satisfactory.Satisfactory;
import plugins.Spotify.Spotify;

public class PluginManager {
    private PluginMap mPluginsSet;

    public PluginManager() {
        initPluginManager();
        registerPlugins();
    }

    private void initPluginManager() {
        mPluginsSet = new PluginMap();
    }

    private void registerPlugins() {
        mPluginsSet.add(new Spotify());
        mPluginsSet.add(new Satisfactory());
        mPluginsSet.add(new GenshinImpact());
        mPluginsSet.add(new NexusChronicals());
        mPluginsSet.add(new Discord());
    }

    public void startPlugins() {
        mPluginsSet.startPlugins();
    }

    public void runPlugins() {
        mPluginsSet.runPlugins();
    }
}
