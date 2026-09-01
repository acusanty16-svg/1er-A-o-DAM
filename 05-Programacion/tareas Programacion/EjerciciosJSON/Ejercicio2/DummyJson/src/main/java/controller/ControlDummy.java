package controller;

import com.google.gson.Gson;
import model.Producto;
import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ControlDummy {
    public void getAllInformation(String path){
        String url = path;
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
            String stringProducto = response.body();
            JSONObject jsonProducto = new JSONObject(stringProducto);
            JSONArray arrayProducto = jsonProducto.getJSONArray("products");
            for (int i = 0; i < arrayProducto.length(); i++) {
                JSONObject productoJSON = arrayProducto.getJSONObject(i);
                Producto producto = gson.fromJson(productoJSON.toString(), Producto.class);
                System.out.printf("%s - %s - %s%n",producto.getId(), producto.getTitle()
                        ,producto.getPrice());
            }
        }catch (Exception e){
            System.out.println("Error en el proceso de generar el array");
        }finally {
            client.close();
        }
    }
    public void getOneInformation(int id, String path){
        String productoEscogido = path+"/"+id;
        HttpClient client = null;
        try{
            Gson gson = new Gson();
            client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest
                    .newBuilder()
                    .uri(URI.create(productoEscogido))
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String stringProducto = response.body();
            JSONObject jsonProducto = new JSONObject(stringProducto);
            Producto producto = gson.fromJson(jsonProducto.toString(), Producto.class);
            System.out.printf("%s - %s - %s%n",producto.getId(), producto.getTitle()
                    ,producto.getPrice());

        }catch (Exception e){
            System.out.println("Error en la captura del archivo");
        }finally {
            client.close();
        }
    }
}
