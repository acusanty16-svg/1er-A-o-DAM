package org.example.tiendaapp.controller;

import com.google.gson.Gson;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.lang.reflect.InaccessibleObjectException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.example.tiendaapp.HelloApplication;
import org.example.tiendaapp.data.DataSet;
import org.example.tiendaapp.model.Producto;
import org.json.JSONArray;
import org.json.JSONObject;

public class ClientController implements Initializable {
    @FXML
    private TableColumn<Producto, Number> colId;

    @FXML
    private TableColumn<Producto, String> colNombre;

    @FXML
    private TableColumn<Producto, Number> colPrecio;

    @FXML
    private TableColumn<Producto, Number> colStock;

    @FXML
    private TableView<Producto> tablaProductos;
    private ObservableList<Producto> listaProductos;

    private FilteredList<Producto> listaFiltrada;

    @FXML
    private Button btnComprar, btnCarrito, btnCarritoVentana, btnInfo;

    @FXML
    private TextField editFiltro;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       // https://dummyjson.com/products/
        instances();
        initGUI();
        actions();

    }

    private void actions() {
        editFiltro.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                listaFiltrada.setPredicate(producto -> producto.getTitle().contains(s));
            }
        });
        btnCarrito.setOnAction(event->{
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Carrito");
            alert.setContentText("Vas a comprar un total de "+DataSet.getCarrito().size() +" productos \ncon un total en euros de: "
                    +String.format("%.2f", DataSet.getCosteCarrito()) +
                    "\nQuieres terminar la compra?");
            alert.getButtonTypes().setAll(ButtonType.OK, ButtonType.NO);
            Optional<ButtonType> respuesta= alert.showAndWait();
            if (respuesta.get() == ButtonType.OK){
                Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                alert1.setTitle("Compra Exitosa");
                alert1.setContentText("Compra realizada con exito");
                DataSet.clearCarrito();
                alert1.show();
            }
        });
        btnComprar.setOnAction(actionEvent -> {
            Producto producto=tablaProductos.getSelectionModel().getSelectedItem();
            if (producto!=null){
                DataSet.addProduct(producto);
                producto.setStock(producto.getStock()-1);
                tablaProductos.refresh();
                if (producto.getStock()==0){
                    listaProductos.remove(producto);
                }
                tablaProductos.getSelectionModel().select(null);
               // tablaProductos.getSelectionModel().select(-1);
            }else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("No hay nada sleccionado");
                alert.show();
            }
        });
        btnCarritoVentana.setOnAction(actionEvent -> {


        });
        btnInfo.setOnAction(actionEvent -> {
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("detail-view.fxml"));
            try{
                Producto producto = tablaProductos.getSelectionModel().getSelectedItem();
                Parent root = loader.load();
                DetailController controller = loader.getController();
                controller.setProducto(producto);
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
            }catch (IOException e){
                System.out.println("Error en la carga");
            }
        });

    }

    private void initGUI() {
        tablaProductos.setItems(listaFiltrada);
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("title"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("price"));
        colStock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        cargaProductosJson();
    }

    private void instances() {
        listaProductos = FXCollections.observableArrayList();
        listaFiltrada = new FilteredList<>(listaProductos);
    }

    private void cargaProductosJson() {
        HttpClient client = null;
        try {


            client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.
                    newBuilder()
                    .GET()
                    .uri(URI.create("https://dummyjson.com/products"))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String body = response.body();
            JSONObject productsJSON = new JSONObject(body);
            JSONArray productsJSONArray = productsJSON.getJSONArray("products");
            Gson gson = new Gson();
            for (int i = 0; i < productsJSONArray.length(); i++) {
                JSONObject productJSONObj = productsJSONArray.getJSONObject(i);
                Producto producto = gson.fromJson(productJSONObj.toString(), Producto.class);
                listaProductos.add(producto);
                //System.out.println(producto.getTitle());
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
}
