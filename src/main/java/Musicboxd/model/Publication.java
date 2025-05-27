package Musicboxd.model;

import jakarta.persistence.*;
import lombok.*;


import java.util.List;

@Entity

//@Getter
//@Setter

@NoArgsConstructor
@AllArgsConstructor
public class Publication{



  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int PublicationId;

    @ElementCollection
    private List<String> publication;

    public String comment;
    public int rating;
    public boolean liked;

    public int indexPublication;

  public int getPublicationId() {
    return PublicationId;
  }

  public void setPublicationId(int publicationId) {
    PublicationId = publicationId;
  }

  public List<String> getPublication() {
    return publication;
  }

  public void setPublication(List<String> publication) {
    this.publication = publication;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public int getRating() {
    return rating;
  }

  public void setRating(int rating) {
    this.rating = rating;
  }

  public boolean isLiked() {
    return liked;
  }

  public void setLiked(boolean liked) {
    this.liked = liked;
  }

  public int getIndexPublication() {
    return indexPublication;
  }

  public void setIndexPublication(int indexPublication) {
    this.indexPublication = indexPublication;
  }
}
