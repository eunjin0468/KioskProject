package org.example.kisok;

//햄버거 메뉴 관리
public class MenuItem {
    //속성(필드)
    private String name;
    private double price;
    private String details;


    //생성자 (조립설명서)
    public MenuItem(String name, double price, String details) {
        this.name = name;
        this.price = price;
        this.details = details;
    }

    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public String getDetails() {
        return details;
    }

    //기능
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setDetails(String details) {
        this.details = details;
    }
}
