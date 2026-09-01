package model;

public class Partido {
    private Equipo equipolocal,equipoVisitante;
    private int gLocal, gVisitante;
    private boolean jugado;
    public Partido(){}

    public Partido(Equipo equipolocal, Equipo equipoVisitante) {
        this.equipolocal = equipolocal;
        this.equipoVisitante = equipoVisitante;
    }

    public Partido(Equipo equipolocal, Equipo equipoVisitante, int gLocal, int gVisitante) {
        this.equipolocal = equipolocal;
        this.equipoVisitante = equipoVisitante;
        this.gLocal = gLocal;
        this.gVisitante = gVisitante;
        equipolocal.setgFavor(equipolocal.getgFavor()+gLocal);
        equipolocal.setgContra(equipolocal.getgContra()+gVisitante);
        equipoVisitante.setgFavor(equipoVisitante.getgFavor()+gVisitante);
        equipoVisitante.setgContra(equipoVisitante.getgContra()+gLocal);
        jugado=true;
    }
    public void jugarPartido(){

        if (!jugado){
            gLocal= (int) (Math.random()*4);
            gVisitante= (int) (Math.random()*4);
            jugado=true;

        }else{
            System.out.println("Partido ya disputado");
        }
    }
    public void mostrarDatos(){
        System.out.printf("%s.%d VS %d:%s%n",equipolocal.getNombre(),gLocal,gVisitante,equipoVisitante.getNombre());
    }

    public Equipo getEquipolocal() {
        return equipolocal;
    }

    public void setEquipolocal(Equipo equipolocal) {
        this.equipolocal = equipolocal;
    }

    public Equipo getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(Equipo equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public int getgLocal() {
        return gLocal;
    }

    public void setgLocal(int gLocal) {
        this.gLocal = gLocal;
    }

    public int getgVisitante() {
        return gVisitante;
    }

    public void setgVisitante(int gVisitante) {
        this.gVisitante = gVisitante;
    }

    public boolean isJugado() {
        return jugado;
    }

    public void setJugado(boolean jugado) {
        this.jugado = jugado;
    }
}
