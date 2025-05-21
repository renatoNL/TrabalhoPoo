
package Musicboxd.service;
import Musicboxd.interfaces.PublicationServiceImple;
import Musicboxd.model.Publication;
import Musicboxd.model.Music;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PublicationService extends Music implements PublicationServiceImple {

    Scanner scn = new Scanner(System.in);

    int indexPublication = 0;
    List<Publication> allPublications = new ArrayList<>();
    List<String> MusicNames = new ArrayList<>();
    Publication newPublication = new Publication();

//##todo criar menu de escolha para o que o usuario quer editar na publicação e implementar logica do id
    int publicationId = 0;

    @Override
    public void createPublication() {

        List<String> publicationOutput = new ArrayList<>();


        System.out.println("\n------  Digite o nome da música ------ ");
        String songName = scn.nextLine();

        MusicNames.add(songName);

        newPublication.setPublicationId(publicationId + 1);//incrementa id em cada publicação criada

        System.out.println("\n------ Deseja escrever um comentário(Sim/Não)? ------ ");
        String answer = scn.nextLine();//caso o usuario responda sim, ele poderá deixar um comentario sobre a musica
        if (answer.equalsIgnoreCase("sim")) {

            System.out.println("\n------ Escreva o seu comentário: ------ ");
            String comment = scn.nextLine();
            newPublication.setComment(comment);
            publicationOutput.add("Comentário: " + comment + ("\n------ "));//mostra o comentário na hora da saída dos dados.

        }

        System.out.println("\n------ Deixe sua avaliação ------ ");
        int rating = scn.nextInt();

        rating = Math.max(0,Math.min(10, rating));//verifica se o numero é menor que 0 ou maior que 10 para evitar avaliações inválidas

        newPublication.setRating(rating);
        publicationOutput.add("Avaliação: " + rating + ("\n------ "));

        scn.nextLine();//consome a quebra de linha deixada pelo nextInt

        System.out.println("\n------  Deseja deixar uma curtida?(Sim/Não) ------ ");
        answer = scn.nextLine();

        if (answer.equalsIgnoreCase("SIM")) {//condicional para verificar se o usuario quer deixar uma curtida
            newPublication.setLiked(true);

        }

        allPublications.add(newPublication);

        System.out.println("------ ");
        System.out.println("\nComentário adicionado!\n");
        System.out.println("------ ");

        for (String publications : publicationOutput) {
            if(allPublications.isEmpty())
            {
                System.out.println("Você ainda não comentou nenhuma música!");
            }
            else System.out.println(publications);
        }

    }

    @Override
    public void showPublications() {
        for(int i = 0; i < allPublications.size(); i++) {
            System.out.printf("\n------ [ %d ] Comentário da música : %s ------ \n",i,MusicNames.get(i));

            if (allPublications.get(i).getComment() == null){
                System.out.println("");
            }else System.out.printf("Comentário: %s\n",allPublications.get(i).getComment());
            System.out.println("------\n");
            System.out.printf("Avaliação: %s\n",allPublications.get(i).getRating());
            System.out.println("------ \n");
            if (allPublications.get(i).liked){
                System.out.println("Comentário curtido\n");
            }else System.out.println("Comentário não curtido\n");

        }
    }

    @Override
    public void editPublication() {

        if (allPublications.isEmpty()){//verifica se há comentários
            System.out.println("Não há nenhuma publicação para editar!");
            return;
        }

        System.out.println("======= Publicações =======");
        for (int i = 0; i < allPublications.size(); i++){
            System.out.printf("[ %d ]",i,MusicNames.get(i));
            if (allPublications.get(i).getComment() == null){
                System.out.println("");
            }
        }//percorre os índices dos comentários e mostra alem do indice o nome da musica e o comentario relacionado

        System.out.println("\n--------------- Escolha o número da publicação que você deseja editar ---------------");
        int index = scn.nextInt();
        scn.nextLine();

        if (index < 0 || index >= allPublications.size()){
            System.out.println("Índice inválido");
            return;
        }//verificação do indice digitado

        Publication selected = allPublications.get(index);//variavel selected para armazenar o objeto da list na posicao digitada pelo usuario

        System.out.println("\n--> Comentário antigo: " + selected.getComment());
        System.out.println("\n--------------- Escreva o seu comentário: ---------------");
        String newComment = scn.nextLine();
        selected.setComment(newComment);
        //atualiza o comentário

        System.out.println("\n-->Avaliação antiga: " + selected.getRating());
        System.out.println("\n--------------- Avaliação: ---------------");
        int newRating = scn.nextInt();

        newRating = Math.max(1,Math.min(10, newRating));

        selected.setRating(newRating);//atualiza a avalição do usuário
        scn.nextLine();//consumir quebra de linha para evitar bugs

        System.out.println("\n--------------- Deseja deixar uma curtida? ---------------");
        String newAnswer = scn.nextLine();
        selected.setLiked(newAnswer.equalsIgnoreCase("SIM"));

        System.out.println("Publicação atualizada!");
    }

    @Override
    public void deletePublication() {

        if (allPublications.isEmpty()) {
            System.out.println("Não há nenhuma publicação para apagar");
            return;
        }

        for (int i = 0; i < allPublications.size(); i++) {
            System.out.println("[" + i + "] " + MusicNames.get(i));
            if (allPublications.get(i).getComment() == null){
                System.out.println("");
            }
        }


        System.out.println("Digite qual publicação deseja apagar");
        indexPublication = scn.nextInt();

        System.out.printf("%d", indexPublication);
        allPublications.remove(indexPublication);
        MusicNames.remove(indexPublication);

          System.out.println("Publicação apagada! ");


    }

}
