package mimo.Controller.WorkspaceController;

import mimo.Controller.PluginController.PluginMap;

public abstract class Workspace {
    private String mWorkspaceName;
    protected PluginMap mPluginMap;

    public Workspace(String mWorkspaceName) {
        initWorksapce(mWorkspaceName);
    }

    private void initWorksapce(String mWorkspaceName) {
        this.mWorkspaceName = mWorkspaceName;
    }

    public String getName() {return mWorkspaceName;}
    
}
