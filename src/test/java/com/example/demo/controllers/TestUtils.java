package com.example.demo.controllers;

import com.example.demo.model.persistence.Cart;
import com.example.demo.model.persistence.Item;
import com.example.demo.model.persistence.User;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.List;

public class TestUtils {

    public static void injectObjects(Object target, String fieldName, Object toInject){

        boolean wasPrivate = false;

        try {
            Field f = target.getClass().getDeclaredField(fieldName);
            if (!f.canAccess(target)){
                f.setAccessible(true);
                wasPrivate = true;
            }
            f.set(target, toInject);
            if (wasPrivate){
                f.setAccessible(false);
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


    static User buildUser(String encodedPass) {
        return User.builder()
          .username("testUser")
          .password(encodedPass)
          .build();
    }

    static Cart buildCart(User user, List<Item> items) {
        return Cart.builder()
          .user(user)
          .items(items)
          .total(BigDecimal.valueOf(1.99))
          .build();
    }


    static Item buildItem() {
        return Item.builder()
          .id(1L)
          .name("itemName")
          .price(BigDecimal.valueOf(1.99))
          .description("desc")
          .build();

    }


}
