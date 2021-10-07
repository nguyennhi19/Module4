package com.shoppet.model;


public class Product {
    private int id;
    private String name;
    private float price;
    private int quantity;
    private String image;
    private int cateGory;
    private String cateGoryName;

    public Product() {
    }

    public Product(int id, String name, float price, int quantity,String image, String cateGoryName) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
        this.quantity = quantity;

        this.cateGoryName = cateGoryName;
    }

    public Product(int id, String name, float price, int quantity,String image, int cateGory, String cateGoryName) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
        this.cateGory = cateGory;
        this.cateGoryName = cateGoryName;
    }

    public Product(int id, String name, float price, int quantity,String image, int cateGory) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
        this.cateGory = cateGory;
    }

    public Product(String name, float price, int quantity,String image, int cateGory) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
        this.cateGory = cateGory;
    }

    public Product(String name, float price, int quantity, String image, String category) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String productName) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getCateGory() {
        return cateGory;
    }

    public void setCateGory(int cateGory) {
        this.cateGory = cateGory;
    }

    public String getCateGoryName() {
        return cateGoryName;
    }

    public void setCateGoryName(String cateGoryName) {
        this.cateGoryName = cateGoryName;
    }
}
