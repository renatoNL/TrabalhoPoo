package Musicboxd.control;

import Musicboxd.model.Publication;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Controller
public class PublicationControl extends Publication {

    private List<Publication> allPublications= new ArrayList<>();

    //devo adicionar a classe musica aqui?para comentar especificamente na musica
    Scanner scn = new Scanner(System.in);
    private boolean like;

    public void CreatePublication() {

        Publication newPublication = new Publication();
        List<String> publication = new ArrayList<>();

        System.out.println("=== Deseja escrever um comentário? ===");
        String answer = scn.nextLine();//caso o usuario responda sim, ele poderá deixar um comentario sobre a musica
        if (answer.equalsIgnoreCase("sim")) {

            System.out.println("\n---------------" + "Escreva o seu comentário: ");
            newPublication.setComment(scn.nextLine());
            publication.add("Comentário: " + newPublication.getComment() + ("\n---------------"));//mostra o comentário na hora da saída dos dados.

        }

        System.out.println("Deixe sua avaliação");
        newPublication.setRating(scn.nextInt());
        if (getRating() <= 0)
            setRating (1);
        else if (getRating() > 10 )
            setRating(10);
        publication.add("Avaliação: " + newPublication.getRating() + ("\n---------------"));

        scn.nextLine();//consome a quebra de linha deixada pelo nextInt

        System.out.println("Deseja deixar uma curtida?");
        answer = scn.nextLine();

        if (answer.equalsIgnoreCase("SIM")) {//condicional para verificar se o usuario quer deixar uma curtida
            newPublication.setLike(true);
            System.out.println("Like");

        }
        System.out.println("Comentário adicionado!");

        allPublications.add(newPublication);

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
