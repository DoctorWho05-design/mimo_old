package mimo.Controller;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import frontend.MimoFrame;
import mimo.Mimo;
import mimo.Controller.Plugin.PluginContoller;
import mimo.Controller.Routine.RoutineControllor;
import mimo.Controller.Workspace.WorkspaceController;

public class Controller {
    
    private PluginContoller mPluginController;
    private WorkspaceController mWorkspaceController;
    private RoutineControllor mRoutineControllor;
    
    private MimoFrame mMimoFrame;

    public static final int PORT = 3000;

    public Controller() {
        initController();
    }

    private void initController() {
        mMimoFrame = new MimoFrame();
        mPluginController = new PluginContoller();
        mWorkspaceController = new WorkspaceController();
        mRoutineControllor = new RoutineControllor();
        
        mMimoFrame.setStartScreen();
        mPluginController.startPlugins();
        Mimo.DEBUGER.startMethod("mPluginController.startPlugins()");
    }
}
