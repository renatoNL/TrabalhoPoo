


package Musicboxd.service;

import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class MenuHomeService {

    Scanner scn = new Scanner(System.in);
    PlaylistService playlist = new PlaylistService();
    PublicationService publication = new PublicationService();
    UserEntryService userEntry = new UserEntryService();
    UserProfileService userProfile = new UserProfileService();

    public void telaInicial() {
        int answer;
        boolean continueMenu = true;

        do {
            System.out.println("\n=== Menu Inicial ===");
            System.out.println("1 - Entrar");
            System.out.println("2 - Cadastrar");
            System.out.println("3 - Criar Playlist"); //deixa aqui por enqnt, pra facilitar o test
            System.out.println("4 - editar Playlist");
            System.out.println("5 - Comentar Música");
            System.out.println("6 - Editar Comentário");
            System.out.println("7 - Apagar Comentário");
            System.out.println("8 - Ver Perfil");
            System.out.println("9 - Recuperar Senha");
            System.out.println("10 - Sair\n");

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
                    playlist.createPlaylist();
                    break;
                case 4:
                    playlist.EditPlaylist();
                    break;
                case 5:
                    publication.CreatePublication();
                    break;
                case 6:
                    publication.editPublication();
                    break;
                case 7:
                    publication.deletePublication();
                    break;
                case 8:
                    userProfile.userDetails(userEntry);
                    break;
                case 9:
                    userEntry.recovery();
                    break;
                case 10:
                    System.out.println("Encerrando o programa!");
                    continueMenu = false;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }

        } while (continueMenu);  }
}

//    public String menu() {
//        System.out.println("=== Menu ===");
//        System.out.println("1 - Publicar");
//        System.out.println("2 - Criar Playlist");
//        System.out.println("3 - ");
//        return "";
//    }