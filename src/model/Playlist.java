package model;

import java.util.Scanner;

import java.util.ArrayList;

import java.util.List;


public class Playlist extends Music {

	private int playlistID;
	private List<String> playlist;

	private String playlistName;

//	public Playlist(List<String> playlist, String playlistName) {
//		this.playlist = playlist;
//		this.playlistName = playlistName;
//	}

	public Playlist() {

	}

	public List<String> getPlaylist() { //Lista com playlists criadas
		return playlist;
	}

	public void setPlaylist(List<String> playlist) {
		this.playlist = playlist;
	}

	public void setPlaylistName(String playlistName){
		this.playlistName = playlistName;
	}


}
