package com.example.demo.Service;
import com.example.demo.Constants.TempMapsEnum;
import com.example.demo.Model.Music;
import com.example.demo.Model.Track;
import com.example.demo.custom.Exception.AuthenticationException;
import com.example.demo.custom.Exception.EmptyInputException;
import com.example.demo.custom.Exception.WrongInputException;
import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.credentials.ClientCredentials;
import com.wrapper.spotify.model_objects.specification.ExternalUrl;
import com.wrapper.spotify.model_objects.specification.Paging;
import com.wrapper.spotify.model_objects.specification.Playlist;
import com.wrapper.spotify.model_objects.specification.PlaylistTrack;
import com.wrapper.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;
import com.wrapper.spotify.requests.data.playlists.GetPlaylistRequest;
import com.wrapper.spotify.requests.data.playlists.GetPlaylistsItemsRequest;
import org.apache.hc.core5.http.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author: Sharvari Nagesh
 * Gets the weather information and fetches music playlist from spotify by calling spotifyAPIs.
 */
@Service
public class SpotifyService {

    private final String clientId = "289e2bf559284078b0a030f9307ecc39";
    private final String clientSecret ="ad379faffc214eddbd117744e8d9362d";
    private SpotifyApi spotifyApi = new SpotifyApi.Builder()
            .setClientId(clientId)
            .setClientSecret(clientSecret)
            .build();

    private ClientCredentialsRequest clientCredentialsRequest = spotifyApi.clientCredentials().build();
    private ClientCredentials clientCredentials = null;

    private void setClientCredentials() {
        System.out.println("Inside setClientCredential function");
        try {
            clientCredentials = clientCredentialsRequest.execute();
            //TODO : to be removed
            System.out.println(clientCredentials.getAccessToken());
            System.out.println("Credentials expire in :" + clientCredentials.getExpiresIn());
            spotifyApi.setAccessToken(clientCredentials.getAccessToken());
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            System.out.println("Error: " + e.getMessage());
            throw new AuthenticationException("602", "Authentication of Spotify failed!");
        }
    }

    private TempMapsEnum getTrackForTemp(float temp) {
        for (TempMapsEnum tempMapsEnum : TempMapsEnum.values()) {
            if (temp <= tempMapsEnum.getHigh() & temp >= tempMapsEnum.getLow()) {
                return tempMapsEnum;
            }
        }
        return TempMapsEnum.Hot; // If no match found, return track for Hot weather
    }

    private Music getMusicList(Playlist playlist){
        Music music = new Music();
        PlaylistTrack playlistTrack;
        music.setName( playlist.getName());
        music.setHref(playlist.getExternalUrls().get("spotify"));
        Paging<PlaylistTrack> playlistTracks = playlist.getTracks();
        List<PlaylistTrack> playlistTrackList = Arrays.asList(playlistTracks.getItems());
        Iterator<PlaylistTrack> playlistTrackIterator = playlistTrackList.iterator();
        while (playlistTrackIterator.hasNext()){
            playlistTrack = playlistTrackIterator.next();
            Track track = new Track();
            if(playlistTrack != null & playlistTrack.getTrack() != null) {
                try {
                    track.setName(playlistTrack.getTrack().getName());
                    track.setExternalUrl(playlistTrack.getTrack().getExternalUrls().get("spotify"));
                    music.getTrackList().add(track);
                }catch (Exception e){
                    System.out.println("One of the tracks is empty. Ignoring the track");
                }
            }
        }
        return music;
    }


    public Music get_album(float temp){
        try{
            if(clientCredentials == null || clientCredentials.getExpiresIn() < 60) {
                setClientCredentials();
            }
            System.out.println("Credentials expire in :" + clientCredentials.getExpiresIn());
            TempMapsEnum tempMapsEnum = getTrackForTemp(temp);
            GetPlaylistRequest getPlaylistRequest = spotifyApi.getPlaylist(tempMapsEnum.getTrack()).build();
            Playlist playlist = getPlaylistRequest.execute();
            if(playlist == null){
                throw new EmptyInputException("606", "Spotify Playlist is Empty");
            }
            Music music = getMusicList(playlist);
            System.out.println("Play List: " + music.toString());
            return music;

        } catch (IOException | SpotifyWebApiException | ParseException e) {
            System.out.println("Error: " + e.getMessage());
            throw new WrongInputException("604", "Spotify failed to get album!");
        }
    }
}
