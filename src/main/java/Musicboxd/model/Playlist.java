package Musicboxd.model;

import java.util.List;


public class Playlist extends Music {

	private int playlistID;
	private String playlistName;
	private List<String> userPlaylist;

	public Playlist(List<String> userPlaylist, String playlistName, int playlistID) {
		this.userPlaylist = userPlaylist;
		this.playlistName = playlistName;
		this.playlistID = playlistID;
	}

	public Playlist(){

	}


	public void setPlaylistID(int playlistID){
		this.playlistID = playlistID;
	}

	public int getPlaylistID() {
		return playlistID;
	}

	public List<String> getUserPlaylist() { //Lista com playlists criadas
		return userPlaylist;
	}

	public void setPlaylist(List<String> userPlaylist) {
		this.userPlaylist = userPlaylist;
	}

	public void setPlaylistName(String playlistName){
		this.playlistName = playlistName;
    }

	public String getPlaylistName(){
		return playlistName;
	}


}
