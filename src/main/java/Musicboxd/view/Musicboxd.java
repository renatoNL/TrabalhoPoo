package Musicboxd.view;

import Musicboxd.control.*;
import Musicboxd.model.*;

import java.util.Scanner;

public class Musicboxd {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        MenuHomeControl menuHome = new MenuHomeControl();

        System.out.println("Seja Bem-Vindo ao Musicboxsd!");

        menuHome.telaInicial();



    }
}