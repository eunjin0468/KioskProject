package org.example.kisok;

//이름, 수량, 가격 등을 가진 한 개의 장바구니 항목
public class CartItem {
    //필드
    private String name;
    private String details;
    private double price;

    //생성자
    public CartItem(String name, double price, String details){
        this.name = name;
        this.price = price;
        this.details = details;
    }

    //기능
    public String getName() {
        return name;
    }
    public String getDetails() {
        return details;
    }
    public double getPrice() {
        return price;
    }
}
