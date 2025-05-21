


package Musicboxd.service;

import org.springframework.stereotype.Service;

import java.util.Scanner;

import static java.lang.System.exit;

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
            System.out.println("3 - Recuperar Senha");
            System.out.println("4 - Sair do Programa\n");

            answer = scn.nextInt();
            switch (answer) {
                case 1:
                  boolean resultadoLogin = userEntry.login();

                    if(resultadoLogin) {
                        menuAfterLogged();
                    }

                    break;
                case 2:
                    userEntry.registerUser();
                    break;
                case 3:
                    userEntry.recovery();
                    break;
                case 4:
                    System.out.println("Encerrando o programa!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (continueMenu);

    }


    public void menuAfterLogged() {
        boolean continueMenu = true;
        int answer;

        do {

            System.out.println("\n=== Menu ===");
            System.out.println("1 - Criar Playlist");
            System.out.println("2 - editar Playlist");
            System.out.println("3 - Comentar Música");
            System.out.println("4 - Ver suas Publicações");
            System.out.println("5 - Editar publicação");
            System.out.println("6 - Apagar publicação");
            System.out.println("7 - Ver Perfil");
            System.out.println("8 - Sair do Perfil");
            System.out.println("9 - Sair do Programa\n");

            answer = scn.nextInt();
            switch (answer) {

                case 1:
                    playlist.createPlaylist();
                    break;
                case 2:
                    playlist.EditPlaylist();
                    break;
                case 3:
                    publication.createPublication();
                    break;
                case 4:
                    publication.showPublications();
                    break;
                case 5:
                    publication.editPublication();
                    break;
                case 6:
                    publication.deletePublication();
                    break;
                case 7:
                    if (userEntry.getNewUser().getEmail() == null) {
                        System.out.println("Nenhum usuário está logado. Faça login primeiro.");
                    } else {
                        userProfile.userDetails(userEntry);
                    }
                    break;

                case 8:
                    if (userEntry.getNewUser().getEmail() == null) {
                        System.out.println("Nenhum usuário está logado.");
                    } else {
                        userEntry.logout();
                        System.out.println("Logout realizado com sucesso.");
                        telaInicial();
                    }
                    break;

                case 9:
                    System.out.println("Encerrando o programa!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }


        } while (continueMenu);

    }

}