public enum CategoriaPlato {
    LUNESAVIERNES("Ensaladilla Rusa","Carre de cordero","Flan de huevo", "Coca")
    , SABADO("Calamares", "Solomillo iberico","Contesa","Agua"),
    DOMINGO("Gambas al ajillo","Meloso bogavante","Torrija","Whiskey");

    final String entradas;
    final String principales;
    final String postres;
    final String bebidas;
    CategoriaPlato(String entrada, String principal, String postre, String bebida){

        entradas=entrada;
        principales=principal;
        postres=postre;
        bebidas=bebida;
    }
    public String getEntradas(){return entradas;}
    public String getPrincipales(){return principales;}
    public String getPostres(){return postres;}
    public String getBebidas(){return bebidas;}

}