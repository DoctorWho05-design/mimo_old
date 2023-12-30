package mimo.Controller.WorkspaceController;

public class WorkspaceController {

    private WorkspaceMap mWorkspaceMap;

    public WorkspaceController() {
        initWorkspaceController();
    }

    private void initWorkspaceController() {
        mWorkspaceMap = new WorkspaceMap();
    }

    public void createNewWorkspace(String mKey) {
        mWorkspaceMap.put(mKey, new Workspace(mKey));
    }

    public void deletWorkspace(String mKey) {
        mWorkspaceMap.remove(mKey);
    }

    public Workspace getWorkspace(String mKey) {
        return mWorkspaceMap.get(mKey);
    }
}