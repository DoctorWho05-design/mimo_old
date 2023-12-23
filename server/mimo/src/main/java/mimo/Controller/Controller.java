package mimo.Controller;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Set;

import mimo.Controller.PluginManager.Plugin;
import mimo.Controller.PluginManager.PluginManager;
import plugins.Spotify.Spotify;

public class Controller {
    
    private Set<Plugin> mPluginsSet;
    private PluginManager mPluginManager;

    public static final int PORT = 3000;

    public Controller() {
        initPlugins();
        registerPlugins();

        runMimo();
    }

    private void initPlugins() {
        mPluginManager = new PluginManager();
        mPluginsSet = mPluginManager.getPluginSet();
    }

    private void registerPlugins() {
        mPluginsSet.add(new Spotify());
    }

    private void runMimo() {
        try (ServerSocket mServerSocket = new ServerSocket(PORT)) {
            System.out.println("Server listen to: " + PORT);

            while (true) {
                Socket clientSocket = mServerSocket.accept();
                handleMimo();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleMimo() {

    }
}
