package Musicboxd.control;

import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlaylistControl extends Music {



    Playlist playlistUser = new Playlist();

    Scanner scn = new Scanner (System.in);


    public void CreatePlaylist() {


        List<String> playlist = new ArrayList<>();

        Scanner scn = new Scanner(System.in);
        System.out.print("Informe o nome da sua playlist: ");
        playlistUser.setPlaylistName(scn.nextLine());
       playlist.add("Playlist  " + playlistUser.getPlaylistName());

        System.out.print("Quantas músicas deseja inserir em sua Playlist? : ");
        int quantitySongs = scn.nextInt(); //variavel exclusiva para looping de inserções.
        scn.nextLine(); //variavel para receber o buffer do int (evitar bug);
        System.out.println("Informe agora os detalhes das músicas que deseja inserir na Playlist");

        for(int x = 1; x <= quantitySongs; x++){

        System.out.printf("\nNome da %d música = ", x);
        setSongName(scn.nextLine()); //Inserção direta de string para parametro do metodo da class Music
        playlist.add("Nome da música = " + getSongName()); //list recebe 2 strings (gets retornam string tbm)

         System.out.print("Artista = ");
         setArtist(scn.nextLine());
        playlist.add("Artista = " + getArtist());

        System.out.print("Genero = ");
        setGenre(scn.nextLine());
        playlist.add("Genero = " + getGenre());

        System.out.print("Album = ");
        setAlbum(scn.nextLine());
        playlist.add("Album = " + getAlbum());

        System.out.println("\nMusica Inserida! ");

        }

        // List<Playlist> allPlayListsUser = new ArrayList<>(); // FUTURA list para inserir playlists criadas

        //     allPlayListsUser.add(new Playlist(playlist, playlistUser.getPlaylistName(), 1 (mudar o id dps)); //Lista com playlists criadas pelo usuario,
        //                                                                                       //cada uma possui id e nome, e claro, seu conteudo (inserido dentro da lista playlist).
        //        for (Playlist playlists : allPlayListsUser) {
        //
        //            System.out.println(playlists.getUserPlaylist());
        //
        //
        //        }

        for (String playlists: playlist) {

            System.out.println(playlists);


            if (playlists.contains("Playlist ")) {
                System.out.println("----------");
            }

            if (playlists.contains("Album ")) {
                System.out.println("--------\n");
            }
        }

    }


    public void EditPlaylist() {

    }

}
