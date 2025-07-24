package org.example.kisok;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Kiosk {
    //필드
    private Scanner scanner = new Scanner(System.in); //스캐너 선언
    private List<Menu> menuList; //카테고리의 메뉴 항목들
    private CartItem cartItem;
    private Cart cart = new Cart(cartItem);
    private User user = new User(UserType.일반); //User는 UserType을 생성자에서 필요로 하므로, userType이 초기화되어 있어야 User user = new User(userType)도 정상 동

    //생성자
    public Kiosk(List<Menu> menuList) {
        this.menuList = menuList;
    }

    //기능
    public void start() { //입력, 반복문 로직
        boolean flag = true;
        boolean cartIsEmpty = true;
        while (flag) { //반복문 시작
            if (cart.isEmpty()) {
                System.out.println("[ MAIN MENU ]");
                int index = 1;
                for (Menu category : menuList) {
                    System.out.println(index + ". " + category.getCategoryName());
                    index++;
                }
            }
            else{
                System.out.println("\n아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.\n");
                System.out.println("[ MAIN MENU ]");
                int index = 1;
                for (Menu category : menuList) {
                    System.out.println(index + ". " + category.getCategoryName());
                    index++;
                }
                System.out.println("\n[ ORDER MENU ]");
                System.out.println(index + ". " + "Orders");
                System.out.println(++index + ". " + "Cancel");
            }
            System.out.println("0. 종료");
            System.out.print("> 원하시는 메뉴의 번호를 입력해주세요 : ");
            try {
                int choiceCategory = scanner.nextInt();
                if (choiceCategory == 0) {
                    System.out.println("프로그램을 종료합니다.");
                    flag = false;
                    break;
                }
                else if (choiceCategory == 1 || choiceCategory == 2 || choiceCategory == 3) {
                    Menu selectedCategory = menuList.get(choiceCategory - 1);
                    List<MenuItem> items = selectedCategory.getMenuList().stream().collect(Collectors.toList());

                    System.out.println("\n[" + selectedCategory.getCategoryName() + " 메뉴]");
                    for (int i = 0; i < items.size(); i++) {
                        MenuItem item = items.get(i);
                        System.out.print((i + 1) + ". " + item.getName() + "  | " + item.getPrice() + "원");
                        System.out.println("  | " + item.getDetails());
                    }
                    System.out.print("원하시는 메뉴를 선택해주세요 : ");
                    try {
                        int choiceMenu = scanner.nextInt();
                        System.out.println("\n[선택한 메뉴]\n" + items.get(choiceMenu - 1).getName() + "  | " + items.get(choiceMenu - 1).getPrice() + "  | " + items.get(choiceMenu - 1).getDetails());

                        System.out.println("> 위 메뉴를 장바구니에 추가하시겠습니까? (1.확인 2.취소 3.장바구니 확인 4.장바구니 제거 5.장바구니 비우기)");
                        System.out.print("숫자를 입력해주세요 : ");
                        int choiceNum = scanner.nextInt();
                        if (choiceNum == 1) { // 장바구니 추가
                            cartIsEmpty = false;
                            CartItem cartItem = new CartItem(items.get(choiceMenu - 1).getName(), items.get(choiceMenu - 1).getPrice(), items.get(choiceMenu - 1).getDetails());
                            cart.addItem(cartItem);
                            System.out.println(items.get(choiceMenu - 1).getName()+"이 장바구니에 추가되었습니다.");
                        } else if (choiceNum == 2) { //장바구니 취소
                            continue;
                        } else if (choiceNum == 3) { //장바구니 확인
                            cart.getCartItems();
                        }else if(choiceNum == 4){
                            System.out.print("장바구니에서 빼고 싶은 메뉴명을 입력해주세요 : ");
                            scanner.nextLine();
                            String menuName = scanner.nextLine();
                            cart.removeItem(menuName);
                        } else if(choiceNum == 5){
                            cart.clear();
                        }
                        else { //장바구니 번호 입력 오류
                            System.out.println("잘못된 번호를 선택하셨습니다.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("숫자를 입력해주세요.");
                    }
                }else if(!cartIsEmpty && choiceCategory==4){
                    System.out.println("아래와 같이 주문 하시겠습니까?\n");
                    System.out.println("[ Orders ]");
                    cart.getCartItems();
                    int order = scanner.nextInt();
                    if (order == 1) {
                        user.selectedUserType();
                        UserType discountType = user.getUserType(); //사용자 정보 출력
                        System.out.println("주문이 완료되었습니다. 금액은 W "+cart.discountRate(discountType)+"입니다.");
                        break;
                    }
                    else if (order == 2) {
                        continue;
                    }
                    else{
                        System.out.println("값을 잘못 입력하였습니다.");
                    }
                }
            }catch (InputMismatchException e) {
                System.out.println("숫자를 입력해주세요.");
                scanner.nextLine(); // 버퍼 클리어
                // }
            }
        }
    }
}
