package Musicboxd.service;

import Musicboxd.model.*;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProfileControl {

//ve se coloca algo a mais ai pro perfil, como destacar musica ou coisas gays a mais, ve como fica melhor.


  PlaylistControl pc = new PlaylistControl();


    public void userDetails(UserEntryControl userEntry){ //Classe userEntryControl foi passada como argumento, pois é necessário acessar os gets de lá
                                                        //Era possivel criar um construtor e usar uma notação de injeção do Spring tbm, mas aproveitei a instancia dessa
                                                        //classe lá no menuHomeControl.

        System.out.println("Nome do usuário = " + userEntry.getNewUser().getName());
        System.out.println("Bio = " + userEntry.getNewUser().getBio());
        System.out.println("Playlists criadas = ");
        pc.getPlaylistsNames();

    }


    public void EditPlaylist () {  //ja fiz isso, ja q esse metodo ja tava aqui, so chamei oq eu ja fiz
            PlaylistControl.EditPlaylist();
    }

    public void dislikePlaylist () { //n sei qm colocou isso

    }

    public void deletePublication () { //tbm n sei qm colocou, mas emmanuel ja fez algo assim lá no control publication

    }

}
