package com.haetae.eighthapplication;

public class Book {
    private int id;
    private String author;
    private String name;
    private double price;
    private int pages;
    private Category category;

    public Book(int id,String author, String name, double price, int pages,String category_name,int category_code) {
        this.id = id;
        this.author = author;
        this.name = name;
        this.price = price;
        this.pages = pages;
        this.category = new Category(category_name,category_code);
    }

    @Override
    public String toString() {
        return "本书相关信息：\n" +
                "书名："+name+"\n"+
                "作者："+author+"\n"+
                "价格："+price+"元\n"+
                "分类名："+getCategoryName()+"\n"+
                "分类码："+getCategoryCode()+"\n"+
                "页数："+pages+"\n"
                ;
    }

    private int getCategoryCode() {
        return category.getCategory_code();
    }

    private String getCategoryName() {
        return category.getCategory_name();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
class Category {
    private int id;
    private String category_name;
    private int category_code;

    public Category(String category_name, int category_code) {
        this.category_name = category_name;
        this.category_code = category_code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public int getCategory_code() {
        return category_code;
    }

    public void setCategory_code(int category_code) {
        this.category_code = category_code;
    }
}
