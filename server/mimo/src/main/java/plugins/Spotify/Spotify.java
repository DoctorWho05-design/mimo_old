package plugins.Spotify;

import mimo.Mimo;
import mimo.Controller.PluginManager.Plugin;

public class Spotify extends Plugin{
    private SpotifyGenerateAccessCode mSpotifyGenerateAccessCode;
    
    public Spotify() {
        super("Spotify");
    }

    @Override
    public void start() {
        Mimo.DEBUGER.startMethod(getPluginName() + " start()");
        mSpotifyGenerateAccessCode = new SpotifyGenerateAccessCode(this);
    }

    @Override
    public void run() {
        debbug();
    }


    private void debbug() {
        Mimo.DEBUGER.startMethod(getPluginName() + " run()");
        Mimo.DEBUGER.printToken(getPluginName() ,"Access", mSpotifyGenerateAccessCode.getAccessToken());
        Mimo.DEBUGER.printToken(getPluginName(),"Refresh", mSpotifyGenerateAccessCode.getRefreshToken());
    }
}
