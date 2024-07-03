package com.phat.e.project.Service;

import com.phat.e.project.Entity.Cart;
import com.phat.e.project.Entity.Order;
import com.phat.e.project.Entity.OrderDetail;
import com.phat.e.project.Repository.CartRepository;
import com.phat.e.project.Repository.OrderDetailRepository;
import com.phat.e.project.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService implements IOrderService {
    OrderRepository orderRepository;
    OrderDetailRepository orderDetailRepository;
    CartRepository cartRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, OrderDetailRepository orderDetailRepository, CartRepository cartRepository) {
        this.orderRepository = orderRepository;
        this.orderDetailRepository = orderDetailRepository;
        this.cartRepository = cartRepository;
    }

    @Transactional
    @Override
    public Order AddOrder(Order order) {
        try {
            List<Cart> listCart = cartRepository.findByUserId(order.getCustomer().getId());
            List<OrderDetail> orderDetails = new ArrayList<>();

            for (Cart cart : listCart) {
                OrderDetail details = new OrderDetail();
                details.setProduct(cart.getProduct());
                details.setQuantity(cart.getQuantity());
                details.setPrice(cart.getProduct().getPrice());
                details.setOrder(order); // Set the reference to the order
                orderDetails.add(details);
            }

            orderRepository.save(order);
            orderDetailRepository.saveAll(orderDetails);

            for (Cart cart : listCart) {
                cartRepository.delete(cart);
            }

            return order;
        } catch (Exception ex) {
            throw new RuntimeException("Failed to add order", ex);
        }
    }

    @Override
    public List<Order> ShowOrderByUserId(String userId) {
        return orderRepository.findByCustomer_Id(userId);
    }

    @Override
    public Order OrderDetails(String orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    @Transactional
    @Override
    public boolean DeleteOrderByCusID(String CusID) {
        try {
            List<Order> listOrder = orderRepository.findByCustomer_Id(CusID);
            if (!listOrder.isEmpty()) {
                for (Order order : listOrder) {
                    List<OrderDetail> listOrderDetails = orderDetailRepository.findByOrder_Id(order.getId());
                    for (OrderDetail orderDetails : listOrderDetails) {
                        orderDetailRepository.delete(orderDetails);
                    }
                    orderRepository.delete(order);
                }
                return true;
            }
            return true;
        } catch (Exception ex) {
            throw new RuntimeException("Failed to delete orders by customer ID", ex);
        }
    }

    @Override
    public List<Order> ShowAllOrder() {
        return orderRepository.findAll();
    }

    @Override
    public Order UpdateOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order GetOneOrder(String orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }
}
