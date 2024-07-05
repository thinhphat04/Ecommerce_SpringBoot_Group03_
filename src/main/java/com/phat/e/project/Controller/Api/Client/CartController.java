package com.phat.e.project.Controller.Api.Client;
import com.phat.e.project.Entity.Cart;
import com.phat.e.project.Service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/api/carts")
public class CartController {

     ICartService cartService;

    @Autowired
    public CartController(ICartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping
    public ResponseEntity<Cart> addCart(@RequestBody Cart cart) {
        Cart newCart = cartService.AddCart(cart);
        return ResponseEntity.ok(newCart);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Cart>> getCartsByUserId(@PathVariable String userId) {
        List<Cart> carts = cartService.GetCartsByUserID(userId);
        return ResponseEntity.ok(carts);
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<Cart>> getCartsByProductId(@PathVariable String productId) {
        List<Cart> carts = cartService.GetCartsByProductID(productId);
        return ResponseEntity.ok(carts);
    }

    @DeleteMapping("/{userId}/{productId}")
    public ResponseEntity<Void> deleteCart(@PathVariable String userId, @PathVariable String productId) {
        boolean isDeleted = cartService.DeleteCart(userId, productId);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{userId}/{productId}")
    public ResponseEntity<Cart> getCartDetail(@PathVariable String userId, @PathVariable String productId) {
        Cart cart = cartService.GetCartDetailId(userId, productId);
        if (cart != null) {
            return ResponseEntity.ok(cart);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/getAllCart")
    public List<Cart> getAllCart() {
        return cartService.getAllCart();
    }
}
