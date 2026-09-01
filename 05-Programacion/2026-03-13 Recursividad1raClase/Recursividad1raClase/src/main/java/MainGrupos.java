import controller.GruposController;
import model.Grupo;
import model.Usuario;

public class MainGrupos {
    public static void main(String[] args) {
        Usuario usuario1 = new Usuario(1,"U1");
        Usuario usuario2 = new Usuario(2,"U2");
        Usuario usuario3 = new Usuario(3,"U3");
        Usuario usuario4 = new Usuario(4,"U4");
        Usuario usuario5 = new Usuario(5,"U5");
        Usuario usuario6 = new Usuario(6,"U6");
        Usuario usuario7 = new Usuario(7,"U7");
        Usuario usuario8 = new Usuario(8,"U8");
        Usuario usuario9 = new Usuario(9,"U9");
        Grupo fp = new Grupo();
        fp.addUsuario(usuario1);
        fp.addUsuario(usuario2);

        Grupo dam = new Grupo();
        dam.addUsuario(usuario3);

        Grupo dam1 = new Grupo();
        dam1.addUsuario(usuario4);
        dam1.addUsuario(usuario5);

        Grupo dam2 = new Grupo();
        dam2.addUsuario(usuario6);
        dam2.addUsuario(usuario7);

        dam.addSubGrupo(dam1);
        dam.addSubGrupo(dam2);

        Grupo daw = new Grupo();
        Grupo daw1 = new Grupo();
        daw1.addUsuario(usuario8);

        Grupo daw2 = new Grupo();
        daw2.addUsuario(usuario9);

        daw.addSubGrupo(daw1);
        daw.addSubGrupo(daw2);

        fp.addSubGrupo(daw);
        fp.addSubGrupo(dam);

        GruposController gruposController = new GruposController();

        if (gruposController.pertenece(fp, usuario8)){
            System.out.println("Pertenece");
        }else{
            System.out.println("No pertenece");
        }
    }
}
