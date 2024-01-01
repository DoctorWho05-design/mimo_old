package mimo.Controller.Workspace;

import mimo.Controller.Plugin.PluginMap;
import mimo.Controller.Plugin.PluginMapFactory;

public class Workspace {
    private String mWorkspaceName;
    protected PluginMap mPluginMap;

    public Workspace(String mWorkspaceName) {
        initWorksapce(mWorkspaceName);
    }

    private void initWorksapce(String mWorkspaceName) {
        this.mWorkspaceName = mWorkspaceName;
        mPluginMap = new PluginMap();
    }

    public String getName() {return mWorkspaceName;}

    public void addPlugin(String mKey) {
        PluginMapFactory mFactory = new PluginMapFactory();
        mPluginMap = mFactory.editPluginMap(mPluginMap).addPlugin(mKey).build();
    }
    
}
