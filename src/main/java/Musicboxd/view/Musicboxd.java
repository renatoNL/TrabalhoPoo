package Musicboxd.view;

import Musicboxd.service.MenuHomeControl;

import java.util.Scanner;

public class Musicboxd {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        MenuHomeControl menuHome = new MenuHomeControl();

        System.out.println("Seja Bem-Vindo ao Musicboxsd!");

        menuHome.telaInicial();



    }
}