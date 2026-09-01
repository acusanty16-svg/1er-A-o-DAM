public class Operaciones {

    public void evaluarServidor(String estado) {
        switch (obtenerCodigo(estado)) {
            case 200 -> {
                System.out.println("Pagina ok");
            }
            case 400 -> {
                System.out.println("Servidor ok Pagina no ok");

            }
            case 500 -> {
                System.out.println("Pagina no ok");

            }
        }

    }

    private int obtenerCodigo(String estado) {
        if (estado.equals("ok")) {
            return 200;
        } else if (estado.equals("ok_fail")) {
            return 400;

        }else {
            return 500;
        }

    }

}
