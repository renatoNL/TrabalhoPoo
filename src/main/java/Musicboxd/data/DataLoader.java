package Musicboxd.data; // Ou outro pacote adequado como Musicboxd.data

import Musicboxd.model.User;
import Musicboxd.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional; // Importar Optional

@Component
public class DataLoader implements CommandLineRunner {

    private final UserRepository userRepository;

    @Autowired
    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // --- Lógica de Povoamento de Usuários ---

        // Exemplo 1: Povoar se a tabela estiver completamente vazia
        if (userRepository.count() == 0) {
            System.out.println("Tabela 'User' vazia. Inserindo dados iniciais...");

            User user1 = new User(0, "Alice Silva", "Sou a Alice.", "alice@example.com", "Feminino", "senha123");
            User user2 = new User(0, "Bob Johnson", "Bob, desenvolvedor.", "bob@example.com", "Masculino", "senha456");
            User user3 = new User(0, "Charlie Brown", "Apenas o Charlie.", "charlie@example.com", "Outro", "senha789");

            // O ID (primeiro parâmetro no construtor de User) é 0 pois será gerado pelo banco de dados (IDENTITY).
            // Certifique-se de que o construtor da sua entidade User aceita um ID, mesmo que seja para ignorá-lo na persistência
            // ou use setters se o construtor for AllArgsConstructor.
            // Se você está usando lombok @NoArgsConstructor e @AllArgsConstructor, e o ID é auto-gerado,
            // considere um construtor sem ID para o povoamento ou use setters após a criação do objeto.
            // Para simplificar, vou usar setters para os dados fixos e o ID será 0 no construtor para fins de demonstração,
            // mas o @GeneratedValue cuidará disso.

            userRepository.save(user1);
            userRepository.save(user2);
            userRepository.save(user3);

            System.out.println("Usuários iniciais inseridos: " + userRepository.findAll());
        } else {
            System.out.println("Tabela 'User' já contém dados. Verificando por usuários específicos...");

            // Exemplo 2: Inserir um usuário específico apenas se ele não existir (verificando pelo email)
            String emailToPopulate = "diana.prince@example.com";
            Optional<User> existingDiana = userRepository.findByEmail(emailToPopulate);

            if (existingDiana.isEmpty()) {
                System.out.println("Usuário com email '" + emailToPopulate + "' não encontrado. Inserindo...");
                User diana = new User(0, "Diana Prince", "A guerreira amazona.", emailToPopulate, "Feminino", "amazona123");
                userRepository.save(diana);
                System.out.println("Usuário 'Diana Prince' inserido.");
            } else {
                System.out.println("Usuário com email '" + emailToPopulate + "' já existe. Pulando.");
            }

            // Exemplo 3: Outro usuário específico
            String emailToPopulate2 = "clark.kent@example.com";
            Optional<User> existingClark = userRepository.findByEmail(emailToPopulate2);

            if (existingClark.isEmpty()) {
                System.out.println("Usuário com email '" + emailToPopulate2 + "' não encontrado. Inserindo...");
                User clark = new User(0, "Clark Kent", "O homem de aço.", emailToPopulate2, "Masculino", "krypton123");
                userRepository.save(clark);
                System.out.println("Usuário 'Clark Kent' inserido.");
            } else {
                System.out.println("Usuário com email '" + emailToPopulate2 + "' já existe. Pulando.");
            }
        }
        System.out.println("--- Fim do povoamento de dados de usuários ---");
    }
}