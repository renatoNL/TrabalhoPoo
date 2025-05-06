  package Musicboxd.control;

  import model.Publication;

  import java.util.ArrayList;
  import java.util.List;
  import java.util.Scanner;


    public class PublicationControl extends Publication {
    //devo adicionar a classe musica aqui?para comentar especificamente na musica
        Scanner scn = new Scanner(System.in);
        Publication publication = new Publication();

        public void CreatePublication() {

            List<String> publication = new ArrayList<>();

            System.out.println("Deseja escrever um comentário? ");
            String resposta = scn.nextLine();//caso o usuario responda sim, ele poderá deixar um comentario sobre a musica
            if (resposta.equalsIgnoreCase("sim")) {

                System.out.println("\n---------------"+"Escreva o seu comentário: ");
                setDescription(scn.nextLine());
                publication.add("Comentário: " + getDescription()+("\n---------------"));//mostra o comentário na hora da saída dos dados.
            }

            System.out.println("Deixe sua avaliação");
            setRating(scn.nextInt());
            publication.add("Avaliação: "+getRating()+("\n---------------"));
            //#toDo -> lembrar de adicionar um limite e um minimo de avaliação

            scn.nextLine();//consome a quebra de linha deixada pelo nextInt

            System.out.println("Deseja deixar uma curtida?");
            resposta = scn.nextLine();

            if (resposta.equalsIgnoreCase("SIM")){//condicional para verificar se o usuario quer deixar uma curtida
            setLike(true);
                System.out.println("Like");;
            }
            System.out.println("Comentário adicionado!");

            for (String publications: publication){
                System.out.println(publications);

            }//cria uma variavel temporaria que percorre os dados de publication e imprime

    //        public void EditPublication() {
    //
    //        }

        }
    public void addMusic () {

    }

    public void addPublication () {

    }

    public void FeatureInProfile () {

    }

    public void editPublication () {

    }

}
