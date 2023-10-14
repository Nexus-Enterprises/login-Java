package Main;

import Discos.Discos;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        Processador processador = new Processador();
        Memoria memoria = new Memoria();
        Sistemas sistema = new Sistemas();
        Discos disco = new Discos();

        System.out.println(processador.processador());
        System.out.println(memoria.memoria());
        System.out.println(sistema.sistema());
        System.out.println(disco.disco());
    }
}
