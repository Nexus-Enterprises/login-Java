package projeto;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import org.json.JSONObject;
import projeto.captura.disco.Discos;

import java.io.IOException;

public class BotSlack {
    // Bot responsável por pegar os dados de memoria e enviar para o slack


    public static void main() throws IOException, InterruptedException {

        JSONObject json = new JSONObject();

        json.put("text", "Fácil né? :shrug:");

        Slack.sendMessage(json);
    }
}
