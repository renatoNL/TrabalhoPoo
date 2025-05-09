package Musicboxd.control;

import Musicboxd.model.*;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Controller
public class PlaylistControl extends Music {
    Scanner scn = new Scanner(System.in);

    Playlist playlistUser = new Playlist();
    List<Playlist> allPlayListsUser = new ArrayList<>();
    List<String> playlist = new ArrayList<>();

    int playlistid = 0;
    public void CreatePlaylist() {




        System.out.print("Informe o nome da sua playlist: ");
        playlistUser.setPlaylistName(scn.nextLine());
        playlist.add("Playlist  " + playlistUser.getPlaylistName());


        InsertSongOnPlaylist();

        playlistUser.setPlaylistID(playlistid + 1);

        allPlayListsUser.add(new Playlist(playlistUser.getPlaylistID(), playlist, playlistUser.getPlaylistName())); //list para inserir playlists criadas



        for (String playlists : playlist) {

            System.out.println(playlists);


            if (playlists.contains("Playlist ")) {
                System.out.println("----------");
            }

            if (playlists.contains("Album ")) {
                System.out.println("--------\n");
            }
        }

    }








    // 1- allPlayListsUser - É uma lista de listas, toda playlist criada será inserida nessa lista "pai"
    // 2- cada playlist terá seu id unico (pode ser uma variavel local msm)





    //   ;Lista com playlists criadas pelo usuario
    //   cada uma possui id e nome, e claro, seu conteudo (inserido dentro da lista playlist).
    //        for (Playlist playlists : allPlayListsUser) {  //Printar todas Playlists do Usuario
    //
    //            System.out.println(playlists.getUserPlaylist());
    //
    //
    //        }






    public void EditPlaylist() {
        System.out.println("Qual playlist deseja editar? ");
        int numeroPlaylist = 0;
        for (Playlist playlists : allPlayListsUser) {  //Printar todas Playlists do Usuario

            System.out.println(++numeroPlaylist + " playlist -> " + playlists.getPlaylistName());


        }

        System.out.println("Informe o numero : ");
        numeroPlaylist = scn.nextInt();

        for (Playlist playlists : allPlayListsUser)
        {


            if (playlists.getPlaylistID() == numeroPlaylist) {
                System.out.println("Deseja editar : ");
                System.out.println("1 - Nome da Playlist");
                System.out.println("3 - Inserir Musica");
                System.out.println("2 - Deletar Musica");

                int resp = scn.nextInt();

                switch (resp) {
                    case 1:
                        scn.nextLine();
                        System.out.println("Informe o novo nome ");
                        playlists.setPlaylistName(scn.nextLine());
                        break;

                    case 2:
                        System.out.println(playlists.getUserPlaylist());
                        InsertSongOnPlaylist();


                }


            }

        }
    }


    public void InsertSongOnPlaylist(){

        System.out.print("Quantas músicas deseja inserir em sua Playlist? : ");
        int quantitySongs = scn.nextInt(); //variavel exclusiva para looping de inserções.
        scn.nextLine(); //variavel para receber o buffer do int (evitar bug);
        System.out.println("Informe agora os detalhes das músicas que deseja inserir na Playlist");

        for (int x = 1; x <= quantitySongs; x++) {

            System.out.printf("\nNome da %d música = ", x);
            setSongName(scn.nextLine()); //Inserção direta de string para parametro do metodo da class Music
            playlist.add("Nome da música = " + getSongName());

            System.out.print("Artista = ");
            setArtist(scn.nextLine());
            playlist.add("Artista = " + getArtist());

            System.out.print("Genero = ");
            setGenre(scn.nextLine());
            playlist.add("Genero = " + getGenre());


            System.out.print("Album = ");
            setAlbum(scn.nextLine());
            playlist.add("Genero = " + getAlbum());


            System.out.println("\nMusica Inserida! ");
        }
    }
}



