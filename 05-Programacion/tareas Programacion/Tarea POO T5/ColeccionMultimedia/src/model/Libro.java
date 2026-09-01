package model;

public final class Libro extends Elemento{
    private String isbn;
    private int numPaginas;

    public Libro(){}

    public Libro(String isbn, int numPaginas) {
        this.isbn = isbn;
        this.numPaginas = numPaginas;
    }

    public Libro(int id, String titulo, String autor, String isbn, int numPaginas) {
        super(id, titulo, autor);
        this.isbn = isbn;
        this.numPaginas = numPaginas;
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Esto es un libro con la siguiente informacion");
        super.mostrarDatos();
        System.out.println("isbn = " + isbn);
        System.out.println("numPaginas = " + numPaginas);
        System.out.println();
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }
}
