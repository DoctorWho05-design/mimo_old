package plugins.Spotify;

import mimo.Mimo;
import mimo.Controller.PluginManager.Plugin;

public class Spotify extends Plugin{
    private SpotifyCallAccessCode mSpotifyCallAccessCode;
    
    public Spotify() {
        super("Spotify");
    }

    @Override
    public void start() {
        Mimo.DEBUGER.startMethod(getPluginName() + " start()");
        mSpotifyCallAccessCode = new SpotifyCallAccessCode(this);
    }

    @Override
    public void run() {
        Mimo.DEBUGER.startMethod(getPluginName() + " run()");
        Mimo.DEBUGER.printToken(getPluginName() ,"Access", mSpotifyCallAccessCode.getAccessToken());
        Mimo.DEBUGER.printToken(getPluginName(),"Refresh", mSpotifyCallAccessCode.getRefreshToken());
    }
}
