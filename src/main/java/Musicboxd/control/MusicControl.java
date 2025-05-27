package Musicboxd.control;

import Musicboxd.dto.MusicRecordDto;
import Musicboxd.model.Music;
import Musicboxd.repository.MusicRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MusicControl {

    @Autowired
    MusicRepository musicRepository;

    @PostMapping("/musics")
    public ResponseEntity<Music> saveMusic(@RequestBody @Valid MusicRecordDto musicRecordDto) {
        var music = new Music();
        BeanUtils.copyProperties(musicRecordDto, music);
        return ResponseEntity.status(HttpStatus.CREATED).body(musicRepository.save(music));
    }

    @GetMapping("/musics")
    public ResponseEntity<List<Music>> getAllMusics() {
        return ResponseEntity.status(HttpStatus.OK).body(musicRepository.findAll());
    }

    @GetMapping("/musics/{id}")
    public ResponseEntity<Object> getOneMusic(@PathVariable(value = "id") Long musicID) {
        Optional<Music> music0 = musicRepository.findById(musicID);
        return music0.<ResponseEntity<Object>>map(music -> ResponseEntity.status(HttpStatus.OK).body(music)).orElseGet(
                () -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Music is not found"));
    }

    @PutMapping("/musics/{id}")
    public ResponseEntity<Object> updateMusic(@PathVariable(value = "id") Long musicID,
                                              @RequestBody @Valid MusicRecordDto musicRecordDto) {
        Optional<Music> music0 = musicRepository.findById(musicID);
        if (music0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Music is not found");
        }
        var music = music0.get();
        BeanUtils.copyProperties(musicRecordDto, music);
        return ResponseEntity.status(HttpStatus.OK).body(musicRepository.save(music));
    }

    @DeleteMapping("/musics/{id}")
    public ResponseEntity<Object> deleteOneMusic(@PathVariable(value = "id") Long musicID) {
        Optional<Music> music0 = musicRepository.findById(musicID);
        if (music0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Music is not found");
        }
        musicRepository.delete(music0.get());
        return ResponseEntity.status(HttpStatus.OK).body("Music is deleted successfully");
    }
}
