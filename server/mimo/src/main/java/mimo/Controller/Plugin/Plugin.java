package mimo.Controller.Plugin;

import mimo.Controller.Data;

public abstract class Plugin {
    private String mPluginName;
    protected boolean mRunEachIteration;
    protected PluginMap mPluginMap;

    public Plugin(String mPluginName, boolean mRunEachIteration) {
        initPlugin(mPluginName, mRunEachIteration);
    }

    private void initPlugin(String mPluginName, boolean mRunEachIteration) {
        this.mPluginName = mPluginName;
        this.mRunEachIteration = mRunEachIteration;
    }
    
    public abstract void start();
    
    public abstract void run();

    public abstract void run(Data mData);

    public void setPluginSet(PluginMap mPluginMap) {this.mPluginMap = mPluginMap;}

    public String getPluginName() {return mPluginName;}
}
