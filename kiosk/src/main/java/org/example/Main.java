package org.example;
import org.example.kisok.Kiosk;
import org.example.kisok.Menu;
import org.example.kisok.MenuItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Menu> menuList = new ArrayList<>(); //메뉴 카데고리 객체 생성

        Menu hamburgerMenu = new Menu("Burgers"); //햄버거 카테고리 객체 생성
        MenuItem menuItem1 = new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거");         // Menu 클래스 내 있는 List<MenuItem> 에 MenuItem 객체 생성
        hamburgerMenu.addMenuItem(menuItem1); //삽입
        MenuItem menuItem2 = new MenuItem("SmokeShack", 9.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        hamburgerMenu.addMenuItem(menuItem2);
        MenuItem menuItem3 = new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        hamburgerMenu.addMenuItem(menuItem3);
        MenuItem menuItem4 = new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거");
        hamburgerMenu.addMenuItem(menuItem4);

        Menu drinkMenu = new Menu("Drinks"); //음료 카테고리 객체 생성(Menu클래스의 생성자를 이용해서 새로운 객체를 만들고 이걸 drinkMenu에 넣음)
        MenuItem drinkMenu1 = new MenuItem("제로콜라", 5.5, "시원한 제로콜라");
        drinkMenu.addMenuItem(drinkMenu1); //메뉴아이템을 메뉴리스트에 삽입
        MenuItem drinkMenu2 = new MenuItem("레몬에이드", 4.9, "상큼한 레몬이 들어간 수제 레몬에이드");
        drinkMenu.addMenuItem(drinkMenu2);
        MenuItem drinkMenu3 = new MenuItem("아이스티", 4.5, "향긋한 홍차로 만든 아이스티");
        drinkMenu.addMenuItem(drinkMenu3);


        Menu dessertMenu = new Menu("Desserts");
        MenuItem dessertMenu1 = new MenuItem("바닐라 아이스크림", 6.5, "진한 바닐라 맛 아이스크림");
        dessertMenu.addMenuItem(dessertMenu1);
        MenuItem dessertMenu2 = new MenuItem("브라우니", 7.2, "쫀득한 초콜릿 브라우니");
        dessertMenu.addMenuItem(dessertMenu2);
        MenuItem dessertMenu3 = new MenuItem("딸기 치즈케이크", 6.9, "달콤한 딸기 케이크");
        dessertMenu.addMenuItem(dessertMenu3);

        menuList.add(hamburgerMenu); //메뉴리스트에 햄버거메뉴 추가
        menuList.add(drinkMenu); //메뉴 리스트에 음료 추가
        menuList.add(dessertMenu);

        Kiosk kiosk = new Kiosk(menuList);// Kiosk 객체 생성

        kiosk.start();// Kiosk 내 시작하는 함수 호출
    }
}
