package Musicboxd.control;

import Musicboxd.dto.PublicationRecordDto;
import Musicboxd.model.Publication;
import Musicboxd.repository.PublicationRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<Object> getOnePublication(@PathVariable(value = "id") Long publicationID) {
        Optional<Publication> publication0 = publicationRepository.findById(publicationID);
        return publication0.<ResponseEntity<Object>>map(publication ->
                ResponseEntity.status(HttpStatus.OK).body(publication)).orElseGet(() ->
                ResponseEntity.status(HttpStatus.NOT_FOUND).body("Publication is not found"));
    }

    @PutMapping("/publications/{id}")
    public ResponseEntity<Object> updatePublication(@PathVariable(value = "id") Long publicationID,
                                                    @RequestBody @Valid PublicationRecordDto publicationRecordDto) {
        Optional<Publication> publication0 = publicationRepository.findById(publicationID);
        if (publication0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Publication is not found");
        }
        var publication = publication0.get();
        BeanUtils.copyProperties(publicationRecordDto, publication);
        return ResponseEntity.status(HttpStatus.OK).body(publicationRepository.save(publication));
    }

    @DeleteMapping("/publications/{id}")
    public ResponseEntity<Object> deleteOnePublication(@PathVariable(value = "id") Long publicationID) {
        Optional<Publication> publication0 = publicationRepository.findById(publicationID);
        if (publication0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Publication is not found");
        }
        publicationRepository.delete(publication0.get());
        return ResponseEntity.status(HttpStatus.OK).body("Publication is deleted successfully");
    }
}