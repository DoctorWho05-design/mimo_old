package plugins.Spotify;

import mimo.Mimo;
import mimo.Controller.PluginManager.Plugin;

public class Spotify extends Plugin{
    private SpotifyClient mSpotifyClient;
    
    public Spotify() {
        super("Spotify");
    }

    @Override
    public void start() {
        Mimo.DEBUGER.startMethod("Spotify start()");
        mSpotifyClient = new SpotifyClient();
    }

    @Override
    public void run() {
        Mimo.DEBUGER.startMethod("Spotify run()");
        mSpotifyClient.printAccsesToken();
    }

    
}
