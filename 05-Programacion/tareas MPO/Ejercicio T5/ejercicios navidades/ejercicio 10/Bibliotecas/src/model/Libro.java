package model;

public class Libro {
    private String titulo, autor, isbn;
    private int numeroPaginas, fechaDevueltaLbro;
    private double precio;
    private boolean descuentoRealizado, prestado;

    public Libro(){}

    public Libro(String titulo, String autor, int numeroPaginas, double precio) {
        this.titulo = titulo;
        this.autor = autor;
        this.numeroPaginas = numeroPaginas;
        this.precio = precio;
    }

    public void mostrarInfo(){
        System.out.println("El nombre del titulo es: "+titulo);
        System.out.println("El nombre del autor es: "+autor);
        System.out.println("El numero de sus paginas es "+numeroPaginas);
        if (esLibroLargo()){
            System.out.println(titulo+" es un libro largo, bro");
        }
        System.out.println("El precio del titulo es: "+precio);
        if (!descuentoRealizado){
            aplicarDescuento();
        }else{
            System.out.println("El descuento ya fue aplicado anteriormente");
        }

    }
    private boolean esLibroLargo(){
        return numeroPaginas >= 300;
    }
    private void aplicarDescuento(){
        if (esLibroLargo()){
            System.out.println("Genial, acabas de ganar un descuento, porque tu libro es largo");
            double porcentaje= precio*0.10;
            precio= precio-porcentaje;
            System.out.println("Aplicando descuento del 10%");
            System.out.println("Nuevo precio: "+precio);
            descuentoRealizado=true;
        }
    }

    public Libro(String titulo, String autor, String isbn, int numeroPaginas, double precio, boolean descuentoRealizado, boolean prestado) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.numeroPaginas = numeroPaginas;
        this.precio = precio;
        this.descuentoRealizado = descuentoRealizado;
        this.prestado = prestado;
    }
    public boolean prestar(){
        if (prestado){
            System.out.println("El libro está prestado, no te lo podemos dejar");

            return false;
        }else {
            System.out.println("El libro esta disponible para ser prestado");
            return true;
        }
    }
    public boolean devolver(){
        if (prestado && fechaDevueltaLbro<=120){
            prestado=false;
            System.out.println("Devolucion exitosa");
            return true;
        }else if (prestado){
            int diasRetraso = fechaDevueltaLbro-120;
            System.out.println("Se ha expirado tu licencia. llevas "+diasRetraso+" dias de retraso");
            prestado=false;
            System.out.println("Debes pagar una multa de 200 pavos");
            return true;
        }
        return false;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isDescuentoRealizado() {
        return descuentoRealizado;
    }

    public void setDescuentoRealizado(boolean descuentoRealizado) {
        this.descuentoRealizado = descuentoRealizado;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    public int getFechaDevueltaLbro() {
        return fechaDevueltaLbro;
    }

    public void setFechaDevueltaLbro(int fechaDevueltaLbro) {
        this.fechaDevueltaLbro = fechaDevueltaLbro;
    }
}
