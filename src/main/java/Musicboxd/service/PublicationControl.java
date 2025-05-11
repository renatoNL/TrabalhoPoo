package Musicboxd.service;
import Musicboxd.model.Publication;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class PublicationControl extends Publication {
    //devo adicionar a classe musica aqui?para comentar especificamente na musica
    Scanner scn = new Scanner(System.in);

    List<Publication> allPublications = new ArrayList<>();

    public void CreatePublication() {
        Publication newPublication = new Publication();
        List<String> publicationOutput = new ArrayList<>();

        System.out.println("=== Deseja escrever um comentário? ===");
        String answer = scn.nextLine();//caso o usuario responda sim, ele poderá deixar um comentario sobre a musica
        if (answer.equalsIgnoreCase("sim")) {

            System.out.println("\n--------------- Digite a música ---------------");
            String songName = scn.nextLine();
            newPublication.setSongName(songName);

            System.out.println("\n--------------- Escreva o seu comentário: ---------------");
            String comment = scn.nextLine();
            newPublication.setComment(comment);
            publicationOutput.add("Comentário: " + comment + ("\n---------------"));//mostra o comentário na hora da saída dos dados.

        }

        System.out.println("Deixe sua avaliação");
        int rating = scn.nextInt();

        rating = Math.max(1,Math.min(10, rating));//verifica se o numero 

        newPublication.setRating(rating);
        publicationOutput.add("Avaliação: " + rating + ("\n---------------"));

        scn.nextLine();//consome a quebra de linha deixada pelo nextInt

        System.out.println("Deseja deixar uma curtida?");
        answer = scn.nextLine();

        if (answer.equalsIgnoreCase("SIM")) {//condicional para verificar se o usuario quer deixar uma curtida
            newPublication.setLiked(true);
            System.out.println("Like");

        }

        allPublications.add(newPublication);

        System.out.println("Comentário adicionado!");

        for (String publications : publicationOutput) {
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

        Publication selected = allPublications.get(index);//o selected funciona como uma referencia
        //ao Publication e altera o objeto da lista original

        System.out.println("Comentário antigo: " + selected.getComment());//atualiza o comentário
        System.out.println("\n--------------- Escreva o seu comentário: ---------------");
        String newComment = scn.nextLine();
        selected.setComment(newComment);

        System.out.println("Avaliação antiga: " + selected.getRating());
        System.out.println("\n--------------- Avaliação: ---------------");
        int newRating = scn.nextInt();

        newRating = Math.max(1,Math.min(10, newRating));

        selected.setRating(newRating);//atualiza a avalição do usuário
        scn.nextLine();//consumir quebra

        System.out.println("Deseja deixar uma curtida?");
        String newAnswer = scn.nextLine();
        selected.setLiked(newAnswer.equalsIgnoreCase("SIM"));//atualiza a curtida

        System.out.println("Publicação atualizada!");
    }

    public void addMusic() {

    }

    public void deletePublication() {

        if (allPublications.isEmpty()){
            System.out.println("Não há nenhuma publicação para apagar");
            return;
        }

        for (int i = 0; i < allPublications.size(); i++){
            System.out.println("[" + i + "] " + allPublications.get(i).getSongName());
            System.out.println(allPublications.get(i).getComment());
        }
        int j,index;

        System.out.println("Digite qual publicação deseja apagar");
        index = scn.nextInt();

        Publication selected = allPublications.get(index);

        System.out.println("Publicação selecionada! ");


    }

    public void FeatureInProfile() {

    }



}
