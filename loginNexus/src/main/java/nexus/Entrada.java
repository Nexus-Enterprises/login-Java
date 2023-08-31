package nexus;

import java.util.Scanner;

public class Entrada {
    void login(){

        boolean logado = false;

        Scanner leitor = new Scanner(System.in);

        Prints prints = new Prints();

        prints.username();
        String username = leitor.nextLine();

        prints.password();
        String password = leitor.nextLine();

        do {
            if (username.equals("admin") && password.equals("1234")) {
                logado = true;
                prints.autenticado();
            } else if (username == "admin" && password != "1234") {
                prints.erroPass();
            } else if (username != "admin" && password =="1234"){
                prints.erroUser();
            }
        } while (!logado);
    }
}
