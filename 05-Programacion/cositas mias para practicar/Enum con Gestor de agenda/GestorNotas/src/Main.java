import controller.Gestor;
import model.Categoria;
import model.Producto;

public class Main {
    public static void main(String[] args) {
        Gestor gestor = new Gestor();
        Producto tv = new Producto("TV LG","123-K",600,Categoria.TECNOGOLOGICO);
        Producto movil = new Producto("MOVIL LG","124-K",Categoria.TECNOGOLOGICO);
        //Producto movil = new Producto("TV LG","123-K",600,Categoria.TECNOGOLOGICO);
        gestor.agregarProductos(tv);
        gestor.agregarProductos(movil);
        gestor.asignarPrecios();
        movil.mostrarDatos();
        //gestor.agregarProductos(movil);
    }
}