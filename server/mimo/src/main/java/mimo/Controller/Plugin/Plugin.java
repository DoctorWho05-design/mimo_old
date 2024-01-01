package mimo.Controller.Plugin;

import mimo.Controller.Data;

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

    public abstract void run(Data mData);

    public void setPluginSet(PluginMap mPluginMap) {this.mPluginMap = mPluginMap;}

    public String getPluginName() {return mPluginName;}
}
