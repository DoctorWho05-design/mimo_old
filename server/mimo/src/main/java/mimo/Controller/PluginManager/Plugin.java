package mimo.Controller.PluginManager;

public abstract class Plugin {
    private String mPluginName;

    public Plugin(String mPluginName) {
        initPlugin(mPluginName);
    }

    private void initPlugin(String mPluginName) {
        this.mPluginName = mPluginName;
    }
    
    public abstract void start();
    
    public abstract void run();
}
