package projeto.captura;

import com.github.britooo.looca.api.core.Looca;
import projeto.BotSlack;
import projeto.captura.disco.Discos;
import projeto.captura.memoria.Memoria;
import projeto.captura.processador.Processador;
import projeto.print.Prints;

import java.io.IOException;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Monitoramento {
    private Boolean sair = false;
    Discos disk = new Discos();
    Memoria memory = new Memoria();
    Processador processor = new Processador();

    // Cria a instacia da API Looca para puxar os dados do computador
    Looca looca = new Looca();

    // Vou usar para enviar a mensagem para o slack
    BotSlack botSlack = new BotSlack();

    public void monitor() {

        Prints prints = new Prints();


        Timer timer = new Timer();
        TimerTask main = new Execution();
        timer.schedule(main, 0, 15000);

        Scanner scanner = new Scanner(System.in);


        while (!sair) {
            prints.menuMonitorar();
            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println(processor.processador());
                    break;
                case 2:
                    System.out.println(memory.memoria());
                    break;
                case 3:
                    System.out.println(disk.disco());
                    break;
                case 0:
                    prints.sair();
                    sair = true;
                    timer.cancel();
                    break;
                default:
                    break;
            }
        }
    }

    public static class Execution extends TimerTask {
        public void run() {
            Discos disk = new Discos();
            disk.disco();

            Memoria memory = new Memoria();
            memory.memoria();

            Processador processor = new Processador();
            processor.processador();
        }
    }


    public void verificarLimiteEEnviarNotificacao() throws IOException, InterruptedException {
        // Verificar todos os componentes criando um lógica para enviar uma notificação, criar um método para cada um, e passar os parâmetros para chamar na Classe BotSlack

        // Verificar CPU e enviar notificação
        if (looca.getProcessador().getUso() >= 20.0) {
            botSlack.mensagemHardware("CPU");
        }

        // Verificar RAM e enviar notificação
        if (looca.getMemoria().getEmUso() >= 20.0) {
            botSlack.mensagemHardware("RAM");
        }

        // Verificar Disco e enviar notificação
        if (looca.getGrupoDeDiscos().getTamanhoTotal() >= 20.0) {
            botSlack.mensagemHardware("DISCO");
        }

    }
}