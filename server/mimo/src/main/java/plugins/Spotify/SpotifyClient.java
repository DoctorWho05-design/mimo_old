package plugins.Spotify;

import java.net.URI;

import mimo.Mimo;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.SpotifyHttpManager;

public class SpotifyClient {
    private SpotifyApi mSpotifyApi;
    

    public SpotifyClient() {
        initSpotifyClient();
    }

    private void initSpotifyClient() {
        try {
            URI mRedirectedURI = SpotifyHttpManager.makeUri("http://localhost:3001");
            
            mSpotifyApi = new SpotifyApi
                .Builder()
                .setClientId("aecf8f8115d74d95bb05b8e89294efa4")
                .setClientSecret("bad8070a9f42475c82c342bf7c2259cd")
                .setRedirectUri(mRedirectedURI)
                .build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Mimo.DEBUGER.startMethod("initSpotifyClient()");
        
        System.out.println("Access Token: " + mSpotifyApi.getAccessToken());
    }
        
}