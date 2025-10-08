package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Iterator;

public class Task4 implements TaskRunner{

    private void print(JsonNode headersNode){
        for (Iterator<String> it = headersNode.fieldNames(); it.hasNext(); ) {
            System.out.print(it.next());
            if(it.hasNext())
                System.out.print(", ");
        }
    }
    public void run()  {

        try (HttpClient client = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://httpbin.org/headers"))
                    .build();

            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(response.body());
            JsonNode headersNode = rootNode.path("headers");
            print(headersNode);

        }catch (IOException | InterruptedException e){
            System.out.println(e.getMessage());
        }
    }
}