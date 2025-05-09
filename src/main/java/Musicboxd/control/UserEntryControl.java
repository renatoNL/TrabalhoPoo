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


        System.out.println("===   Cadastro de Usuário  ===");
        System.out.print("Nome de usuário: ");
        setName(scn.nextLine());


        System.out.print("Email: ");
        setEmail(scn.nextLine());
        usersEmail.add(getEmail());

        System.out.print("Senha: ");
        setPassword(scn.nextLine());



        for (User user : usuariosCadastrados) {
            if (user.getEmail().equals(getEmail())) {
                System.out.println("Usuário com esse email já cadastrado!");
                return;
            }
        }


        User novoUsuario = new User();
        novoUsuario.setEmail(getEmail());
        novoUsuario.setPassword(getPassword());
        novoUsuario.setName(getName());

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
            if (user.getEmail() != null && user.getPassword() != null &&
                    user.getEmail().equalsIgnoreCase(email) &&
                    user.getPassword().equals(password)) {

                System.out.println("Login bem-sucedido! Bem-vindo, " + user.getName());
                return;
            }
        }
        System.out.println("Email ou senha incorretos.");
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

        if (!email.contains(" @ ") || !email.contains(".")) {
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