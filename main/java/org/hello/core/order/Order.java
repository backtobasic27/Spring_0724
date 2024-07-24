package org.hello.core.order;

public class Order {

    private Long memberId;
    private String ItemName;
    private int itemPrice;
    private int discountPrice;

    public Order(Long memberId, String ItemName, int itemPrice, int discountPrice) {
        this.memberId = memberId;
        this.ItemName = ItemName;
        this.itemPrice = itemPrice;
        this.discountPrice = discountPrice;

    }



    // 비즈니스 로직
    public int calculatePrice() {
        return itemPrice - discountPrice;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getItemName() {
        return ItemName;
    }
    public void setItemName(String itemName) {
        ItemName = itemName;
    }
    public int getItemPrice() {
        return itemPrice;
    }
    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }
    public int getDiscountPrice() {
        return discountPrice;
    }
    public void setDiscountPrice(int discountPrice) {
        this.discountPrice = discountPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "memberId=" + memberId +
                ", ItemName='" + ItemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", discountPrice=" + discountPrice +
                '}';
    }
}
