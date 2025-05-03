package view;

import control.*;
import model.*;

import java.util.Scanner;

public class Musicboxd {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        MenuHome menuHome = new MenuHome();

        System.out.println("Seja Bem-Vindo ao Musicboxsd!");

        menuHome.telaInicial();

    }
}