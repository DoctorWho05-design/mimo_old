package mimo.Controller;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import mimo.Mimo;
import mimo.Controller.PluginController.PluginContoller;

public class Controller {
    
    private PluginContoller mPluginManager;
    private ScheduledExecutorService mScheduler;

    public static final int PORT = 3000;

    public Controller() {
        initPlugins();
        runMimo();
    }

    private void initPlugins() {
        mPluginManager = new PluginContoller();
    }

    private void runMimo() {
        Thread schedulerThread = new Thread(() -> {
            mPluginManager.startPlugins();
            mScheduler = Executors.newScheduledThreadPool(1);
            mScheduler.scheduleAtFixedRate(() -> {
                handlerunMimo();
            }, 0, 5, TimeUnit.SECONDS);
        });
        schedulerThread.start();
        Mimo.DEBUGER.startMethod("scheduelerThread.start()");
    }

    private void handlerunMimo() {
        mPluginManager.runPlugins();
    }
}
