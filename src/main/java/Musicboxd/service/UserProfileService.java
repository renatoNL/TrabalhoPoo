package Musicboxd.service;


import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class UserProfileService {

//ve se coloca algo a mais ai pro perfil, como destacar musica ou coisas gays a mais, ve como fica melhor.

    Scanner scn = new Scanner(System.in);
    PlaylistService pc = new PlaylistService();
  PublicationService publi = new PublicationService();


    public void userDetails(UserEntryService userEntry){

                                                          //Classe userEntryControl foi passada como argumento, pois é necessário acessar os gets de lá
                                                            //Era possivel criar um construtor e usar uma notação de injeção do Spring tbm, mas aproveitei a instancia dessa
                                                            //classe lá no menuHomeControl.

        System.out.println("Nome do usuário = " + userEntry.getNewUser().getName());
        System.out.println("\n--------------- Bio ---------------\n" + userEntry.getNewUser().getBio());
        System.out.println("\n--------------- Playlists criadas ---------------\"");
        pc.getPlaylistsNames();

        System.out.println("\nDeseja editar a bio?  \n 1 - Sim\n 2 - Não\n escolha o número correspondente: ");

        int anwser = scn.nextInt();

       switch(anwser){
           case 1:
               editarBio(userEntry);
               break;

           case 2:
               break;

           default:
               System.out.println("Opção inválida");
       }

    }


    public void editarBio(UserEntryService userEntry){
        System.out.println("Digite a sua nova bio = ");
        scn.nextLine();
        userEntry.getNewUser().setBio(scn.nextLine());
    }

    public void editPlaylist () {  //ja fiz isso, ja q esse metodo ja tava aqui, so chamei oq eu ja fiz
        pc.EditPlaylist();
    }

    public void editPublication () {
        publi.editPublication();
    }

    public void deletePublication () {
        publi.editPublication();
    }

}
