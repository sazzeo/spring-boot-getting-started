package com.jy.study.order;

public interface OrderService {


    //새 주문 만들기
    Order createOrder(Long memberId , String itemName , int itemPrice);



}
