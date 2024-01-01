package mimo.Controller;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import frontend.MimoFrame;
import mimo.Mimo;
import mimo.Controller.Plugin.PluginContoller;
import mimo.Controller.Ruotine.RuotineControllor;
import mimo.Controller.Workspace.WorkspaceController;

public class Controller {
    
    private PluginContoller mPluginController;
    private WorkspaceController mWorkspaceController;
    private RuotineControllor mRuotineControllor;
    
    private MimoFrame mMimoFrame;

    public static final int PORT = 3000;

    public Controller() {
        initController();
    }

    private void initController() {
        mMimoFrame = new MimoFrame();
        mPluginController = new PluginContoller();
        mWorkspaceController = new WorkspaceController();
        mRuotineControllor = new RuotineControllor();
        
        mMimoFrame.setStartScreen();
        mPluginController.startPlugins();
    }
}
