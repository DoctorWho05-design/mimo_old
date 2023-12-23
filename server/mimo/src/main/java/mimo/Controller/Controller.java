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
        runTask();
    }

    private void initPlugins() {
        mPluginManager = new PluginManager();
        mPluginSet = mPluginManager.getPluginSet();
    }

    private void runMimo() {
        Thread serverThread = new Thread(() -> {
            try (ServerSocket mServerSocket = new ServerSocket(PORT)) {
                System.out.println("Server listen to: " + PORT);
                

                while (true) {
                    Socket clientSocket = mServerSocket.accept();
                    handleMimo(clientSocket);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        serverThread.start();
        Mimo.DEBUGER.startMethod("serverThread.start()");
    }

    private void handleMimo(Socket clientSocket) {
        Mimo.DEBUGER.startMethod("handleMimo()");
    }

    private void runTask() {
        Thread schedulerThread = new Thread(() -> {
            mPluginSet.startPlugins();
            mScheduler = Executors.newScheduledThreadPool(1);
            mScheduler.scheduleAtFixedRate(() -> {
                handleRunTask();
            }, 0, 5, TimeUnit.SECONDS);
        });
        schedulerThread.start();
        Mimo.DEBUGER.startMethod("scheduelerThread.start()");
    }

    private void handleRunTask() {
        mPluginSet.runPlugins();
    }
}
