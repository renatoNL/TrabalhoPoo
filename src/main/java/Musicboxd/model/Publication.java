package Musicboxd.model;

import jakarta.persistence.*;
import java.util.List;
import lombok.*;

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

}