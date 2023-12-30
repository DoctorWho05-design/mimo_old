package mimo.Controller;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import frontend.MimoFrame;
import mimo.Mimo;
import mimo.Controller.PluginController.PluginContoller;

public class Controller {
    
    private PluginContoller mPluginController;
    private ScheduledExecutorService mScheduler;
    private MimoFrame mMimoFrame;

    public static final int PORT = 3000;

    public Controller() {
        initController();
        initPlugins();
        runMimo();
    }

    private void initController() {
        mMimoFrame = new MimoFrame();
    }
    private void initPlugins() {
        mPluginController = new PluginContoller();
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
