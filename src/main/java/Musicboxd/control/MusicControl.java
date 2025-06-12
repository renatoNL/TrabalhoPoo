package Musicboxd.control;

import Musicboxd.dto.MusicRecordDto;
import Musicboxd.model.Music;
import Musicboxd.repository.MusicRepository;
import Musicboxd.exception.MusicNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<Music> getOneMusic(@PathVariable(value = "id") Long musicID) {
        Music music = musicRepository.findById(musicID)
                .orElseThrow(() -> new MusicNotFoundException(musicID));
        return ResponseEntity.status(HttpStatus.OK).body(music);
    }

    @PutMapping("/musics/{id}")
    public ResponseEntity<Music> updateMusic(@PathVariable(value = "id") Long musicID,
                                             @RequestBody @Valid MusicRecordDto musicRecordDto) {
        Music music = musicRepository.findById(musicID)
                .orElseThrow(() -> new MusicNotFoundException(musicID));

        BeanUtils.copyProperties(musicRecordDto, music);
        return ResponseEntity.status(HttpStatus.OK).body(musicRepository.save(music));
    }

    @DeleteMapping("/musics/{id}")
    public ResponseEntity<String> deleteOneMusic(@PathVariable(value = "id") Long musicID) {
        Music music = musicRepository.findById(musicID)
                .orElseThrow(() -> new MusicNotFoundException(musicID));

        musicRepository.delete(music);
        return ResponseEntity.status(HttpStatus.OK).body("música deletada com sucesso!");
    }
}