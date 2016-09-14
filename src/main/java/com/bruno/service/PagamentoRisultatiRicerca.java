package com.bruno.service;

import com.bruno.model.Pagamento;

import java.util.List;

public class PagamentoRisultatiRicerca {

    private final Integer selectedPage;
    private final Integer pageSize;
    private final Integer total;
    private final List<Pagamento> results;
    private  String nextPageLink;
    private  String previousPageLink;


    public PagamentoRisultatiRicerca(Integer total, List<Pagamento> results, Integer selectedPage, Integer pageSize) {
        this.total = total;
        this.selectedPage = selectedPage;
        this.pageSize = pageSize;
        this.results = results;
    }

    public Integer getTotal() {
        return total;
    }

    public List<Pagamento> getResults() {
        return results;
    }

    public String getNextPageLink() {
        int totNumberOfPages = getTotNumberOfPages();
        if(totNumberOfPages>selectedPage) {
            return buildPageLink(selectedPage + 1);
        }
        return "";
    }

    public String getPreviousPageLink() {
        if(selectedPage == 1)
            return "";

        int totNumberOfPages = getTotNumberOfPages();
        if(totNumberOfPages>1) {

            if(totNumberOfPages >= selectedPage)
                return buildPageLink(selectedPage-1);

        }
        return "";
    }


    private String buildPageLink(int i) {
        //TODO aggiungi gli altri filtri
        StringBuilder builder = new StringBuilder("/spring-rest-service/pagamenti/search").append("?pageNumber=").append(i).append("&pageSize=").append(pageSize);
        return builder.toString();
    }

    private int getTotNumberOfPages() {
        return (int) Math.ceil (total/100.0);
    }
}
