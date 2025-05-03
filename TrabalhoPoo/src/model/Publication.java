package model;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Publication {

    private List<String> publication;
    private int publicationID;

    private String description;
    private int rating;
    private boolean like;

//    public Publication(List<String> publication,int PublicationID,String description,int rating,boolean Like) {
//        this.publication = publication;
//        this.publicationID = publicationID;
//        this.description = description;
//        this.rating = rating;
//        this.like = like;
//    }

    public Publication(){

    }
    public List<String> getPublication(){
        return publication;
    }

    public void setPublicationID(int publicationID){
        this.publicationID = publicationID;
    }

    public void setDescription(String description){
        this.description = description;
    }

     public String getDescription(){
        return description;   //Comentário da publicação
     }

    public void setRating(int rating){
        this.rating = rating;
    }

    public int getRating(){
        return rating;   //Avaliação da publicação
    }

    public void setLike(boolean like){
        this.like = like;
    }

    public boolean getLike(){
        return like;    //Curtida da publicação
    }
}
