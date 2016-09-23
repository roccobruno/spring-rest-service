package com.bruno.model.bo;

public class Paging {
	
	private final String resourceName;
	private final Integer selectedPage;
    private final Integer pageSize;
    private final Long total;    
	private String previousPageLink;
	private String nextPageLink;
	private String filterPaginator;
	
	public Paging(String resourceName,Integer selectedPage,Integer pageSize, Long total,String filterPaginator){
		this.resourceName = resourceName;
		this.total = total;
        this.selectedPage = selectedPage;
        this.pageSize = pageSize;
        this.filterPaginator = filterPaginator;
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
	        StringBuilder builder = new StringBuilder("http://localhost:7001/spring-rest-service/api/v1.0/").append(resourceName).append("?pageNumber=").append(i).append(filterPaginator != null ? filterPaginator : "");
	        return builder.toString();
	    }

	    private int getTotNumberOfPages() {
	        return (int) Math.ceil (total/10.0);
	    }
}
