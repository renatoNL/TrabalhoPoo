package Musicboxd.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int musicID;

    private String songName;
    private String artist;
    private String genre;
    private String album;


}
