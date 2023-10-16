package nexus;

import java.util.Scanner;

public class Menu {
    public boolean sair = false;

    void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        Login login = new Login();
        Cadastrar cadastrar = new Cadastrar();

        while (!sair) {
            Prints.menu();
            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    login.login();
                    break;
                case 2:
                    cadastrar.cadastro();
                    break;
                case 0:
                    Prints.sair();
                    sair = true;
                    break;
                default:
                    break;
            }
        }
    }
}
// Realizado Pela Nexus Enterprises :)