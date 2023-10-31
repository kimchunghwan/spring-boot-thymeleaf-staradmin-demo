package com.farhan.staradmin.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO {
    private int startPage;
    private int endPage;
    private boolean prev, next;
    private int total;
    private RowNum rn;

    public PageDTO(RowNum _rn, int _total) {
        this.rn = _rn;
        this.total = _total;
        this.endPage = (int) (Math.ceil(_rn.getPageNum() / 10.0 )) * 10;
        this.startPage = this.endPage - 9;
        int realEnd = (int) (Math.ceil((_total * 1.0) / _rn.getAmount()));
        if(realEnd < this.endPage){
            this.endPage = realEnd;
        }
        this.prev = this.startPage > 1;
        this.next = this.endPage < realEnd;
    }
}
