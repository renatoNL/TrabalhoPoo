package Musicboxd.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Publication extends Music{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int publicationID;

    @ElementCollection
    private List<String> publication; // pode ser "conteudos" ou algo mais descritivo

    private String comment;
    private int rating;
    private boolean like;

}
