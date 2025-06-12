package Musicboxd.repository;

import Musicboxd.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional; // Importar Optional

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}