package projeto;

import org.json.JSONObject;
import java.net.http.HttpClient;

public class Slack {
        private static final HttpClient client = HttpClient.newHttpClient();
        private static final String URL = "INSIRA SUA URL AQUI (https://hooks.slack.com/services/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)";

    public static void sendMessage(JSONObject json) {

    }
}
