package control;

import model.User;

import model.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserEntry{

    private static List<User> usuariosCadastrados = new ArrayList<>();

    Scanner scn = new Scanner(System.in);
    
    public void registerUser() {
        // Verificar se o usuario ja nao está cadastrado

        System.out.println("=== Cadastro de Usuário ===");
        System.out.print("Nome de usuário: ");
        String name = scn.nextLine();

        System.out.print("Email: ");
        String email = scn.nextLine();

        System.out.print("Senha: ");
        String password = scn.nextLine();

        // Verifica se já existe um usuário com o mesmo email
        for (User u : usuariosCadastrados) {
            if (u.getEmail().equalsIgnoreCase(email)) {
                System.out.println("Usuário com esse email já cadastrado!");
                return;
            }
        }

        // Cadastra novo usuário
        User novoUsuario = new User(name, email, password);
        usuariosCadastrados.add(novoUsuario);
        System.out.println("Usuário cadastrado com sucesso!");
    }


    public void login () {
        System.out.println("=== Login ===");
        System.out.print("Email: ");
        String email = scn.nextLine();

        System.out.print("Senha: ");
        String password = scn.nextLine();

        for (User u : usuariosCadastrados) {
            if (u.getEmail().equalsIgnoreCase(email) && u.getPassword().equals(password)) {
                System.out.println("Login bem-sucedido! Bem-vindo, " + u.getName());
                return;
            }
        }
    }

    public void recuperacao () {




    }

    public void validacao () {

    }

}