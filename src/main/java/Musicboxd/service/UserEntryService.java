package Musicboxd.service;

import Musicboxd.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class UserEntryService {

    User newUser = new User();
    Scanner scn = new Scanner(System.in);
    List<User> registeredUsers = new ArrayList<>();

    List<String> usersEmail = new ArrayList<>();

    public void registerUser() {

        User newUser = new User(); // nova instância

        System.out.println("===   Cadastro de Usuário  ===");
        System.out.print("Nome de usuário: ");
        newUser.setName(scn.nextLine());

        System.out.print("Email: ");
        String email = scn.nextLine();

        System.out.print("Senha: ");
        String senha = scn.nextLine();

        // Validação
        if (!validation(email, senha)) {
            System.out.println("Cadastro falhou. Dados inválidos.");
            return;
        }

        // Verifica se email já existe
        for (User user : registeredUsers) {
            if (user.getEmail().equals(email)) {
                System.out.println("Usuário com esse email já cadastrado!");
                return;
            }
        }

        newUser.setEmail(email);
        newUser.setPassword(senha);
        usersEmail.add(email);
        registeredUsers.add(newUser);

        System.out.println("Usuário cadastrado com sucesso!");
    }

    public void login() {

        System.out.println("==== Login ====");
        System.out.print("Email: ");
        String email = scn.nextLine();


        System.out.print("Senha: ");
        String password = scn.nextLine();

        for (User user : registeredUsers) {
            if (user.getEmail() != null && user.getPassword() != null &&
                    user.getEmail().equalsIgnoreCase(email) &&
                    user.getPassword().equals(password)) {

                this.newUser = user;
                System.out.println("Login bem-sucedido! Bem-vindo, " + user.getName());
                return;
            }
        }
        System.out.println("Email ou  senha incorretos.");
    }

    public User getNewUser(){
        return newUser;
    }
    public void recovery() {

        System.out.println("=== Recuperação de Senha ===");
        System.out.print("Digite seu email: ");
        String emailDigitado = scn.nextLine();

        for (User user : registeredUsers) {
            if (user.getEmail().equals(emailDigitado)) {
                System.out.print("Digite a nova senha: ");
                String novaSenha = scn.nextLine();
                user.setPassword(novaSenha);
                System.out.println("Senha redefinida com sucesso!");
                return;
            }
        }
        System.out.println("Email não encontrado.");
    }

    public void logout() {
        this.newUser = new User();
    }

    public boolean validation(String email, String senha) {

        if (!email.contains("@") || !email.contains(".")) {
            System.out.println("Email inválido.");
            return false;
        }


        if (senha.length() < 6) {
            System.out.println("A senha deve ter pelo menos 6 caracteres.");
            return false;
        }


        return true;
    }
}