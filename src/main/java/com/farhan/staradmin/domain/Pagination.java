package com.farhan.staradmin.domain;

import lombok.Getter;

@Getter
public class Pagination {

    private int totalRecordCount;
    private int totalPageCount;
    private int startPage;
    private int endPage;
    private int limitStart;
    private boolean existPrevPage;
    private boolean existNextPage;

    // 페이징
    public Pagination(int totalRecordCount, BoardAPI api) {
        if (totalRecordCount > 0) {
            this.totalRecordCount = totalRecordCount;
            calculation(api);
        }
    }

    // 페이징 계산기
    private void calculation(BoardAPI api){

        totalPageCount = ((totalRecordCount - 1) / api.getRecordSize()) + 1;

        if (api.getPageNum() > totalPageCount){
            api.setPageNum(totalPageCount);
        }

        startPage = ((api.getPageNum() - 1) / api.getPageSize()) * api.getPageSize() + 1;

        endPage = startPage + api.getPageSize() - 1;

        if (endPage > totalPageCount) {
            endPage = totalPageCount;
        }

        limitStart = (api.getPageNum() - 1) * api.getRecordSize();

        existPrevPage = startPage != 1;

        existNextPage = (endPage * api.getRecordSize()) < totalRecordCount;


    }
}
