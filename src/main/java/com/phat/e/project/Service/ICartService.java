package com.phat.e.project.Service;

import com.phat.e.project.Entity.Cart;

import java.util.List;

public interface ICartService {
   Cart AddCart(Cart cart);
    List<Cart> GetCartsByUserID(String userId);
    List<Cart> GetCartsByProductID(String userId);
    boolean DeleteCart(String userId, String productId);
    Cart GetCartDetailId(String userId, String productId);
//    boolean DeleteCartByBouquetId(String bouquetId);
}
