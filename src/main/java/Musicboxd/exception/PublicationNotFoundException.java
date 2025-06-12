package Musicboxd.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PublicationNotFoundException extends RuntimeException {

    public PublicationNotFoundException(Long id) {
        super("Publication with ID " + id + " not found.");
    }
}