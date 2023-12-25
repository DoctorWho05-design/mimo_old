package mimo.Controller.PluginManager;

public abstract class Plugin {
    private String mPluginName;
    protected PluginSet mPluginSet;

    public Plugin(String mPluginName) {
        initPlugin(mPluginName);
    }

    private void initPlugin(String mPluginName) {
        this.mPluginName = mPluginName;
    }
    
    public abstract void start();
    
    public abstract void run();

    public String getPluginName() {return mPluginName;}

    public void setPluginSet(PluginSet mPluginSet) {this.mPluginSet = mPluginSet;}
}
