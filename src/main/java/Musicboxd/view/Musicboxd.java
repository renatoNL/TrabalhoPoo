package Musicboxd.view;

import Musicboxd.service.MenuHomeService;

public class Musicboxd {
    public static void main(String[] args) {

//        Scanner scanner = new Scanner(System.in);
        MenuHomeService menuHome = new MenuHomeService();

        System.out.println("Seja Bem-Vindo ao Musicboxsd!");

        menuHome.telaInicial();



    }
}