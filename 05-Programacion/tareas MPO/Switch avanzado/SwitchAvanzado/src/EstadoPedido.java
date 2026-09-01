public enum EstadoPedido {
    PENDIENTE("Estamos evaluando tu pedido y sera procesado en breve"),
    PROCESANDO("Estamos procesando tu pedido y será enviado en breve"),
    ENVIADO("Estamos enviando tu pedido en estos momentos"),
    EN_TRANSITO("Tu pedido está en tránsito en estos momentos"),
    ENTREGADO("Tu pedido ha sido entregado"),
    CANCELADO("Tu pedido ha sido cancelado");

    private final String anuncios;
    EstadoPedido(String anuncio){
        anuncios=anuncio;
    }
    public String getAnuncios(){return anuncios;}

}
