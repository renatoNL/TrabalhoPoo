package Musicboxd.data;

import Musicboxd.model.Music;
import Musicboxd.repository.MusicRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.ArrayList;

@Component
public class InitialData implements CommandLineRunner {

    private final MusicRepository musicRepository;

    @Autowired
    public InitialData(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    @Override
    public void run(String... args){
        List<Music> allDesiredMusics = new ArrayList<>();

        allDesiredMusics.add(new Music(0, "Bohemian Rhapsody", "Queen", "Rock", "A Night at the Opera"));
        allDesiredMusics.add(new Music(0, "Hotel California", "Eagles", "Rock", "Hotel California"));
        allDesiredMusics.add(new Music(0, "Stairway to Heaven", "Led Zeppelin", "Rock", "Led Zeppelin IV"));
        allDesiredMusics.add(new Music(0, "Sweet Child o' Mine", "Guns N' Roses", "Rock", "Appetite for Destruction"));
        allDesiredMusics.add(new Music(0, "Smells Like Teen Spirit", "Nirvana", "Grunge", "Nevermind"));

        allDesiredMusics.add(new Music(0, "Billie Jean", "Michael Jackson", "Pop", "Thriller"));
        allDesiredMusics.add(new Music(0, "Like a Virgin", "Madonna", "Pop", "Like a Virgin"));
        allDesiredMusics.add(new Music(0, "Blinding Lights", "The Weeknd", "Pop", "After Hours"));
        allDesiredMusics.add(new Music(0, "Shape of You", "Ed Sheeran", "Pop", "÷ (Divide)"));
        allDesiredMusics.add(new Music(0, "Bad Guy", "Billie Eilish", "Pop", "When We All Fall Asleep, Where Do We Go?"));

        allDesiredMusics.add(new Music(0, "Lose Yourself", "Eminem", "Hip-Hop", "8 Mile Soundtrack"));
        allDesiredMusics.add(new Music(0, "California Love", "2Pac ft. Dr. Dre", "Hip-Hop", "All Eyez on Me"));
        allDesiredMusics.add(new Music(0, "N.Y. State of Mind", "Nas", "Hip-Hop", "Illmatic"));
        allDesiredMusics.add(new Music(0, "Alright", "Kendrick Lamar", "Hip-Hop", "To Pimp a Butterfly"));
        allDesiredMusics.add(new Music(0, "Sicko Mode", "Travis Scott", "Trap", "Astroworld"));

        allDesiredMusics.add(new Music(0, "VAMPIRINHA", "Matuê", "Trap", "Máquina do Tempo"));
        allDesiredMusics.add(new Music(0, "Máquina do Tempo", "Matuê", "Trap", "Máquina do Tempo"));
        allDesiredMusics.add(new Music(0, "Kenny G", "Matuê", "Trap", "Kenny G"));
        allDesiredMusics.add(new Music(0, "Antes", "Matuê", "Trap", "Antes"));
        allDesiredMusics.add(new Music(0, "Quer Voar", "Matuê", "Trap", "Quer Voar"));
        allDesiredMusics.add(new Music(0, "777-666", "Matuê", "Trap", "777-666"));
        allDesiredMusics.add(new Music(0, "Balmain", "WIU", "Trap", "Balmain"));
        allDesiredMusics.add(new Music(0, "FODA QUE ELA É LINDA", "Teto", "Trap", "FIM DE SEMANA NO RIO"));
        allDesiredMusics.add(new Music(0, "M4", "Teto, Matuê, WIU", "Trap", "M4"));
        allDesiredMusics.add(new Music(0, "Satisfação", "Major RD", "Trap", "Satisfação"));
        allDesiredMusics.add(new Music(0, "Money", "Cardi B", "Trap", "Money"));
        allDesiredMusics.add(new Music(0, "Trap Queen", "Fetty Wap", "Trap", "Fetty Wap"));
        allDesiredMusics.add(new Music(0, "Goosebumps", "Travis Scott", "Trap", "Birds in the Trap Sing McKnight"));
        allDesiredMusics.add(new Music(0, "Ric Flair Drip", "Offset & Metro Boomin", "Trap", "Without Warning"));
        allDesiredMusics.add(new Music(0, "Praise The Lord (Da Shine)", "A$AP Rocky ft. Skepta", "Hip-Hop/Trap", "Testing"));

        allDesiredMusics.add(new Music(0, "Wake Me Up", "Avicii", "EDM", "True"));
        allDesiredMusics.add(new Music(0, "Levels", "Avicii", "EDM", "Levels"));
        allDesiredMusics.add(new Music(0, "Closer", "The Chainsmokers ft. Halsey", "EDM Pop", "Collage"));
        allDesiredMusics.add(new Music(0, "Titanium", "David Guetta ft. Sia", "EDM", "Nothing but the Beat"));
        allDesiredMusics.add(new Music(0, "Animals", "Martin Garrix", "EDM", "Animals"));

        allDesiredMusics.add(new Music(0, "Garota de Ipanema", "Tom Jobim", "MPB", "Getz/Gilberto"));
        allDesiredMusics.add(new Music(0, "Anna Julia", "Los Hermanos", "MPB/Rock", "Los Hermanos"));
        allDesiredMusics.add(new Music(0, "Amarelo, Azul e Branco", "Anavitória", "MPB/Pop", "O Tempo É Agora"));
        allDesiredMusics.add(new Music(0, "Evidências", "Chitãozinho & Xororó", "Sertanejo", "Evidências"));
        allDesiredMusics.add(new Music(0, "Paradinha", "Anitta", "Pop Brasileiro", "Paradinha"));

        allDesiredMusics.add(new Music(0, "Do I Wanna Know?", "Arctic Monkeys", "Indie Rock", "AM"));
        allDesiredMusics.add(new Music(0, "Sweater Weather", "The Neighbourhood", "Alternative Pop", "I Love You."));
        allDesiredMusics.add(new Music(0, "Mr. Brightside", "The Killers", "Indie Rock", "Hot Fuss"));
        allDesiredMusics.add(new Music(0, "The Less I Know The Better", "Tame Impala", "Psychedelic Pop", "Currents"));
        allDesiredMusics.add(new Music(0, "Lost in Japan", "Shawn Mendes", "Pop", "Shawn Mendes"));

        allDesiredMusics.add(new Music(0, "Crazy in Love", "Beyoncé ft. Jay-Z", "R&B", "Dangerously in Love"));
        allDesiredMusics.add(new Music(0, "Rolling in the Deep", "Adele", "Soul", "21"));
        allDesiredMusics.add(new Music(0, "Location", "Khalid", "R&B", "American Teen"));
        allDesiredMusics.add(new Music(0, "Watermelon Sugar", "Harry Styles", "Pop/Soul", "Fine Line"));
        allDesiredMusics.add(new Music(0, "Leave The Door Open", "Silk Sonic", "R&B/Soul", "An Evening with Silk Sonic"));

        allDesiredMusics.add(new Music(0, "Despacito", "Luis Fonsi ft. Daddy Yankee", "Latin Pop", "Vida"));
        allDesiredMusics.add(new Music(0, "Gasolina", "Daddy Yankee", "Reggaeton", "Barrio Fino"));
        allDesiredMusics.add(new Music(0, "Feliz Navidad", "José Feliciano", "Latin Christmas", "Feliz Navidad"));
        allDesiredMusics.add(new Music(0, "La Bamba", "Ritchie Valens", "Rock and Roll/Latin", "La Bamba"));
        allDesiredMusics.add(new Music(0, "Africa", "Toto", "Soft Rock", "Toto IV"));

        List<Music> allExistingMusicsInDB = musicRepository.findAll();
        for (Music desiredMusic : allDesiredMusics) {
            boolean musicExists = allExistingMusicsInDB.stream().anyMatch(m -> m.getSongName().equals(desiredMusic.getSongName()) && m.getArtist().equals(desiredMusic.getArtist()));
            if (!musicExists) {
                musicRepository.save(desiredMusic);
            }
        }
    }
}