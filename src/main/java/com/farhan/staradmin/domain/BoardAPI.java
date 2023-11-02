package com.farhan.staradmin.domain;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class BoardAPI {
    // 페이징
    private int pageNum;
    private int recordSize;
    private int pageSize;

    // 검색
    private String searchType;
    private String keyword;

    private Pagination pagination;


    public BoardAPI(){
        this.pageNum = 1;
        this.recordSize = 10;
        this.pageSize = 10;
    }


}
