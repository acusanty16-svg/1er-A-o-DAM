public class Controler {
    String [] correos = new String[5];
    public boolean metodoAnadir(String correo){
        for (int i = 0; i < correos.length; i++) {
            if(correos[i]==null){
                correos[i] = correo;
                return true;
            }
        }
        return false;
    }
    public void metodoListar(){

        for(String item:correos){
            System.out.println(item);
        }
        System.out.println("Listar metodo");

    }
    public void metodoBuscar(){
        System.out.println("Buscar listar elementos");
    }
}
