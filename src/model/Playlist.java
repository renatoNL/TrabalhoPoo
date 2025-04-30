package model;

import java.util.Scanner;

import java.util.ArrayList;

import java.util.List;


public class Playlist extends Music {

	private List<String> playlist;

	private String nomePlaylist;

	public Playlist(List<String> playlist, String nomePlaylist) {
		this.playlist = playlist;
		this.nomePlaylist = nomePlaylist;
	}

	public Playlist() {

	}

	public List<String> getPlaylist() {
		return playlist;
	}

	public void setPlaylist(List<String> playlist) {
		this.playlist = playlist;
	}

	public String getNomePlaylist() {
		return nomePlaylist;
	}

	public void setNomePlaylist(String nomePlaylist) {
		this.nomePlaylist = nomePlaylist;
	}
}