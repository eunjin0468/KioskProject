package org.example.kisok;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    //필드
    private String categoryName; // 카테고리 이름 추가
    private List<MenuItem> menuList;


    //생성자
    public Menu(String categoryName) {
        this.categoryName = categoryName;
        this.menuList = new ArrayList<>();
    }

    //기능
    public void addMenuItem(MenuItem menuItem) {
        menuList.add(menuItem);
    }

    public List<MenuItem> getMenuList() {
        return menuList;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

}
