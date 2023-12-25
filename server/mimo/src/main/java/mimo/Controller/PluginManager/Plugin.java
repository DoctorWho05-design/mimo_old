package mimo.Controller.PluginManager;

public abstract class Plugin {
    private String mPluginName;
    protected PluginMap mPluginMap;

    public Plugin(String mPluginName) {
        initPlugin(mPluginName);
    }

    private void initPlugin(String mPluginName) {
        this.mPluginName = mPluginName;
    }
    
    public abstract void start();
    
    public abstract void run();

    public String getPluginName() {return mPluginName;}

    public void setPluginMap(PluginMap mPluginMap) {this.mPluginMap = mPluginMap;}
}
