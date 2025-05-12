
package Musicboxd.service;
import Musicboxd.model.Publication;
import Musicboxd.model.Music;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PublicationControl extends Music {

    Scanner scn = new Scanner(System.in);

    int indexPublication = 0;
    List<Publication> allPublications = new ArrayList<>();    List<String> MusicNames = new ArrayList<>();
    List<Integer> PublicationId = new ArrayList<Integer>();
    public void CreatePublication() {

        Publication newPublication = new Publication();
        List<String> publicationOutput = new ArrayList<>();

        //newPublication.setPublicationId(indexPublication);

//        int id = 0;
//        int PublicationId = id + 1;
//        PublicationId.add(PublicationId);

        System.out.println("\n--------------- Digite a música ---------------");
        String songName = scn.nextLine();

        MusicNames.add(songName);

        System.out.println("\n--------------- Deseja escrever um comentário? ---------------");
        String answer = scn.nextLine();//caso o usuario responda sim, ele poderá deixar um comentario sobre a musica
        if (answer.equalsIgnoreCase("sim")) {

            System.out.println("\n--------------- Escreva o seu comentário: ---------------");
            String comment = scn.nextLine();
            newPublication.setComment(comment);
            publicationOutput.add("Comentário: " + comment + ("\n---------------"));//mostra o comentário na hora da saída dos dados.

        }

        System.out.println("\n--------------- Deixe sua avaliação ---------------");
        int rating = scn.nextInt();

        rating = Math.max(0,Math.min(10, rating));//verifica se o numero é menor que 0 ou maior que 10 para evitar avaliações inválidas

        newPublication.setRating(rating);
        publicationOutput.add("Avaliação: " + rating + ("\n---------------"));

        scn.nextLine();//consome a quebra de linha deixada pelo nextInt

        System.out.println("\n--------------- Deseja deixar uma curtida? ---------------");
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
            System.out.println("[" + i + "] " + MusicNames.get(i));
            System.out.println(allPublications.get(i).getComment());
        }//percorre os índices dos comentários e mostra alem do indice o nome da musica e o comentario relacionado

        System.out.println("\n--------------- Escolha o número da publicação que você deseja editar ---------------");
        int index = scn.nextInt();
        scn.nextLine();

        if (index < 0 || index >= allPublications.size()){
            System.out.println("Índice inválido");
            return;
        }//verificação do indice digitado

        Publication selected = allPublications.get(index);//variavel selected para armazenar o objeto da list na posicao digitada pelo usuario

        System.out.println("\n--> Comentário antigo: " + selected.getComment());//atualiza o comentário
        System.out.println("\n--------------- Escreva o seu comentário: ---------------");
        String newComment = scn.nextLine();
        selected.setComment(newComment);

        System.out.println("\n-->Avaliação antiga: " + selected.getRating());
        System.out.println("\n--------------- Avaliação: ---------------");
        int newRating = scn.nextInt();

        newRating = Math.max(1,Math.min(10, newRating));

        selected.setRating(newRating);//atualiza a avalição do usuário
        scn.nextLine();//consumir quebra

        System.out.println("\n--------------- Deseja deixar uma curtida? ---------------");
        String newAnswer = scn.nextLine();
        selected.setLiked(newAnswer.equalsIgnoreCase("SIM"));//atualiza a curtida

        System.out.println("Publicação atualizada!");
    }

    public void addMusic() {

    }

    public void deletePublication() {

        if (allPublications.isEmpty()) {
            System.out.println("Não há nenhuma publicação para apagar");
            return;
        }

        for (int i = 0; i < allPublications.size(); i++) {
            System.out.println("[" + i + "] " + MusicNames.get(i));
            System.out.println(allPublications.get(i).getComment());
        }


        System.out.println("Digite qual publicação deseja apagar");
        indexPublication = scn.nextInt();

        System.out.printf("%d", indexPublication);
        allPublications.remove(indexPublication);
        MusicNames.remove(indexPublication);

          System.out.println("Publicação apagada! ");


    }

    public void FeatureInProfile() {

    }//



}
