package com.bruno.service;

import com.bruno.model.Pagamento;

import java.util.List;

public class RisultatiRicerca<T> {

    private final Integer selectedPage;
    private final Integer pageSize;
    private final Long total;
    private final List<T> results;
    private  String nextPageLink;
    private  String previousPageLink;


    public RisultatiRicerca(Long total, List<T> results, Integer selectedPage, Integer pageSize) {
        this.total = total;
        this.selectedPage = selectedPage;
        this.pageSize = pageSize;
        this.results = results;
    }

    public Long getTotal() {
        return total;
    }

    public List<T> getResults() {
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
