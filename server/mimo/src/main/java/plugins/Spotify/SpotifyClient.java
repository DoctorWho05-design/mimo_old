package plugins.Spotify;

import java.net.URI;
import java.net.URISyntaxException;

import mimo.Mimo;
import se.michaelthelin.spotify.SpotifyApi;

public class SpotifyClient {
    private SpotifyApi mSpotifyApi;
    

    public SpotifyClient() {
        initSpotifyClient();
    }

    private void initSpotifyClient() {
        try {
            mSpotifyApi = new SpotifyApi.Builder()
                .setClientId("aecf8f8115d74d95bb05b8e89294efa4")
                .setClientSecret("bad8070a9f42475c82c342bf7c2259cd")
                .setRedirectUri(new URI("http://localhost:3001"))
                .build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        Mimo.DEBUGER.startMethod("initSpotifyClient()");
        //System.out.println(mSpotifyApi.getAccessToken());
    }
}