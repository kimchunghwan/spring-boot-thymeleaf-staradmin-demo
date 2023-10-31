package com.farhan.staradmin.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RowNum {
    private int pageNum;
    private int amount;

    public RowNum(){
        this(1, 10);
    }

    public RowNum(int pageNum, int amount) {
        this.pageNum = pageNum;
        this.amount = amount;
    }
}
