package mimo.Controller.WorkspaceManager;

import mimo.Controller.PluginManager.PluginSet;

public abstract class Workspace {
    private String mWorkspaceName;
    protected PluginSet mPluginSet;

    public Workspace(String mWorkspaceName) {
        initWorksapce(mWorkspaceName);
    }

    private void initWorksapce(String mWorkspaceName) {
        this.mWorkspaceName = mWorkspaceName;
    }

    
}
