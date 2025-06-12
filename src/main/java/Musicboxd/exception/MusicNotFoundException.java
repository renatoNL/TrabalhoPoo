package Musicboxd.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MusicNotFoundException extends RuntimeException {

    public MusicNotFoundException(Long id) {
        super("Music with ID " + id + " not found.");
    }
}