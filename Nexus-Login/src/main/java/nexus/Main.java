package nexus;

import com.github.britooo.looca.api.core.Looca;

public class Main {
    public static void main(String[] args) {
        Looca looca = new Looca();
        System.out.println(looca.getDispositivosUsbGrupo());
        Menu menu = new Menu();
        Prints print = new Prints();
        print.inicial();
        menu.exibirMenu();
    }
}
// Realizado Pela Nexus Enterprises :)