package Musicboxd.control;

import Musicboxd.model.Publication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuHomeControl {

    Scanner scn = new Scanner(System.in);
    PlaylistControl playlist = new PlaylistControl();
    PublicationControl publication = new PublicationControl();
    UserEntryControl userEntry = new UserEntryControl();

    public void telaInicial() {
        int answer;


        do {
            System.out.println("\n=== Menu Inicial ===");
            System.out.println("1 - Entrar");
            System.out.println("2 - Cadastrar");
            System.out.println("3 - Criar Playlist"); //deixa aqui por enqnt, pra facilitar o test
            System.out.println("4 - Comentar Música");
            System.out.println("5 - Editar Comentário");//digo o mesmo por aqui
            System.out.println("6 - Sair\n");

            answer = scn.nextInt();
            //###TODO colocar a validação em alguma das lógicas aqui!
            switch (answer) {
                case 1:
                    userEntry.login();
                    break;
                case 2:
                    userEntry.registerUser();
                    break;
                case 3:
                    playlist.CreatePlaylist();
                    break;
                case 4:
                    publication.CreatePublication();
                    break;
                case 5:
                    publication.editPublication();
                    break;
                case 6:
                    System.out.println("Encerrando o programa!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }

        } while (answer != 6);  }
}

//    public String menu() {
//        System.out.println("=== Menu ===");
//        System.out.println("1 - Publicar");
//        System.out.println("2 - Criar Playlist");
//        System.out.println("3 - ");
//        return "";
//    }

