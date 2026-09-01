package controller;

import com.google.gson.Gson;
import model.Equipo;
import model.Jugador;
import model.Liga;
import org.json.JSONArray;
import org.json.JSONObject;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APIController {
    private FileController fileController;
    public APIController(){
        fileController = new FileController();
    }
    public void getAllLeagues(){
        String url ="https://www.thesportsdb.com/api/v1/json/123/all_leagues.php";

        HttpClient client=null;
        try{
            Gson gson = new Gson();
            client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest
                    .newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();
            HttpResponse<String>response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String stringLigas = response.body();
            JSONObject jsonLigas = new JSONObject(stringLigas);
            JSONArray arrayLigas = jsonLigas.getJSONArray("leagues");
            for (int i = 0; i < arrayLigas.length(); i++) {
                JSONObject ligaJSON = arrayLigas.getJSONObject(i);
                Liga liga = gson.fromJson(ligaJSON.toString(), Liga.class);
                //String idLiga = ligaJSON.getString("idLeague");
                //String nombreLiga = ligaJSON.getString("strLeague");
                System.out.printf("%s - %s%n",liga.getIdLeague(),liga.getStrLeague());
            }

        }catch (Exception e){
            System.out.println("Error en la peticion HTTP");
        }finally {
            try{
                client.close();
            }catch (NullPointerException e){
                System.out.println("Error en el cerrado");
            }
        }
    }
    public void getAllClasificacion(int id){
        String url = "https://www.thesportsdb.com/api/v1/json/123/lookuptable.php?l="+id;
        HttpClient client;
        try {
            Gson gson = new Gson();
        client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String body = response.body();
            JSONObject clasificacionJSON = new JSONObject(body);
            JSONArray clasificacionArray = clasificacionJSON.getJSONArray("table");
            for (int i = 0; i < clasificacionArray.length(); i++) {
                JSONObject equipoJSON = clasificacionArray.getJSONObject(i);
                Equipo equipo = gson.fromJson(equipoJSON.toString(), Equipo.class);
                System.out.println(equipo);
                fileController.exportarEquipo(equipo);
            }

        } catch (IOException e) {
            System.out.println("Error en el procesamiento del response");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    public void getAllPlayers(int id){
        String url="https://www.thesportsdb.com/api/v1/json/123/lookup_all_players.php?id="+id;
        HttpClient client;
        try {
            Gson gson = new Gson();
            client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String body = response.body();
            JSONObject equipoDetail = new JSONObject(body);
            JSONArray jugadoresArray = equipoDetail.getJSONArray("player");
            for (int i = 0; i < jugadoresArray.length(); i++) {
                JSONObject jugadorJSON = jugadoresArray.getJSONObject(i);
                Jugador jugador = gson.fromJson(jugadorJSON.toString(), Jugador.class);
                System.out.printf("%s - %s%n",jugador.getStrPlayer(), jugador.getStrPosition());
            }

        } catch (IOException e) {
            System.out.println("Error en el procesamiento del response");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
