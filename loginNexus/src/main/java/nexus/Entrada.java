package nexus;

import java.util.Scanner;

public class Entrada {
    void login() {
        boolean logado = false;
        Scanner leitor = new Scanner(System.in);
        Prints prints = new Prints();
        prints.boasVindas();
        do {
            prints.username();
            String username = leitor.nextLine();
            prints.password();
            String password = leitor.nextLine();
            if (username.equals("admin") && password.equals("1234")) {
                logado = true;
                prints.autenticado();
            } else if (username.equals("admin") && (!password.equals("1234"))) {
                prints.erroPass();
            } else if (!username.equals("admin") && password.equals("1234")){
                prints.erroUser();
            } else {
                prints.error();
            }
            System.out.println("\033[H\033[2J");
            System.out.flush();
        } while (!logado);
    }
}
