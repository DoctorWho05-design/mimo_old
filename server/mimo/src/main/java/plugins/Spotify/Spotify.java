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
        Mimo.DEBUGER.startMethod(getPluginName() + " start()");
        mSpotifyClient = new SpotifyClient(this);
    }

    @Override
    public void run() {
        Mimo.DEBUGER.startMethod(getPluginName() + " run()");
        Mimo.DEBUGER.printToken(getPluginName() ,"Access", mSpotifyClient.getAccessToken());
        Mimo.DEBUGER.printToken(getPluginName(),"Refresh", mSpotifyClient.getRefreshToken());
        mSpotifyClient.printAuthorizationCodeExpiresIn();
    }
}
