package com.bean;

public class ItemBean {
    private int code;
    private String name;
    private int price;
    private int quality;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }



    public ItemBean(int code, String name, int price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public ItemBean(int code, String name, int price, int quality) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.quality = quality;
    }


}
