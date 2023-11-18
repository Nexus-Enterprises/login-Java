package projeto;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import org.json.JSONObject;
import projeto.captura.disco.Discos;

import java.io.IOException;

public class BotSlack {
    // Pegar do Monitoramento as informações dos componente e puxar como parametro para enviar ao slack

    public static void mensagemHardware(String componenete) throws IOException, InterruptedException {
        // Enviar mensagem para o slack filtrando o componente

        JSONObject json = new JSONObject();

        if(componenete.equals("CPU")){
            json.put("text", "O processador está com uso acima do limite");
        } else if(componenete.equals("RAM")){
            json.put("text", "A memória está com uso acima do limite");
        } else if(componenete.equals("DISCO")){
            json.put("text", "O disco está com uso acima do limite");
        }

        Slack.sendMessage(json);
    }
}
