package nexus;

public class Prints {
    static void inicial(){
        System.out.println("Seja Bem-Vindo a Plataforma NEXUS!\n");
    }
    static void menu() {
        System.out.println("\nPor Favor realize o Login para poder acessar \ntodas as areas da plataforma! \n");
        System.out.println("Caso não possua um Login, realize o Cadastro\n");
        System.out.println("----------------------------------------------");
        System.out.println("| 1 - Login                                  |");
        System.out.println("| 2 - Cadastro                               |");
        System.out.println("| 0 - Sair                                   |");
        System.out.println("----------------------------------------------");
    }
    static void username() {
        System.out.println("\nInsira seu email: ");
    }
    static void password() {
        System.out.println("\nInsira sua token: ");
    }
    static void token() {
        System.out.println("\nInsira seu token:");
    }
    static void erroUser() {
        System.out.println("\nO usuario está incorreto");
    }
    static void autenticado() {
        System.out.println("\nLogin Realizado com Sucesso!");
    }
    static void erroToken() {
        System.out.println("\nNão foi possivel autenticar o token!");
    }
    static void sair() {
        System.out.println("\nSessão Finalizada!");
    }

    static void user() {
        System.out.println("\nInsira seu email: ");
    }
    static void pass() {
        System.out.println("\nInsira seu token: ");
    }
    static void afterLogin(){
        System.out.println("----------------------------------------------");

    }
}
// Realizado Pela Nexus Enterprises :)