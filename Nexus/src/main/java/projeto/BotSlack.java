package projeto;

import org.json.JSONObject;

import java.io.IOException;

public class BotSlack {
    public void mensagemHardware() throws IOException, InterruptedException {

        String mensagemSlack = """
                    
                """;

        JSONObject json = new JSONObject();

        json.put("text",mensagemSlack) ;

        Slack.sendMessage(json);
    }


    public void mensagemSoftware() throws IOException, InterruptedException {

        String mensagemSlack = "";


        JSONObject json = new JSONObject();

        json.put("text",mensagemSlack) ;

        Slack.sendMessage(json);
    }
}