package plugins.Spotify;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Properties;
import mimo.Mimo;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.SpotifyHttpManager;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.credentials.AuthorizationCodeCredentials;
import se.michaelthelin.spotify.requests.authorization.authorization_code.AuthorizationCodeRefreshRequest;
import org.apache.hc.core5.http.ParseException;

class SpotifyGenerateAccessCode {
    private SpotifyApi mSpotifyApi;
    private Spotify mSpotify;
    private URI mRedirectedURI;
    private Properties mProperties;
    private InputStream mInput; 
    private String mRefreshToken;
    private SpotifyFirstAccessCallRegisterCode mSpotifyFirstAccessCallRegisterCode;
    private AuthorizationCodeRefreshRequest mAuthorizationCodeRefreshRequest;
    private AuthorizationCodeCredentials mAuthorizationCodeCredentials;

    public SpotifyGenerateAccessCode(Spotify mSpotify) {
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
        mRefreshToken = mProperties.getProperty("refreshToken");
        
        if (mRefreshToken == null) {
            mSpotifyFirstAccessCallRegisterCode = new SpotifyFirstAccessCallRegisterCode(mSpotifyApi);
            mRefreshToken = mSpotifyFirstAccessCallRegisterCode.getRefreshToken();
        }

        mSpotifyApi = new SpotifyApi
                .Builder()
                .setClientId(mProperties.getProperty("clientID"))
                .setClientSecret(mProperties.getProperty("clientSecret"))
                .setRedirectUri(mRedirectedURI)
                .setRefreshToken(mRefreshToken)
                .build();
        
        mAuthorizationCodeRefreshRequest = mSpotifyApi.authorizationCodeRefresh().build();
        authorizationCodeRefresh();
        Mimo.DEBUGER.startMethod("initSpotifyClient()");
        Mimo.DEBUGER.printToken(mSpotify.getPluginName() ,"Access", mSpotifyApi.getAccessToken());
        Mimo.DEBUGER.printToken(mSpotify.getPluginName(),"Refresh", mSpotifyApi.getRefreshToken());
    }

    private void authorizationCodeRefresh() {
        try {
            mAuthorizationCodeCredentials  = mAuthorizationCodeRefreshRequest.execute();
            mSpotifyApi.setAccessToken(mAuthorizationCodeCredentials.getAccessToken());
            //System.out.println("Expires in: " + mAuthorizationCodeCredentials.getExpiresIn());

        } catch (IOException | SpotifyWebApiException | ParseException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void printAuthorizationCodeExpiresIn() {
        System.out.println("Expires in: " + mAuthorizationCodeCredentials.getExpiresIn());
    }

    public String getAccessToken() {
        authorizationCodeRefresh();
        return mSpotifyApi.getAccessToken();
    }

    public String getRefreshToken() {return mSpotifyApi.getRefreshToken();}
}