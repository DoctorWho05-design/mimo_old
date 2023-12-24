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
    

    public SpotifyClient() {
        initSpotifyClient();
    }

    private void initSpotifyClient() {

        try {
            Properties mProperties = new Properties();
            InputStream mInput = new FileInputStream("props.properties");
            mProperties.load(mInput);
            URI mRedirectedURI = SpotifyHttpManager.makeUri("http://localhost:3001");
            
            mSpotifyApi = new SpotifyApi
                .Builder()
                .setClientId(mProperties.getProperty("clientID"))
                .setClientSecret(mProperties.getProperty("clientSecret"))
                .setRedirectUri(mRedirectedURI)
                .build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        Mimo.DEBUGER.startMethod("initSpotifyClient()");
        
        System.out.println("Access Token: " + mSpotifyApi.getAccessToken());
    }

    public void printAccsesToken() {
        System.out.println("Access Token: " + mSpotifyApi.getAccessToken());
    }
        
}