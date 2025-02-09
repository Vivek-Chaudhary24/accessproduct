package dev.Vivek.product.Models;

import java.util.List;

public class SearchRequestDto {
    private String title;
    private int pageNumber;
    private int pageSize;
    private List<SortParam> sortParams;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<SortParam> getSortParams() {
        return sortParams;
    }

    public void setSortParams(List<SortParam> sortParams) {
        this.sortParams = sortParams;
    }
}
