package com.depetris.lucas.mercadolibrechallenge.Modelo;

import java.io.Serializable;
import java.util.List;

public class BusquedaResponse implements Serializable {
    private String query;
    private List<Product> results;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public List<Product> getResults() {
        return results;
    }

    public void setResults(List<Product> results) {
        this.results = results;
    }
}
