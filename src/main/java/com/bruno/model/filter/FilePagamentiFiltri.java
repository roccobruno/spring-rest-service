package com.bruno.model.filter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FilePagamentiFiltri {

    public FilePagamentiFiltri() {
    }

    //TODO aggiungere tutti i campi usati come filtri

    private  String cig;

    public String getCig() {
        return cig;
    }

    public void setCig(String cig) {
        this.cig = cig;
    }

    public String toJson() {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {

            return "";
        }
    }
}