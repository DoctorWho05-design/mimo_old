package plugins.Spotify;

import java.net.URI;
import java.net.URISyntaxException;

import se.michaelthelin.spotify.SpotifyApi;

public class SpotifyClient {
    private SpotifyApi mSpotifyApi;
    

    public SpotifyClient() {
        initSpotifyClient();
    }

    private void initSpotifyClient() {
        try {
            mSpotifyApi = new SpotifyApi.Builder()
                .setClientId("<your_client_id>")
                .setClientSecret("<your_client_secret>")
                .setRedirectUri(new URI("http://localhost:3001"))
                .build();
        } catch (URISyntaxException e) {
            //System.out.println("Error in Spotify Plugin: " + e);
        }
    }
}