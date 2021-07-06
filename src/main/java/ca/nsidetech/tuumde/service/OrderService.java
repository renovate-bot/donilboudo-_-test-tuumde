package ca.nsidetech.tuumde.service;

import ca.nsidetech.tuumde.model.Order;
import ca.nsidetech.tuumde.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void createOrder(Order order) {
        orderRepository.save(order);
    }

    public Iterable<Order> getOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public void updateOrder(Order order) {
        orderRepository.save(order);
    }
}
