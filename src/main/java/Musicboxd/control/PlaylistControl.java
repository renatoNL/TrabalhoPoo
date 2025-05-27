package Musicboxd.control;

import Musicboxd.dto.PlaylistRecordDto;
import Musicboxd.model.Playlist;
import Musicboxd.repository.PlaylistRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<Object> getOnePlaylist(@PathVariable(value = "id") Long playlistID) {
        Optional<Playlist> playlist0 = playlistRepository.findById(playlistID);
        return playlist0.<ResponseEntity<Object>>map(playlist -> ResponseEntity.status(HttpStatus.OK).body(playlist))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Playlist is not found"));
    }

    @PutMapping("/playlists/{id}")
    public ResponseEntity<Object> updatePlaylist(@PathVariable(value = "id") Long playlistID,
                                                 @RequestBody @Valid PlaylistRecordDto playlistRecordDto) {
        Optional<Playlist> playlist0 = playlistRepository.findById(playlistID);
        if (playlist0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Playlist is not found");
        }
        var playlist = playlist0.get();
        BeanUtils.copyProperties(playlistRecordDto, playlist);
        return ResponseEntity.status(HttpStatus.OK).body(playlistRepository.save(playlist));
    }

    @DeleteMapping("/playlists/{id}")
    public ResponseEntity<Object> deletePlaylist(@PathVariable Long id) {
        Optional<Playlist> playlist = playlistRepository.findById(id);
        if (playlist.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Playlist not found");
        }
        playlistRepository.delete(playlist.get());
        return ResponseEntity.status(HttpStatus.OK).body("Playlist deleted successfully");
    }

}