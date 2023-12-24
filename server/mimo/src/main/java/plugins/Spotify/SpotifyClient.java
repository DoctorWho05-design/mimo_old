package plugins.Spotify;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URI;
import java.util.Properties;
import mimo.Mimo;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.SpotifyHttpManager;

class SpotifyClient {
    private SpotifyApi mSpotifyApi;
    
    private Spotify mSpotify;
    private URI mRedirectedURI;
    private Properties mProperties;
    private InputStream mInput; 
    private SpotifyCallToken mCallToken;
    
    public SpotifyClient(Spotify mSpotify) {
        initSpotifyClient(mSpotify);
    }

    private void initSpotifyClient(Spotify mSpotify) {
        this.mSpotify = mSpotify;
        mRedirectedURI = SpotifyHttpManager.makeUri("http://localhost:4202");
        mProperties = new Properties();

        try {
            mInput = new FileInputStream("props.properties");
            mProperties.load(mInput);
        } catch (Exception e) {
            e.printStackTrace();
        }

        mSpotifyApi = new SpotifyApi
                .Builder()
                .setClientId(mProperties.getProperty("clientID"))
                .setClientSecret(mProperties.getProperty("clientSecret"))
                .setRedirectUri(mRedirectedURI)
                .build();
        
        mCallToken = new SpotifyCallToken(mSpotifyApi);
        
        mCallToken.callRefreshToken();

        mSpotifyApi.setRefreshToken(mCallToken.getRefreshToken());
        mSpotifyApi.setAccessToken(mCallToken.getAccessToken());
        Mimo.DEBUGER.startMethod("initSpotifyClient()");
        Mimo.DEBUGER.printToken(mSpotify.getPluginName() ,"Access", mSpotifyApi.getAccessToken());
        Mimo.DEBUGER.printToken(mSpotify.getPluginName(),"Refresh", mSpotifyApi.getRefreshToken());
    }
   
}