package nexus;

public class Prints {
    void boasVindas() {
        System.out.println("Seja Bem-Vindo ao Login da Plataforma NEXUS!\n");
        System.out.println("Por Favor realize o Login para poder acessar \ntodas as areas da plataforma! \n");
    }
    void username(){
        System.out.println("Insira seu Username: ");
    }
    void password(){
        System.out.println("\nInsira sua senha: ");
    }
    void erroPass(){
        System.out.println("\nA senha está incorreta");
    }
    void erroUser(){
        System.out.println("\nO usuario está incorreto");
    }
    void autenticado(){
        System.out.println("\nLogin Realizado com Sucesso!");
    }
    void error(){
        System.out.println("\nNão foi possivel autenticar o usuario nem a senha!");
    }
}
