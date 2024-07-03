package com.phat.e.project.Service;

import com.phat.e.project.Entity.Cart;
import com.phat.e.project.Repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService implements ICartService{
    CartRepository cartRepository;

    @Autowired
    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public Cart AddCart(Cart cart) {
        Cart oldcart = cartRepository.findById(cart.getId()).orElse(null);
        if(oldcart != null){
            oldcart.setQuantity(oldcart.getQuantity() + cart.getQuantity());
            return cartRepository.save(oldcart);
        }
        return cartRepository.save(cart);
    }

    @Override
    public List<Cart> GetCartsByUserID(String userId) {
        return cartRepository.findByUserId(userId);
    }

    @Override
    public List<Cart> GetCartsByProductID(String productId) {
        return cartRepository.findByProductId(productId);
    }

    @Override
    public boolean DeleteCart(String userId, String productId) {
        Cart cart = cartRepository.findByCustomer_IdAndProduct_Id(userId, productId);
        if (cart != null) {
            cartRepository.delete(cart);
            return true;
        }
        return false;
    }

    @Override
    public Cart GetCartDetailId(String userId, String productId) {
        return cartRepository.findByCustomer_IdAndProduct_Id(userId, productId);
    }


}
