package controller;

import com.google.gson.Gson;
import model.Persona;
import model.Titulo;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ControlPlaceHolder {

    private Titulo getTitle(int id){
        String url = "https://jsonplaceholder.typicode.com/posts/"+id;
        HttpClient client = null;
        try{
            Gson gson = new Gson();
            client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest
                    .newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String stringTitulo = response.body();
            JSONObject jsonTitulo = new JSONObject(stringTitulo);
            Titulo titulo = gson.fromJson(jsonTitulo.toString(), Titulo.class);
            return titulo;
        }catch (Exception e){
            System.out.println("Error en la generacion del titulo");
            return null;
        }

    }
    public void getAllInfo(int id){
        String urlUser = "https://jsonplaceholder.typicode.com/users/"+id;
        
        try{
            Gson gson = new Gson();
            HttpClient client = HttpClient.newHttpClient();
            Titulo titulo = getTitle(id);
            HttpRequest requestUser = HttpRequest
                    .newBuilder()
                    .uri(URI.create(urlUser))
                    .GET()
                    .build();
            HttpResponse<String> responseUser = client.send(requestUser, HttpResponse.BodyHandlers.ofString());
            JSONObject jsonPersona = new JSONObject(responseUser.body());
            Persona persona = gson.fromJson(jsonPersona.toString(), Persona.class);
            System.out.printf("%s%n %s%n %s%n",titulo.getTitle()
            ,persona.getName(), persona.getAddress());
        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
