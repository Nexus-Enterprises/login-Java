package projeto;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.JSONObject;

public class Slack{
    private static final HttpClient client = HttpClient.newHttpClient();
    private static final String URL = "https://hooks.slack.com/services/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";
    public static void sendMessage(JSONObject json) throws IOException, InterruptedException {
<<<<<<< HEAD
          HttpRequest request = HttpRequest.newBuilder()
                 .uri(URI.create(URL))
                 .header("Content-Type", "application/json")
                 .POST(HttpRequest.BodyPublishers.ofString(json.toString()))
                 .build();
          HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
=======
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL))
                .POST(HttpRequest.BodyPublishers.ofString(json.toString()))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
        System.out.println(response.body());
>>>>>>> fd86e5582b5621a6106ea19d83ad4b2c72f5881a
    }
}