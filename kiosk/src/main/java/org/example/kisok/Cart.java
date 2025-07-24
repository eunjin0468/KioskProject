package org.example.kisok;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//List<CartItem>을 가지고 장바구니 전체를 관리 (추가, 출력, 초기화 등)
public class Cart {
    //필드
    private List<CartItem> cartItems = new ArrayList<>(); //장바구니에 담긴 개별 항목 저장하는 리스트
    private double totalPrice = 0; //총 수량
    private int quantity;
    private User user;

    //생성자
    public Cart(CartItem cartItem) {
        this.cartItems = new ArrayList<>();}

    //기능
    public void addItem(CartItem item){ //장바구니에 메뉴 추가
        cartItems.add(item);
        System.out.println("\n[장바구니에 추가된 항목]\n" + item.getName()+ "  | "+item.getPrice()+ "  | "+item.getDetails());
        totalPrice += item.getPrice();
        System.out.println("totalPrice = " + totalPrice);
        quantity++;
    }

    public void getCartItems() {
        int index = 1;
        for (CartItem cartItem : cartItems) {
            System.out.println(index+". " + cartItem.getName()+ "  | "+cartItem.getPrice()+ "  | "+cartItem.getDetails());
            index++;
        }
        System.out.println("\n[ Total ]");
        System.out.println("W "+totalPrice);
        System.out.println("1.주문 2. 메뉴판");
    }
    public void removeItem(String menuName) {
        int index = -1;
        for (int i = 0; i < cartItems.size(); i++) { //인덱스 찾기
            if (cartItems.get(i).getName().equals(menuName)) {
                index = i;
                totalPrice -= cartItems.get(i).getPrice();
                break;
            }
        }
        if (index != -1) {
            cartItems = cartItems.stream().filter(cartItem -> !menuName.equals(cartItem.getName())).collect(Collectors.toList());
            System.out.println("선택하신 메뉴 "+menuName+"를 제거하였습니다.\n");
            index--;
        }
        else{
            System.out.println("\n선택하신 메뉴 "+menuName+"이(가) 장바구니에 없습니다.\n");
        }
    }
    public void clear(){
        cartItems.clear();
        totalPrice = 0;
    }
    public boolean isEmpty() {
        return cartItems == null || cartItems.isEmpty();
    }

    public double discountRate(UserType discountType) {
        return totalPrice-(totalPrice*discountType.getDiscountRate());
    }
}
