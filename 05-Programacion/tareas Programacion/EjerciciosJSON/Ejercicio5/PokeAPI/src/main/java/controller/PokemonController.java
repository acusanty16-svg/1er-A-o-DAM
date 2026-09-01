package controller;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.Pokemon;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PokemonController {

    private String url = "https://pokeapi.co/api/v2/pokemon/";

    public void getPokemonByName(String name){

        try {
            String newUrl = url+name;
        HttpClient client = HttpClient.newHttpClient();
        Gson gson = new Gson();

        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(newUrl))
                .GET()
                .build();

            HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
            JSONObject jsonPokemon = new JSONObject(response.body());
            Pokemon pokemon = gson.fromJson(jsonPokemon.toString(), Pokemon.class);
            System.out.printf("%s%n %s%n %s%n %s%n",pokemon.getName()
            ,pokemon.getHeight(),pokemon.getWeight(),pokemon.getStats());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
