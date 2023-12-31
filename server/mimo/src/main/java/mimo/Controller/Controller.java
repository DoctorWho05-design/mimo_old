package mimo.Controller;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import frontend.MimoFrame;
import mimo.Mimo;
import mimo.Controller.Plugin.PluginContoller;
import mimo.Controller.Workspace.WorkspaceController;

public class Controller {
    
    private PluginContoller mPluginController;
    private WorkspaceController mWorkspaceController;
    private ScheduledExecutorService mScheduler;
    private MimoFrame mMimoFrame;

    public static final int PORT = 3000;

    public Controller() {
        initController();
        runMimo();
    }

    private void initController() {
        mMimoFrame = new MimoFrame();
        mMimoFrame.setStartScreen();
        mPluginController = new PluginContoller();
        mWorkspaceController = new WorkspaceController();
    }

    private void runMimo() {
        Thread schedulerThread = new Thread(() -> {
            mPluginController.startPlugins();
            mScheduler = Executors.newScheduledThreadPool(1);
            mScheduler.scheduleAtFixedRate(() -> {
                handlerunMimo();
            }, 0, 5, TimeUnit.SECONDS);
        });
        schedulerThread.start();
        Mimo.DEBUGER.startMethod("scheduelerThread.start()");
    }

    private void handlerunMimo() {
        mPluginController.runPlugins();
    }
}
