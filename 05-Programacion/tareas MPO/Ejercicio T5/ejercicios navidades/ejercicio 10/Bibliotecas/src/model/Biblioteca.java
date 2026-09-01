package model;

import java.util.ArrayList;

public class Biblioteca {
    private String nombre;
    private ArrayList<Libro> listaLibros;
    private int numDias;

    public Biblioteca(String nombre, ArrayList<Libro> listaLibros) {
        this.nombre = nombre;
        this.listaLibros = (listaLibros != null) ? listaLibros : new ArrayList<>();
    }
    public boolean agregarLibro(Libro libro){
        for(Libro libro1:listaLibros){
           if (libro1.getIsbn().equals(libro.getIsbn())){
               System.out.println("Error, el libro con ISBN: "+libro1.getIsbn()+" ya esta registrado");
               return false;
           }
        }
        listaLibros.add(libro);
        System.out.println("Libro "+libro.getTitulo()+". Se ha agregado correctamente");
        return true;
    }
    public Libro buscarLibroPorIsbn(String isbn){
        for(Libro libro:listaLibros){
            if (libro.getIsbn().equals(isbn)){
                return libro;
            }
        }
        System.out.println("Libro no encontrado");
        return null;
    }
    public boolean prestarLibro(String isbn) {
       Libro libro= buscarLibroPorIsbn(isbn);
           if (libro == null) {
               System.out.println("Error, no se puede prestar un libro que no existe");
               return false;
           }
           if (libro.isPrestado()){
               System.out.println("El libro "+libro.getTitulo()+" ya esta prestado");
               return false;
           }
           libro.setPrestado(true);
           System.out.println("El libro "+libro.getTitulo()+" se puede prestar");
           return true;
    }
    public boolean devolverLibro(String isbn){
        Libro libro = buscarLibroPorIsbn(isbn);
        if (libro==null){
            System.out.println("Operación cancelada: El ISBN no existe.");
            return false;
        }
        if (!libro.isPrestado()){
            System.out.println("El libro '" + libro.getTitulo() + "' ya estaba en la biblioteca.");
            return false;
        }
        libro.setPrestado(false);
        if (numDias<=120){
            System.out.println("El libro '" + libro.getTitulo() + "' ha sido devuelto con éxito.");
        }else {
            System.out.println("El libro ha sido devuelto, pero tienes una multa de 200 pavos por exceder los 120 días.");
        }
        return true;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Libro> getListaLibros() {
        return listaLibros;
    }

    public void setListaLibros(ArrayList<Libro> listaLibros) {
        this.listaLibros = listaLibros;
    }

    public int getNumDias() {
        return numDias;
    }

    public void setNumDias(int numDias) {
        this.numDias = numDias;
    }
}
