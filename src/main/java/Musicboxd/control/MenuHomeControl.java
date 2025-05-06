package Musicboxd.control;

import java.util.Scanner;

public class MenuHomeControl {
    Scanner scn = new Scanner(System.in);
    PlaylistControl playlist = new PlaylistControl();
    public void telaInicial (){
        System.out.println("\n=== Menu Inicial ===");
        System.out.println("1 - Entrar");
        System.out.println("2 - Cadastrar");
        System.out.println("3 - Sair");
        System.out.println("4 - CRIAR PLAYLIST\n"); //deixa aqui por enqnt, pra facilitar o test

        int resp;

        resp = scn.nextInt();

        if(resp == 4 ){
            playlist.CreatePlaylist();
        }
    }

    public String menu() {
        System.out.println();
        return "Miguel";
    }

}