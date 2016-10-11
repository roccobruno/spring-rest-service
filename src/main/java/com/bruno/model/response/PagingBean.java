package com.bruno.model.response;

public class PagingBean {
	
	private Integer selectedPage;
    private Long totalRecords;    
	private String filterPaginator;
	private String baseUrl;
	
	public PagingBean(Integer selectedPage,Long totalRecords,String filterPaginator,String baseUrl){
		this.totalRecords = totalRecords;
        this.selectedPage = selectedPage;
        this.filterPaginator = filterPaginator;
        this.baseUrl = baseUrl;
	}
	
	public String getNextPageLink() {
        int totNumberOfPages = getTotNumberOfPages();
        if(totNumberOfPages>selectedPage) {
            return buildPageLink(selectedPage + 1);
        }
        return null;
    }

    public String getPreviousPageLink() {
        if(selectedPage == 1)
            return null;

        int totNumberOfPages = getTotNumberOfPages();
        if(totNumberOfPages>1) {
            if(totNumberOfPages >= selectedPage)
                return buildPageLink(selectedPage-1);
        }
        return null;
    }

    private String buildPageLink(int selectedPage) {
        StringBuilder builder = new StringBuilder(baseUrl).append("?totalRecords=").append(totalRecords).append("&numPagina=").append(selectedPage).append(filterPaginator != null ? filterPaginator : "");
        return builder.toString();
    }

    private int getTotNumberOfPages() {
        return (int) Math.ceil (totalRecords/10.0);
    }

	public Integer getSelectedPage() {
		return selectedPage;
	}

	public void setSelectedPage(Integer selectedPage) {
		this.selectedPage = selectedPage;
	}

	public Long getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(Long totalRecords) {
		this.totalRecords = totalRecords;
	}

	public String getFilterPaginator() {
		return filterPaginator;
	}

	public void setFilterPaginator(String filterPaginator) {
		this.filterPaginator = filterPaginator;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}	

}
