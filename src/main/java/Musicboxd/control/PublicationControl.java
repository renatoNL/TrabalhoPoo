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


    private List<Publication> allPublications = new ArrayList<>();

    public void CreatePublication() {
        Publication newPublication = new Publication();
        List<String> publication = new ArrayList<>();

        System.out.println("=== Deseja escrever um comentário? ===");
        String answer = scn.nextLine();//caso o usuario responda sim, ele poderá deixar um comentario sobre a musica
        if (answer.equalsIgnoreCase("sim")) {

            System.out.println("\n--------------- Digite a música ---------------");
            String songName = scn.nextLine();
            newPublication.setSongName(songName);

            System.out.println("\n--------------- Escreva o seu comentário: ---------------");
            String comment = scn.nextLine();
            newPublication.setComment(comment);
            publication.add("Comentário: " + comment + ("\n---------------"));//mostra o comentário na hora da saída dos dados.

        }

        System.out.println("Deixe sua avaliação");
        int rating = scn.nextInt();

        if (rating <= 0)
            rating = 1;
        if (rating > 10)
            rating = 10;

        newPublication.setRating(rating);
        publication.add("Avaliação: " + rating + ("\n---------------"));

        scn.nextLine();//consome a quebra de linha deixada pelo nextInt

        System.out.println("Deseja deixar uma curtida?");
        answer = scn.nextLine();

        if (answer.equalsIgnoreCase("SIM")) {//condicional para verificar se o usuario quer deixar uma curtida
            newPublication.setLike(true);
            System.out.println("Like");

        }

        allPublications.add(newPublication);

        System.out.println("Comentário adicionado!");

        for (String publications : publication) {
            System.out.println(publications);
        }

             //cria uma variavel temporaria que percorre os dados de publication e imprime

        //        public void EditPublication() {
        //
        //        }



    }

    public void editPublication() {
        if (allPublications.isEmpty()){//verifica se há comentários
            System.out.println("Não há nenhuma publicação para editar!");
            return;
        }

        System.out.println("======= Publicações =======");
        for (int i = 0; i < allPublications.size(); i++){
            System.out.println("[" + i + "] " + allPublications.get(i).getSongName());
            System.out.println(allPublications.get(i).getComment());
        }//percorre os índices dos comentários pelo e mostra alem do indice o nome da musica e o comentario relacionado

        System.out.println("Escolha o número da publicação que você deseja editar");
        int index = scn.nextInt();
        scn.nextLine();

        if (index < 0 || index >= allPublications.size()){
            System.out.println("Índice inválido");
            return;
        }

        Publication selected = allPublications.get(index);

        System.out.println("Comentário antigo: " + selected.getComment());
        System.out.println("\n--------------- Escreva o seu comentário: ---------------");
        String newComment = scn.nextLine();
        selected.setComment(newComment);

        System.out.println("Avaliação antiga: " + selected.getRating());
        System.out.println("\n--------------- Avaliação: ---------------");
        int newRating = scn.nextInt();
        if (newRating <= 0)
            newRating = 1;
        if (newRating > 10)
            newRating = 10;
        selected.setRating(newRating);
        scn.nextLine();//consumir quebra

        System.out.println("Deseja deixar uma curtida?");
        String newAnswer = scn.nextLine();
        selected.setLike(newAnswer.equalsIgnoreCase("SIM"));

        System.out.println("Publicação atualizada!");
    }

    public void addMusic() {

    }

    public void deletePublication() {

    }

    public void FeatureInProfile() {

    }



}
