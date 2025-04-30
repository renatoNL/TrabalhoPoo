package control;

import model.Playlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlaylistControl extends Playlist {

    Scanner scn = new Scanner(System.in);
    List<String> playlist = new ArrayList<>();

    public void createPlaylist() {

        System.out.print("Informe o nome da sua playlist: ");
        setNomeMusica(scn.nextLine());
//      playlist.add("Playlist  " + setNomeMusica());

        System.out.println("Informe agora os detalhes das músicas que deseja inserir na Playlist");

        System.out.print("\nNome da música = ");
        setNomeMusica(scn.nextLine()); //Inserção direta de string para parametro do metodo da class Music
        playlist.add("Nome da música = " + getNomeMusica()); //list recebe 2 strings (gets retornam string tbm)

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

        for (String playlists : playlist) {

            System.out.println(playlists);

            if (playlists.contains("Playlist ")) {
                System.out.println("----------");
            }
        }

    }

    public void editPlaylist() {

    }

}
