package com.genetrysolar.model;

public class RowCount {
    private int affectedCount = 0;

    public RowCount() {
    }

    public RowCount(int affectedCount) {
        this.affectedCount = affectedCount;
    }

    public int getAffectedCount() {
        return affectedCount;
    }

    public void setAffectedCount(int affectedCount) {
        this.affectedCount = affectedCount;
    }
}
