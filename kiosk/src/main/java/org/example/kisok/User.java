package org.example.kisok;

import java.util.InputMismatchException;
import java.util.Scanner;

//사용자 유형 정보, 할인율
public class User {
    //필드
    private UserType userType;
    Scanner scanner = new Scanner(System.in);
    private User user;
    private int userNum;

    //생성자
    public User(UserType userType) {
        this.userType = userType;
    }

    //메서드
    public UserType getUserType() {
        return userType;
    }

    public void setUserType(int userNum) {
        this.userNum = userNum;
        System.out.println("******userNum = " + userNum);
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public UserType selectedUserType() {
        while (true) {
            try {
                int index = 0;
                System.out.println("할인 정보를 입력해주세요.");
                for (UserType userType : UserType.values()) {
                    System.out.println(++index + " " + userType + " : " + userType.getDiscountRate() + "%");
                }
                int userNum = scanner.nextInt(); // 사용자 정보 입력
                if (userNum>0 && userNum<5) {
                    UserType selectedType = UserType.values()[userNum - 1];
                    setUserType(selectedType); // 필드에 저장
                    return selectedType;
                } else {
                    System.out.println("1 ~ " + UserType.values().length + " 사이의 숫자를 입력해주세요.");
                }
            } catch (InputMismatchException e) {
                System.out.println("숫자를 입력해주세요.");
                scanner.nextLine(); // 버퍼 클리어
            }
        }
    }
}
