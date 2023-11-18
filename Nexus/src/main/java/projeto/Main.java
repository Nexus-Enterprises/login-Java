package projeto;

import projeto.captura.Monitoramento;
import projeto.menu.Menu;
import projeto.print.Prints;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Prints prints = new Prints();
        prints.inicial();
        Menu menu = new Menu();
        menu.exibirMenu();

        Monitoramento monitoramento = new Monitoramento();
        monitoramento.monitor();
        monitoramento.verificarLimiteEEnviarNotificacao();

        BotSlack botSlack = new BotSlack();
        botSlack.mensagemHardware("processador");


    }
}