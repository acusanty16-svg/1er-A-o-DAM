package controller;


import com.google.gson.Gson;
import lombok.Data;
import model.Usuario;
import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Data
public class ControllerJSON {
    private String URL = "https://randomuser.me/api/";
    public void importarUsuarios() {
        Gson gson = new Gson();
        HttpClient client = null;
        client = HttpClient.newHttpClient();
        HttpRequest request= HttpRequest
                .newBuilder()
                .uri(URI.create(URL))
                .GET()
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String lineasUser = response.body();
            JSONObject objetoUser = new JSONObject(lineasUser);
            JSONArray arrayUser = objetoUser.getJSONArray("results");
            for (int i = 0; i < arrayUser.length(); i++) {
                JSONObject userJSON = arrayUser.getJSONObject(i);
                Usuario usuario = gson.fromJson(userJSON.toString(), Usuario.class);
                System.out.println("Nombre: " + usuario.getName().getTitle() + " " +
                        usuario.getName().getFirst() + " " + usuario.getName().getLast());
                System.out.println("Ubicación: " + usuario.getLocation().getCountry());
                System.out.println("Email: " + usuario.getEmail());
            }
        } catch (Exception e) {
            System.out.println("Error en la peticion HTTP");
        }

    }
}
