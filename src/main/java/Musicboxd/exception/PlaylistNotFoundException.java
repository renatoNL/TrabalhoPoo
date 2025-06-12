package Musicboxd.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PlaylistNotFoundException extends RuntimeException {

    public PlaylistNotFoundException(Long id) {
        super("Playlist with ID " + id + " not found.");
    }
}