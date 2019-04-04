package com.learning.practice.base;


import java.io.Serializable;

public class Pagenation implements Serializable {
    private static final long serialVersionUID = 6583010576690242956L;
    private int rows = 10;
    private int pageIndex = 1;
    private long total;
    private int pageCount;

    public Pagenation() {
    }

    public Pagenation(int pageIndex, int pageSize) {
        this.pageIndex = pageIndex;
        this.rows = pageSize;
    }

    public int getRows() {
        return this.rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getPageIndex() {
        return this.pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public boolean next() {
        Integer val = this.pageIndex + 1;
        if (val > this.pageCount) {
            return false;
        } else {
            this.pageIndex = val;
            return true;
        }
    }

    public long getTotal() {
        return this.total;
    }

    public void setTotal(long total) {
        this.total = total;
        this.pageCount = (int)Math.ceil((double)(total / (long)this.rows));
    }

    public int getPageCount() {
        return this.pageCount;
    }

    public long getStartRowNum() {
        return (long)((this.pageIndex - 1) * this.rows);
    }

    public String toString() {
        return "pageSize：" + this.rows + " pageIndex:" + this.pageIndex + " total:" + this.total + " pageCount" + this.pageCount;
    }
}
