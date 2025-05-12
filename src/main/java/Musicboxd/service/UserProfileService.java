package Musicboxd.service;


import org.springframework.stereotype.Service;

@Service
public class UserProfileService {

//ve se coloca algo a mais ai pro perfil, como destacar musica ou coisas gays a mais, ve como fica melhor.


  PlaylistService pc = new PlaylistService();
  PublicationService publi = new PublicationService();


    public void userDetails(UserEntryService userEntry){    //Classe userEntryControl foi passada como argumento, pois é necessário acessar os gets de lá
                                                            //Era possivel criar um construtor e usar uma notação de injeção do Spring tbm, mas aproveitei a instancia dessa
                                                            //classe lá no menuHomeControl.

        System.out.println("Nome do usuário = " + userEntry.getNewUser().getName());
        System.out.println("Bio = " + userEntry.getNewUser().getBio());
        System.out.println("Playlists criadas = ");
        pc.getPlaylistsNames();

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
