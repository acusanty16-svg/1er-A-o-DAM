package model;

public class Coche {
    private String marca, modelo;
    private int anio;
    private double km,combustible;

    public Coche() {
    }

    public Coche(String marca, String modelo, int anio) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.km= 0;
        this.combustible=50;
    }
    public void conducir(double km){
        double combustibleNecesario=km/15;
        if(km > 0 && combustible >= combustibleNecesario){
            this.km+=km;
            combustible-=combustibleNecesario;
            System.out.println("Viaje realizado. Has recorrido: "+km+" km");
        }else {
            System.out.println("No hay suficiente combustible para viajar");
        }
    }
    public void repostar (double litros){
        if ((litros+combustible)<=60 && (litros+combustible)>=0){
            combustible+=litros;
            System.out.println("Has repostado: "+litros+" tu tanque tiene: "+combustible);
        }else{
            System.out.println("No puedes repostar mas de 60 litros");
        }
    }
    public int calcularAntiguedad(){
        int anioActual=2026;
        return anioActual-anio;
    }
    public boolean necesitaMantenimiento (){
        if (km<=10000 && km>=0){
            System.out.println("Tu coche aun puede andar, no necesita un mantenimiento");
            return false;
        } else if (km>10000) {
            System.out.println("Tu coche necesita una reparacion right away");
            return true;
        }else {
            System.out.println("Introduce un valor valido");
            return false;
    }
    }
    public void mostrarInformacion (){
        System.out.println("marca = " + marca);
        System.out.println("modelo = " + modelo);
        System.out.println("anio = " + anio);
        System.out.println("km = " + km);
        System.out.println("Tu combustible actual es: "+combustible);
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public double getKm() {
        return km;
    }

    public void setKm(double km) {
        this.km = km;
    }

    public double getCombustible() {
        return combustible;
    }

    public void setCombustible(double combustible) {
        this.combustible = combustible;
    }
}
