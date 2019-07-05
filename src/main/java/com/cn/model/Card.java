package com.cn.model;

/**
 * @Author: zhangjixu
 * @CreateDate: 2018/10/22
 * @Description:
 * @Version: 1.0.0
 */
public class Card {
    private int card_id;
    private String address;

    public int getCard_id() {
        return card_id;
    }

    public void setCard_id(int card_id) {
        this.card_id = card_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Card{" +
                "card_id=" + card_id +
                ", address='" + address + '\'' +
                '}';
    }
}
