package Musicboxd.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
// @Getter
// @Setter
//os dois tao dando erro
@NoArgsConstructor
@AllArgsConstructor
public class Publication extends Music{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int publicationID;

    @ElementCollection
    private List<String> publication; // pode ser "conteudos" ou algo mais descritivo

    public String comment;
    public int rating;
    public boolean like;


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

    public boolean isLike() {
        return like;
    }

    public void setLike(boolean like) {
        this.like = like;
    }
}