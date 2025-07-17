package org.example.kisok;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    Scanner scanner = new Scanner(System.in);
//    MenuItem menuItem = new MenuItem();
    //속성 (MenuItem을 관리하는 리스트
    private List<MenuItem> menuItems = new ArrayList<>();

    //생성자
    public Kiosk(List <MenuItem> menuItems) {
        this.menuItems = menuItems;
    }


    //기능
    public void start(){ //입력, 반복문 로직

        boolean flag = true;
        while (flag){
            System.out.print("> 원하시는 메뉴의 번호를 입력해주세요 : ");
            int choiceMenu = scanner.nextInt();
            System.out.println("================================================================");
            switch (choiceMenu) {
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    flag = false;
                    break;
                case 1:
                    System.out.println("> 선택한 메뉴 정보\n"+"• 햄버거명 : "+menuItems.get(choiceMenu - 1).getName()+"\n• 가격 : "+menuItems.get(choiceMenu - 1).getPrice()+"\n• 햄버거 정보 : "+menuItems.get(choiceMenu - 1).getDetails());
                    break;
                case 2:
                    System.out.println("> 선택한 메뉴 정보\n"+"• 햄버거명 : "+menuItems.get(choiceMenu - 1).getName()+"\n• 가격 : "+menuItems.get(choiceMenu - 1).getPrice()+"\n• 햄버거 정보 : "+menuItems.get(choiceMenu - 1).getDetails());
                    break;
                case 3:
                    System.out.println("> 선택한 메뉴 정보\n"+"• 햄버거명 : "+menuItems.get(choiceMenu - 1).getName()+"\n• 가격 : "+menuItems.get(choiceMenu - 1).getPrice()+"\n• 햄버거 정보 : "+menuItems.get(choiceMenu - 1).getDetails());
                    break;
                case 4:
                    System.out.println("> 선택한 메뉴 정보\n"+"• 햄버거명 : "+menuItems.get(choiceMenu - 1).getName()+"\n• 가격 : "+menuItems.get(choiceMenu - 1).getPrice()+"\n• 햄버거 정보 : "+menuItems.get(choiceMenu - 1).getDetails());
                    break;
                default:
                    System.out.println("잘못된 값이 입력되었습니다. 다시 시작해주세요.");
                    break;
            }
        }

    }
}
