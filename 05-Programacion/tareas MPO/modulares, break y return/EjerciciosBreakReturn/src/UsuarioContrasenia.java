public enum UsuarioContrasenia {
    ADMIN("admin","123456"),
    SANTISOR("santisor","terminamos"),
    LORENA("lorena","casi casi");

    final String usuarios;
    final String contrasenias;

    UsuarioContrasenia(String usuario, String contrasenia){
        usuarios = usuario;
        contrasenias = contrasenia;
    }

    public String getContrasenias(){return contrasenias;}
    public String getUsuarios(){return usuarios;}
}
