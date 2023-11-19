package projeto;

import org.json.JSONObject;
import projeto.captura.disco.Discos;
import projeto.captura.memoria.Memoria;
import projeto.captura.processador.Processador;

import java.io.IOException;

public class BotSlack {
    // Pegar do Monitoramento as informações dos componente e puxar como parametro para enviar ao slack

    public void mensagemDisco(String mensagem) {

        JSONObject json = new JSONObject();
        json.put("text", mensagem);
        try {
            Slack.sendMessage(json);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void mensagemProcessador(String mensagem) {

        JSONObject json = new JSONObject();
        json.put("text", mensagem);
        try {
            Slack.sendMessage(json);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void mensagemMemoria(String mensagem) {

        JSONObject json = new JSONObject();
        json.put("text", mensagem);
        try {
            Slack.sendMessage(json);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
