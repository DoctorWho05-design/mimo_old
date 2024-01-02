package mimo.Controller.Plugin;

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
        mPluginMap = new PluginMapFactory()
            .addSpotify()
            .addSatisfactory()
            .addNexusChronicals()
            .addGenshinImpact()
            .addDiscord()
            .build();
    }

    public void startPlugins() {
        mPluginMap.startPlugins();
    }

    public void runPlugins() {
        mPluginMap.runPlugins();
    }
}
