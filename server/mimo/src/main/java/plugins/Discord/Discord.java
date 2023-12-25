package plugins.Discord;

import mimo.Mimo;
import mimo.Controller.PluginManager.Plugin;

public class Discord extends Plugin{

    public Discord() {
        super("Discord");
    }

    @Override
    public void start() {
        Mimo.DEBUGER.startMethod(getPluginName() + " start()");
    }

    @Override
    public void run() {
        Mimo.DEBUGER.startMethod(getPluginName() + " run()");
    }

    
}