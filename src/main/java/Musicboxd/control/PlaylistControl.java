package Musicboxd.control;

import Musicboxd.dto.PlaylistRecordDto;
import Musicboxd.model.Playlist;
import Musicboxd.repository.PlaylistRepository;
import Musicboxd.exception.PlaylistNotFoundException; // Import your new exception
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlaylistControl {

    @Autowired
    PlaylistRepository playlistRepository;

    @PostMapping("/playlists")
    public ResponseEntity<Playlist> savePlaylist(@RequestBody @Valid PlaylistRecordDto playlistRecordDto) {
        var playlist = new Playlist();
        BeanUtils.copyProperties(playlistRecordDto, playlist);
        return ResponseEntity.status(HttpStatus.CREATED).body(playlistRepository.save(playlist));
    }

    @GetMapping("/playlists")
    public ResponseEntity<List<Playlist>> getAllPlaylists() {
        return ResponseEntity.status(HttpStatus.OK).body(playlistRepository.findAll());
    }

    @GetMapping("/playlists/{id}")
    public ResponseEntity<Playlist> getOnePlaylist(@PathVariable(value = "id") Long playlistID) {
        Playlist playlist = playlistRepository.findById(playlistID)
                .orElseThrow(() -> new PlaylistNotFoundException(playlistID));
        return ResponseEntity.status(HttpStatus.OK).body(playlist);
    }

    @PutMapping("/playlists/{id}")
    public ResponseEntity<Playlist> updatePlaylist(@PathVariable(value = "id") Long playlistID,
                                                   @RequestBody @Valid PlaylistRecordDto playlistRecordDto) {
        Playlist playlist = playlistRepository.findById(playlistID)
                .orElseThrow(() -> new PlaylistNotFoundException(playlistID));

        BeanUtils.copyProperties(playlistRecordDto, playlist);
        return ResponseEntity.status(HttpStatus.OK).body(playlistRepository.save(playlist));
    }

    @DeleteMapping("/playlists/{id}")
    public ResponseEntity<String> deletePlaylist(@PathVariable(value = "id") Long id) { // Adjusted @PathVariable name to match method parameter
        Playlist playlist = playlistRepository.findById(id)
                .orElseThrow(() -> new PlaylistNotFoundException(id));

        playlistRepository.delete(playlist);
        return ResponseEntity.status(HttpStatus.OK).body("Playlist deleted successfully");
    }
}