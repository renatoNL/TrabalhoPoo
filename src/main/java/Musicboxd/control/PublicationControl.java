package Musicboxd.control;

import Musicboxd.model.Publication;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Controller
public class PublicationControl extends Publication {
    //devo adicionar a classe musica aqui?para comentar especificamente na musica
    Scanner scn = new Scanner(System.in);
    Publication publication = new Publication();

    private List<Publication> allPublications = new ArrayList<>();

    public void CreatePublication() {

        List<String> publication = new ArrayList<>();

        System.out.println("=== Deseja escrever um comentário? ===");
        String answer = scn.nextLine();//caso o usuario responda sim, ele poderá deixar um comentario sobre a musica
        if (answer.equalsIgnoreCase("sim")) {

            System.out.println("\n---------------" + "Escreva o seu comentário: ");
            setComment(scn.nextLine());
            publication.add("Comentário: " + getComment() + ("\n---------------"));//mostra o comentário na hora da saída dos dados.

        }

        System.out.println("Deixe sua avaliação");
        setRating(scn.nextInt());
        publication.add("Avaliação: " + getRating() + ("\n---------------"));
        //#toDo -> lembrar de adicionar um limite e um minimo de avaliação

        scn.nextLine();//consome a quebra de linha deixada pelo nextInt

        System.out.println("Deseja deixar uma curtida?");
        answer = scn.nextLine();

        if (answer.equalsIgnoreCase("SIM")) {//condicional para verificar se o usuario quer deixar uma curtida
            setLike(true);
            System.out.println("Like");

        }
        System.out.println("Comentário adicionado!");

        for (String publications : publication) {
            System.out.println(publications);
        }

        for (int x = 0; x < allPublications.size(); x++) {
            System.out.println("[" + x + "] " + allPublications.get(x).getComment());
        }


        //cria uma variavel temporaria que percorre os dados de publication e imprime

        //        public void EditPublication() {
        //
        //        }



    }

    public void editPublication() {

        System.out.println("=== Você deseja editar a publicação? ===");


    }

    public void addMusic() {

    }

    public void deletePublication() {

    }

    public void FeatureInProfile() {

    }



}
