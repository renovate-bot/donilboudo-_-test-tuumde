package ca.nsidetech.tuumde.rest;

import ca.nsidetech.tuumde.model.Order;
import ca.nsidetech.tuumde.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class OrderRestApi {
    private OrderService orderService;

    @Autowired
    public OrderRestApi(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(value = "/orders")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void createOrder(@RequestBody Order order) {
        orderService.createOrder(order);
    }

    @GetMapping(value = "/orders")
    public Iterable<Order> getOrders() {
        return orderService.getOrders();
    }

    @GetMapping(value = "/orders/{id}")
    public Order findOrder(@PathVariable Long id) {
        return orderService.getOrderById(id).orElse(null);
    }

    @PutMapping(value = "/orders")
    public void updateOrder(@RequestBody Order order) {
        orderService.updateOrder(order);
    }
}
