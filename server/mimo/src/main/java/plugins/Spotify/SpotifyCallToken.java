package plugins.Spotify;

import java.net.URI;

import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.model_objects.credentials.AuthorizationCodeCredentials;
import se.michaelthelin.spotify.requests.authorization.authorization_code.AuthorizationCodeRequest;
import se.michaelthelin.spotify.requests.authorization.authorization_code.AuthorizationCodeUriRequest;

class SpotifyCallToken {
    private SpotifyApi mSpotifyApi;
    private AuthorizationCodeUriRequest mAuthorizationCodeUriRequest;
    private String mRefreshToken;
    private String mAccessToken;
    private AuthorizationCodeRequest mAuthorizationCodeRequest;
    private AuthorizationCodeCredentials mAuthorizationCodeCredentials;
    
    public SpotifyCallToken(SpotifyApi mSpotifyApi) {
        initSpotifyCallRefreshToken(mSpotifyApi);
    }

    private void initSpotifyCallRefreshToken(SpotifyApi mSpotifyApi) {
        this.mSpotifyApi = mSpotifyApi;
    }

    public void callRefreshToken() {
        try {
            
            mAuthorizationCodeUriRequest = mSpotifyApi.authorizationCodeUri().build();

            URI mUri = mAuthorizationCodeUriRequest.execute();
            System.out.println("URI: " + mUri.toString());

            mAuthorizationCodeRequest = mSpotifyApi.authorizationCode(mUri.toString()).build();
            mAuthorizationCodeCredentials = mAuthorizationCodeRequest.execute();

            mRefreshToken = mAuthorizationCodeCredentials.getRefreshToken();
            mAccessToken = mAuthorizationCodeCredentials.getAccessToken();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getRefreshToken() {return mRefreshToken;}

    public String getAccessToken() {return mAccessToken;}
}
