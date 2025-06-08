package Musicboxd.control;

import Musicboxd.dto.UserRecordDto;
import Musicboxd.exception.UserNotFoundException;
import Musicboxd.model.User;
import Musicboxd.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserControl {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/users")
    public ResponseEntity<User> saveUser(@RequestBody @Valid UserRecordDto userRecordDto) {
        var user = new User();
        BeanUtils.copyProperties(userRecordDto, user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userRepository.save(user));
    }


    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(userRepository.findAll());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Object> getOneUser(@PathVariable(value = "id") Long userID) {
        User user0 = userRepository.findById(userID).orElseThrow(() -> new UserNotFoundException(userID));

        return ResponseEntity.status(HttpStatus.OK).body(user0);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable(value = "id") Long userID,
                                             @RequestBody @Valid UserRecordDto userRecordDto) {
        User user0 = userRepository.findById(userID).orElseThrow(() -> new UserNotFoundException(userID));

        BeanUtils.copyProperties(userRecordDto, user0);
        return ResponseEntity.status(HttpStatus.OK).body(userRepository.save(user0));
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Object> deleteOneUser(@PathVariable(value = "id") Long userID) {
        Optional<User> user0 = userRepository.findById(userID);
        if (user0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User is not found");
        }
        userRepository.delete(user0.get());
        return ResponseEntity.status(HttpStatus.OK).body("User is deleted successfully");
    }

}
