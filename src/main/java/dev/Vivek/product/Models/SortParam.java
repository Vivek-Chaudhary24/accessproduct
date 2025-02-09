package dev.Vivek.product.Models;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class SortParam {
    private String sortParamName;
    private String sortType;

    public String getSortType() {
        return sortType;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType;
    }

    public String getSortParamName() {
        return sortParamName;
    }

    public void setSortParamName(String sortParamName) {
        this.sortParamName = sortParamName;
    }
}
