package org.jmusixmatch;

import org.jmusixmatch.entity.lyrics.Lyrics;
import org.jmusixmatch.entity.track.Track;
import org.jmusixmatch.entity.track.TrackData;

import java.util.Scanner;
import java.util.List;

public class MusixMatchAPITest {


  
    public static void main(String[] args) throws MusixMatchException  {

    	Scanner input = new Scanner(System.in);
        String apiKey = "aba3e86cbd453b7d0343c506c517c06a";
        MusixMatch musixMatch = new MusixMatch(apiKey);
        
        System.out.println("Enter track name: "); 
        String trackName = input.nextLine();
        
        System.out.println("\nEnter artist name: ");
        String artistName = input.nextLine();

        try {
        // Track Search [ Fuzzy ]
        Track track = musixMatch.getMatchingTrack(trackName, artistName);
        TrackData data = track.getTrack();

       // System.out.println("AlbumID : " + data.getAlbumId());
        System.out.println("Album Name : " + data.getAlbumName());
       // System.out.println("Artist ID : " + data.getArtistId());
        System.out.println("Album Name : " + data.getArtistName());
      //  System.out.println("Track ID : " + data.getTrackId());


        int trackID = data.getTrackId();

        Lyrics lyrics = musixMatch.getLyrics(trackID);
        System.out.println("Lyrics Body: \n" + lyrics.getLyricsBody());
       /* System.out.println("Lyrics ID       : " + lyrics.getLyricsId());
        System.out.println("Lyrics Language : " + lyrics.getLyricsLang());
       
        System.out.println("Script-Tracking-URL : " + lyrics.getScriptTrackingURL());
        System.out.println("Pixel-Tracking-URL : " + lyrics.getPixelTrackingURL());
        System.out.println("Lyrics Copyright : " + lyrics.getLyricsCopyright());

        
        List<Track> track2 = musixMatch.searchTracks("", "21 Savage", "", 10, 10, true);
        for (Track trk: track2) {
        	TrackData penis = trk.getTrack();
        System.out.println("AlbumID : " + penis.getAlbumId());
        System.out.println("Album Name : " + penis.getAlbumName());
        System.out.println("Artist ID : " + penis.getArtistId());
        System.out.println("Artist Name : " + penis.getArtistName());
        System.out.println("Track ID : " + penis.getTrackId());
        System.out.println();
        }
        // The following will search for tracks with matching artist_name 'Eminem'
        List<Track> tracks = musixMatch.searchTracks("", "Eminem", "", 10, 10, true);

        for (Track trk : tracks) {
            TrackData trkData = trk.getTrack();

            System.out.println("AlbumID : " + trkData.getAlbumId());
            System.out.println("Album Name : " + trkData.getAlbumName());
            System.out.println("Artist ID : " + trkData.getArtistId());
            System.out.println("Artist Name : " + trkData.getArtistName());
            System.out.println("Track ID : " + trkData.getTrackId());
            System.out.println();
        }
        
        */
        }
        catch(MusixMatchException e)
        {
        	e.getError();
        }

    }
}
