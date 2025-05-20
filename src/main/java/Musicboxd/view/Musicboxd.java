package Musicboxd.view;

import Musicboxd.service.MenuHomeService;

public class Musicboxd {
    public static void main(String[] args) {

        MenuHomeService menuHome = new MenuHomeService();

        System.out.println("Seja Bem-Vindo ao Musicboxsd!");

        menuHome.telaInicial();



    }
}