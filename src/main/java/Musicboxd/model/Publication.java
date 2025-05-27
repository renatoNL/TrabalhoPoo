package Musicboxd.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity

@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor
public class Publication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int publicationID;
    private List<String> publication;
    private String title;
    private String comment;
    private int rating;
    private boolean liked;

    public int indexPublication; // qual a utilidade disso?

}