package com.dataengine;

public class StockInfo {

    private String id;

    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        return this.id.equals(((StockInfo) obj).id);
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }
}
