package mimo.Controller.PluginController;

import mimo.Controller.Data;

public abstract class Plugin {
    private String mPluginName;
    protected boolean mRunEachIteration;
    protected PluginSet mPluginSet;

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

    public String getPluginName() {return mPluginName;}

    public void setPluginSet(PluginSet mPluginSet) {this.mPluginSet = mPluginSet;}
}
