package plugins.Spotify;

import mimo.Mimo;
import mimo.Controller.PluginManager.Plugin;

public class Spotify extends Plugin{
    
    public Spotify() {
        super("Spotify");
    }

    @Override
    public void start() {
        Mimo.DEBUGER.startMethod("Spotify start()");
    }

    @Override
    public void run() {
        Mimo.DEBUGER.startMethod("Spotify run()");
    }

    
}
