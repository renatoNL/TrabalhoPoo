package Musicboxd.control;

import Musicboxd.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class UserEntryControl extends User {


    Scanner scn = new Scanner(System.in);
    List<User> usuariosCadastrados = new ArrayList<>();

    List<String> usersEmail = new ArrayList<>();

    public void registerUser() {
        // Verificar se o usuario ja nao está cadastrado

        System.out.println("=== Cadastro de Usuário ===");
        System.out.print("Nome de usuário: ");
        setName(scn.nextLine());

        System.out.print("Email: ");
        setEmail(scn.nextLine());
        usersEmail.add(getEmail());

        System.out.print("Senha: ");
        setPassword(scn.nextLine());


        // Verifica se já existe um usuário com o mesmo email
        for (User user : usuariosCadastrados) {
            if (user.getEmail().equals(getEmail())) {
                System.out.println("Usuário com esse email já cadastrado!");
                return;
            }
        }

        // Cadastra novo usuário
        User novoUsuario = new User();
        usuariosCadastrados.add(novoUsuario);
        System.out.println("Usuário cadastrado com sucesso!");
    }


    public void login() {

        System.out.println("==== Login ====");
        System.out.print("Email: ");
        String email = scn.nextLine();

        System.out.print("Senha: ");
        String password = scn.nextLine();

        for (User user : usuariosCadastrados) {
            if (user.getEmail().equalsIgnoreCase(email) && user.getPassword().equals(password)) {
                System.out.println("Login bem-sucedido! Bem-vindo, " + user.getName());
                return;
            }
        }
    }

    public void recuperacao() {

        System.out.println("=== Recuperação de Senha ===");
        System.out.print("Digite seu email: ");
        String emailDigitado = scn.nextLine();

        for (User user : usuariosCadastrados) {
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

    public boolean validacao(String email, String senha) {
        // Verifica se o email tem pelo menos um "@" e um "."
        if (!email.contains("@") || !email.contains(".")) {
            System.out.println("Email inválido.");
            return false;
        }

        // Verifica se a senha tem pelo menos 6 caracteres
        if (senha.length() < 6) {
            System.out.println("A senha deve ter pelo menos 6 caracteres.");
            return false;
        }


        return true;
    }
}