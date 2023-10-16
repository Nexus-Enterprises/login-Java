import Discos.Discos;
import Memoria.Memoria;
import Processador.Processador;
import Sistemas.Sistemas;

import java.util.Timer;
import java.util.TimerTask;

public class Main {
    int fkMaquina;
    public static void main(String[] args){
        Timer timer = new Timer();
        TimerTask main = new Execution();

        timer.schedule(main, 50, 15000);
    }

    public static class Execution extends TimerTask {
        public void run(){
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
}
