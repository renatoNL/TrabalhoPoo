package Musicboxd.service;


import Musicboxd.model.*;
import java.util.ArrayList;
import java.util.List;

import Musicboxd.interfaces.PlaylistServiceImple;
import org.springframework.stereotype.Service;
import java.util.Scanner;
import java.util.HashMap;



@Service
public class PlaylistService extends Music implements PlaylistServiceImple {
    static Scanner scn = new Scanner(System.in);

    Playlist playlistUser = new Playlist();
    static List<Playlist> allPlayListsUser = new ArrayList<>();
    static List<String> playlist = new ArrayList<>();

    int playlistid = 0;

    @Override
    public void createPlaylist() {

        System.out.print("Informe o nome da sua playlist: ");
        playlistUser.setPlaylistName(scn.nextLine());
        playlist.add("=== Playlist  " + playlistUser.getPlaylistName() + " ===");


        insertSongOnPlaylist();

        playlistUser.setPlaylistID(playlistid + 1); //incremento do id semrpe q for criado uma nova playlist

        allPlayListsUser.add(new Playlist(playlistUser.getPlaylistID(), playlist, playlistUser.getPlaylistName())); //list para inserir playlists criadas



        for (String playlists : playlist) {

            System.out.println(playlists);


            if (playlists.contains("Playlist ")) {
                System.out.print("");
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
    @Override
public void getPlaylistsNames(){ //função exclusiva pra imrpimir o nome das playlists
       for (Playlist playlist : allPlayListsUser)  //esse for permite q a variavel playlist, por receber playlists do usuario, utilizar o metodo getName em cada playlist.
           System.out.println(playlist.getPlaylistName());
       }




    public void EditPlaylist() {

        PlaylistService pc = new PlaylistService(); //instnacia da classe pq esse methodo é static, e quero usar um metodo q não seja static
        System.out.println("Qual playlist deseja editar? ");
        int numeroPlaylist = 0;
        for (Playlist playlists : allPlayListsUser) {  //Printar todas Playlists do Usuario

            System.out.println(++numeroPlaylist + " playlist -> " + playlists.getPlaylistName());


        }

        System.out.println("Informe o numero : ");
        numeroPlaylist = scn.nextInt();

        playlistid = 1;


                if (numeroPlaylist >= 1 && numeroPlaylist <= allPlayListsUser.size()) {
                    Playlist playlistSelecionada = allPlayListsUser.get(numeroPlaylist - 1);

                    System.out.println("Deseja editar : ");
                    System.out.println("1 - Nome da Playlist");
                    System.out.println("2 - Inserir Musica");
                    System.out.println("3 - Deletar Musica");
                    System.out.println("4 - Deletar Playlist");

                    int resp = scn.nextInt();

                    switch (resp) {
                        case 1:
                            scn.nextLine();
                            System.out.println("Informe o novo nome ");
                            playlistSelecionada.setPlaylistName(scn.nextLine());
                            break;

                        case 2:

                            insertSongOnPlaylist();
                            break;

                        case 3:

                            if (playlistSelecionada.getUserPlaylist().isEmpty()) {
                                System.out.println("Não há nenhuma musica na playlist para apagar");
                                return;
                            } else {
                                deleteSongOnPlaylist(playlistSelecionada);
                            }
                            break;

                        case 4:
                            allPlayListsUser.remove(numeroPlaylist - 1);
                            break;

                    }


                }
            }





    static HashMap<String, String> musicaId= new HashMap<String, String>(); //hashmap pra inserir musicas e seus ids


    @Override
    public void insertSongOnPlaylist(){

        System.out.print("Quantas músicas deseja inserir em sua Playlist? : ");
        int quantitySongs = scn.nextInt(); //variavel exclusiva para looping de inserções.

        scn.nextLine(); //variavel para receber o buffer do int (evitar bug);

        if (quantitySongs == 0){
            System.out.println("Nenhuma música inserida");
        } else {
            System.out.println("Informe agora os detalhes das músicas que deseja inserir na Playlist");

            for (int x = 1; x <= quantitySongs; x++) {
                //sempre q houver a chamada do metodo insertsongonplaylist, a musica recebe seu id
                setMusicID(getMusicID() + 1);
                System.out.printf("\nNome da %d música = ", x);
                setSongName(scn.nextLine()); //Inserção direta de string para parametro do metodo da class Music
                playlist.add(getSongName());
                musicaId.put(getSongName(), getSongName());

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
        }
    }

    public static void deleteSongOnPlaylist(Playlist playlists){
        System.out.println("Musicas existentes na playlist: \n");
        if (musicaId.isEmpty()){
            System.out.println("Não há músicas existentes");
        } else {
            musicaId.forEach((IdMusica, NomeMusica) -> {
                System.out.println(NomeMusica);
            });

            System.out.println("Informe nome da música que deseja deletar: ");
            scn.nextLine();
            String songToDelete = scn.nextLine();
            if (playlists.getUserPlaylist().contains(songToDelete)) {
                for (int i = 0; i < playlists.getUserPlaylist().size(); i++) { //cada item da list conta no seu comprimento, logo, 1 musica = 4 itens (nome, artista, genero, album) 2 musicas = 8 itens...

                    String musicDeleted = playlists.getUserPlaylist().get(i); //recebe os indices da list.

                    if (musicDeleted.equalsIgnoreCase(songToDelete)) { //comparacao do indice atual (musicDeleted) com a musica q o usuario pede pra apagar
                        if (i + 3 < playlists.getUserPlaylist().size()) {
                            playlists.getUserPlaylist().subList(i, i + 4).clear(); //cria uma sublist, limpando do indice do nome da musica até o album
                            System.out.println("Musica removida");

                        }

                        musicaId.remove(songToDelete); //remoção do da musica no hashmap)
                        break;
                    }
                }
            } else {
                System.out.println("Não existe essa música na playlist");
            }
        }
    }





}


