package com.bruno.model;

public class Pagamento {

    private final String id;
    private final String descrizione;
    private final String cig;


    public Pagamento(String id, String descrizione, String cig) {
        this.id = id;
        this.descrizione = descrizione;
        this.cig = cig;
    }

    public String getId() {
        return id;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public String getCig() {
        return cig;
    }


    public String toFileLine() {
        StringBuilder builder = new StringBuilder(id).append(",").append(descrizione).append(",").append(cig);
        return builder.toString();
    }

}
