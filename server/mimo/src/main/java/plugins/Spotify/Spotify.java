package plugins.Spotify;

import mimo.Mimo;
import mimo.Controller.Data;
import mimo.Controller.Plugin.Plugin;

public class Spotify extends Plugin{
    private SpotifyGenerateAccessCode mSpotifyGenerateAccessCode;
    
    public Spotify() {
        super("Spotify", false);
    }

    @Override
    public void start() {
        Mimo.DEBUGER.startMethod(getPluginName() + " start()");
        mSpotifyGenerateAccessCode = new SpotifyGenerateAccessCode(this);
    }

    @Override
    public void run() {
        if (!mRunEachIteration) return;
        debbug();
    }


    private void debbug() {
        Mimo.DEBUGER.startMethod(getPluginName() + " run()");
        Mimo.DEBUGER.printToken(getPluginName() ,"Access", mSpotifyGenerateAccessCode.getAccessToken());
        Mimo.DEBUGER.printToken(getPluginName(),"Refresh", mSpotifyGenerateAccessCode.getRefreshToken());
    }

    @Override
    public void run(Data mData) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'run'");
    }
}
