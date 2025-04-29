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

	public void CreatePlaylist() {

		List<String> playlist = new ArrayList<>();
		Scanner scn = new Scanner(System.in);
		System.out.print("Informe o nome da sua playlist: ");
		nomePlaylist = scn.nextLine();
		playlist.add("Playlist  " + nomePlaylist);

		System.out.println("Informe agora os detalhes das músicas que deseja inserir na Playlist");

		System.out.print("\nNome da música = ");
		setNomeMusica(scn.nextLine()); //Inserção direta de string para parametro do metodo da class Music
		playlist.add("Nome da música = " + getNomeMusica());

		System.out.print("Artista = ");
		setArtista(scn.nextLine());
		playlist.add("Artista = " + getArtista());

		System.out.print("Genero = ");
		setGenero(scn.nextLine());
		playlist.add("Genero = " + getGenero());

		System.out.print("Album = ");
		setAlbum(scn.nextLine());
		playlist.add("Album = " + getAlbum());

		System.out.println("\nPlaylist Criada! ");

		for (String playlists: playlist) {

			System.out.println(playlists);

			if (playlists.contains("Playlist ")) {
				System.out.println("----------");
			}
		}

	}

	public List<String> getPlaylist() { //Lista com playlists criadas
		return playlist;
	}

	public void setPlaylist(List<String> playlist) {
		this.playlist = playlist;
	}

	public void EditarPlaylist() {

	}

}