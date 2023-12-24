package plugins.Spotify;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URI;
import java.util.Properties;
import mimo.Mimo;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.SpotifyHttpManager;
import se.michaelthelin.spotify.model_objects.credentials.AuthorizationCodeCredentials;
import se.michaelthelin.spotify.requests.authorization.authorization_code.AuthorizationCodeRequest;
import se.michaelthelin.spotify.requests.authorization.authorization_code.AuthorizationCodeUriRequest;

class SpotifyClient {
    private SpotifyApi mSpotifyApi;
    private AuthorizationCodeUriRequest mAuthorizationCodeUriRequest;
    private Spotify mSpotify;
    

    public SpotifyClient(Spotify mSpotify) {
        this.mSpotify = mSpotify;
        initSpotifyClient();
    }

    private void initSpotifyClient() {

        try {
            Properties mProperties = new Properties();
            InputStream mInput = new FileInputStream("props.properties");
            mProperties.load(mInput);
            URI mRedirectedURI = SpotifyHttpManager.makeUri("http://localhost:4202");
            
            mSpotifyApi = new SpotifyApi
                .Builder()
                .setClientId(mProperties.getProperty("clientID"))
                .setClientSecret(mProperties.getProperty("clientSecret"))
                .setRedirectUri(mRedirectedURI)
                .build();
            mAuthorizationCodeUriRequest = mSpotifyApi.authorizationCodeUri().build();

            URI mUri = mAuthorizationCodeUriRequest.execute();
            System.out.println("URI: " + mUri.toString());

            AuthorizationCodeRequest mAuthorizationCodeUriRequest = mSpotifyApi.authorizationCode(mUri.toString()).build();
            AuthorizationCodeCredentials mAuthorizationCodeCredentials = mAuthorizationCodeUriRequest.execute();
            mSpotifyApi.setAccessToken(mAuthorizationCodeCredentials.getAccessToken());
            mSpotifyApi.setRefreshToken(mAuthorizationCodeCredentials.getRefreshToken());
            System.out.println("Expires in: " + mAuthorizationCodeCredentials.getExpiresIn());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        Mimo.DEBUGER.startMethod("initSpotifyClient()");
        Mimo.DEBUGER.printToken(mSpotify.getPluginName() ,"Access", mSpotifyApi.getAccessToken());
        Mimo.DEBUGER.printToken(mSpotify.getPluginName(),"Refresh", mSpotifyApi.getRefreshToken());
    }
   
}