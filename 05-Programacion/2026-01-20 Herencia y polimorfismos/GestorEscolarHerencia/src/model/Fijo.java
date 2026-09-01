package model;

public final class Fijo extends Profesor implements Inspector,Manifestable{
    private int pagaExtra, nHoras;

    public Fijo(){}

    public Fijo ( String nombre, String apellido, int salario){
        super(nombre, apellido, salario);
        setnExperiencia(8);
    }
    public Fijo ( String nombre, String apellido, int salario, int nHoras){
        super(nombre, apellido, salario);
        setnExperiencia(8);
        this.nHoras=nHoras;
    }
    public Fijo ( String nombre, String apellido, int salario, int pagaExtra, int nHoras){
        this(nombre, apellido, salario, nHoras);
        this.pagaExtra=pagaExtra;

    }


    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("pagaExtra = " + pagaExtra);
        System.out.println("nHoras = " + nHoras);
    }

    @Override
    public void corregirExamen() {
        super.corregirExamen();
        System.out.println("Soy un profesor fijo y corrigo muy duramente");
    }

    @Override
    public void saludar() {
        super.saludar();
        System.out.println("Chicos vamos a dar la clase, como soy fijo vamos a dar la masterclass");
    }
    public void pedirCambioHoras(int nHoras){
        if (nHoras>this.nHoras){
            System.out.println("No se puede, te quedas en negativo");
        }else {
            this.nHoras-=nHoras;
        }
    }

    public int getPagaExtra() {
        return pagaExtra;
    }

    public void setPagaExtra(int pagaExtra) {
        this.pagaExtra = pagaExtra;
    }

    public int getnHoras() {
        return nHoras;
    }

    public void setnHoras(int nHoras) {
        this.nHoras = nHoras;
    }


    @Override
    public void realizarInpeccion(int nivel) {
        System.out.println("Vamos a inspeccionar");
        System.out.println("Soy fijo por lo tanto soy un poco laxo, el nivel que aplico es "+nivel/2);
    }

    @Override
    public void manifestar() {

    }
}
