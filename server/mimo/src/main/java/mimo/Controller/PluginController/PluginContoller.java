package mimo.Controller.PluginController;

import plugins.Discord.Discord;
import plugins.GenshinImpact.GenshinImpact;
import plugins.NexusChronicals.NexusChronicals;
import plugins.Satisfactory.Satisfactory;
import plugins.Spotify.Spotify;

public class PluginContoller {
    private PluginMap mPluginMap;

    public PluginContoller() {
        initPluginManager();
        registerPlugins();
    }

    private void initPluginManager() {
        mPluginMap = new PluginMap();
    }

    private void registerPlugins() {
        mPluginMap.put("Spotify", new Spotify());
        mPluginMap.put("Satisfactory", new Satisfactory());
        mPluginMap.put("GenshinImpact", new GenshinImpact());
        mPluginMap.put("NexusChronicals", new NexusChronicals());
        mPluginMap.put("Discord", new Discord());
    }

    public void startPlugins() {
        mPluginMap.startPlugins();
    }

    public void runPlugins() {
        mPluginMap.runPlugins();
    }
}
