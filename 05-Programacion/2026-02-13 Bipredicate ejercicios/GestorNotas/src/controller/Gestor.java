package controller;

import model.Producto;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;
import java.util.function.BiPredicate;

public class Gestor {
    private List<Producto> productos;

    public Gestor(){
        productos = new ArrayList<>();
    }
    public void agregarProducto(Producto producto){
       boolean existe = productos.stream().anyMatch(item -> item.getCodigo()
                .equalsIgnoreCase(producto.getCodigo()));
        if(existe){
            System.out.println("Codiga ya usado no se puede agregar");
        }else {
            productos.add(producto);
            System.out.println("Producto agregado correctamente");
        }
        /*
        if (buscarPorCodigo(producto.getCodigo()).isPresent()){
            System.out.println("No puedo agregar codigo duplicado");
        }else {
            productos.add(producto);
        }*/
    }
    public void asignarPrecios (){
        productos.stream().filter(item->item.getPrecio()<0)
                .forEach(item->item.setPrecio((Math.random()*100)+1));
    }
    public void mostrarProductos(){
        productos.forEach(Producto::mostrarDatos);
    }
    public Double calcularPrecioMedio() throws NoSuchElementException {
        return productos.stream().mapToDouble(Producto::getPrecio)
                .average().orElse(0.0);
    }
    public long getNumeroProductosCaros ( double limite){
        return productos.stream().filter(item->item.getPrecio()>=limite).count();
    }
    public List<Producto> getListaProductosCaros ( double limite){
        return productos.stream().filter(item->item.getPrecio()>=limite).toList();
    }
    public Optional<Producto> buscarPorCodigo (String codigo){
        return productos.stream().filter(item->item.getCodigo().equalsIgnoreCase(codigo))
                .findAny();
    }
    public void ordenarProductos(){
        productos.sort(Comparator.comparingDouble(Producto::getPrecio).reversed());
    }
    public List<Producto> getProductosPorCondicion (BiPredicate<Producto,Double> condicion, double valor){
        return productos.stream().filter(item->condicion.test(item,valor)).toList();
    }
    public DoubleSummaryStatistics getEstadisticas(){
        return this.productos.stream()
                .mapToDouble(Producto::getPrecio)
                .summaryStatistics();
    }
    public void consultarProductos() {
        //String urlConsulta = "https://dummyjson.com/products";
        String urlConsulta = "https://pokeapi.co/api/v2/pokemon/ditto";
        HttpClient client = null;
        try {

        client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlConsulta)).GET().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
           // System.out.println(response.statusCode());
            String body = response.body();
    }catch (InterruptedException | IOException e){
            System.out.println("Error en el proceso de conexion con el servidor");
        }finally {
            try{
                client.close();
            }catch (Exception e){
                System.out.println("Error en el cerrado");
            }
        }
    }
    public void consultarCositas(){
        String urlConsulta = "https://rickandmortyapi.com/api/character";
        HttpClient client = null;
        try{
            client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlConsulta)).GET().build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        }catch (InterruptedException | IOException e){
            System.out.println("Error en el proceso de conexion");
        }finally {
            try{
                client.close();
            }catch (Exception e){
                System.out.println("Error en el cerrado");
            }
        }

    }
}
