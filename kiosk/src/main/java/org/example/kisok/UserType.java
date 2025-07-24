package org.example.kisok;

//enum으로 할인율 제공
public enum UserType {
    //열거형 상수 정의
    국가유공자(10, 0.1),
    군인(5, 0.05),
    학생(3, 0.03),
    일반(0,0);

    //필드
    private double discountRate;
    private int num;

    //생성자
    UserType(int num, double discountRate) {
        this.num = num;
        this.discountRate = discountRate;
    }

    //메서드
    public double getDiscountRate() {
        return discountRate;
    }
    public int getNum() {
        return num;
    }

}
