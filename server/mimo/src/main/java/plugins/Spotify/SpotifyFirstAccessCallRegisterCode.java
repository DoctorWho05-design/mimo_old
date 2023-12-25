package plugins.Spotify;

import java.io.IOException;
import java.net.URI;
import java.util.Scanner;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.credentials.AuthorizationCodeCredentials;
import se.michaelthelin.spotify.requests.authorization.authorization_code.AuthorizationCodeRequest;
import se.michaelthelin.spotify.requests.authorization.authorization_code.AuthorizationCodeUriRequest;
import org.apache.hc.core5.http.ParseException;

class SpotifyFirstAccessCallRegisterCode {
    private SpotifyApi mSpotifyApi;
    private AuthorizationCodeUriRequest mAuthorizationCodeUriRequest;
    private String mRefreshToken;
    private String mAccessToken;
    private String mCode;
    private AuthorizationCodeRequest mAuthorizationCodeRequest;
    private AuthorizationCodeCredentials mAuthorizationCodeCredentials;
    
    public SpotifyFirstAccessCallRegisterCode(SpotifyApi mSpotifyApi) {
        initSpotifyCallSpotifyCode(mSpotifyApi);
    }

    private void initSpotifyCallSpotifyCode(SpotifyApi mSpotifyApi) {
        this.mSpotifyApi = mSpotifyApi;
        callAuthorizationCodeUriRequest();
    }

    private void callAuthorizationCodeUriRequest() {
        try {
            mAuthorizationCodeUriRequest = mSpotifyApi.authorizationCodeUri().build();
            URI mUri = mAuthorizationCodeUriRequest.execute();
            System.out.println("URI: " + mUri.toString());
            Scanner mScanner = new Scanner(System.in);
            System.out.println("Enter Spotify Access Code:");
            mCode = mScanner.nextLine();

            mAuthorizationCodeRequest = mSpotifyApi.authorizationCode(mCode).build();
            mAuthorizationCodeCredentials = mAuthorizationCodeRequest.execute();

            mRefreshToken = mAuthorizationCodeCredentials.getRefreshToken();
            mAccessToken = mAuthorizationCodeCredentials.getAccessToken();
            
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            e.printStackTrace();
        }
    }
    public String getRefreshToken() {return mRefreshToken;}

    public String getAccessToken() {return mAccessToken;}
}
