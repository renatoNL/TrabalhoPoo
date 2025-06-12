package Musicboxd.control;

import Musicboxd.dto.PublicationRecordDto;
import Musicboxd.model.Publication;
import Musicboxd.repository.PublicationRepository;
import Musicboxd.exception.PublicationNotFoundException; // Import your new exception
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PublicationControl {

    @Autowired
    PublicationRepository publicationRepository;

    @PostMapping("/publications")
    public ResponseEntity<Publication> savePublication(@RequestBody @Valid PublicationRecordDto publicationRecordDto) {
        var publication = new Publication();
        BeanUtils.copyProperties(publicationRecordDto, publication);
        return ResponseEntity.status(HttpStatus.CREATED).body(publicationRepository.save(publication));
    }

    @GetMapping("/publications")
    public ResponseEntity<List<Publication>> getAllPublications() {
        return ResponseEntity.status(HttpStatus.OK).body(publicationRepository.findAll());
    }

    @GetMapping("/publications/{id}")
    public ResponseEntity<Publication> getOnePublication(@PathVariable(value = "id") Long publicationID) {
        Publication publication = publicationRepository.findById(publicationID)
                .orElseThrow(() -> new PublicationNotFoundException(publicationID));
        return ResponseEntity.status(HttpStatus.OK).body(publication);
    }

    @PutMapping("/publications/{id}")
    public ResponseEntity<Publication> updatePublication(@PathVariable(value = "id") Long publicationID,
                                                         @RequestBody @Valid PublicationRecordDto publicationRecordDto) {
        Publication publication = publicationRepository.findById(publicationID)
                .orElseThrow(() -> new PublicationNotFoundException(publicationID));

        BeanUtils.copyProperties(publicationRecordDto, publication);
        return ResponseEntity.status(HttpStatus.OK).body(publicationRepository.save(publication));
    }

    @DeleteMapping("/publications/{id}")
    public ResponseEntity<String> deleteOnePublication(@PathVariable(value = "id") Long publicationID) {
        Publication publication = publicationRepository.findById(publicationID)
                .orElseThrow(() -> new PublicationNotFoundException(publicationID));

        publicationRepository.delete(publication);
        return ResponseEntity.status(HttpStatus.OK).body("Publication is deleted successfully");
    }
}