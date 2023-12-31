package com.project.simpleB.common;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Data
public class Paging {
    private int pageIndex;
    private int startRow;
    private int endRow;
    private int startPage;
    private int endPage;
    private int pageSize;
    private int totalCount;
    private List<?> list;

    public Paging(int pageIndex, int pageSize) {
        this.pageIndex = Math.max(pageIndex, 1);
        this.pageSize = Math.max(pageSize, 1);
        this.startRow = ((this.pageIndex - 1) * this.pageSize) + 1;
        this.endRow = this.pageIndex * this.pageSize;
    }

    public void pagingList(List<?> list, int totalCount) {
        this.list = list;
        this.totalCount = totalCount;
        this.startPage = ((pageIndex - 1) / this.pageSize) * this.pageSize + 1;
        this.endPage = (startPage + this.pageSize) - 1;
    }
}
