package mimo.Controller.WorkspaceController;

import mimo.Controller.PluginController.PluginSet;

public abstract class Workspace {
    private String mWorkspaceName;
    protected PluginSet mPluginSet;

    public Workspace(String mWorkspaceName) {
        initWorksapce(mWorkspaceName);
    }

    private void initWorksapce(String mWorkspaceName) {
        this.mWorkspaceName = mWorkspaceName;
    }

    public String getName() {return mWorkspaceName;}
    
}
