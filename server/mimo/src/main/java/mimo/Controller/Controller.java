package mimo.Controller;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import mimo.Mimo;
import mimo.Controller.PluginManager.PluginManager;
import mimo.Controller.PluginManager.PluginSet;

public class Controller {
    
    private PluginManager mPluginManager;
    private PluginSet mPluginSet;
    private ScheduledExecutorService mScheduler;

    public static final int PORT = 3000;

    public Controller() {
        initPlugins();
        runMimo();
    }

    private void initPlugins() {
        mPluginManager = new PluginManager();
        mPluginSet = mPluginManager.getPluginSet();
    }

    private void runMimo() {
        Thread schedulerThread = new Thread(() -> {
            mPluginSet.startPlugins();
            mScheduler = Executors.newScheduledThreadPool(1);
            mScheduler.scheduleAtFixedRate(() -> {
                handlerunMimo();
            }, 0, 5, TimeUnit.SECONDS);
        });
        schedulerThread.start();
        Mimo.DEBUGER.startMethod("scheduelerThread.start()");
    }

    private void handlerunMimo() {
        mPluginSet.runPlugins();
    }
}
