package com.transportation.AutoTransportation.controller;

import com.transportation.AutoTransportation.models.AcceptOrder;
import com.transportation.AutoTransportation.models.Car;
import com.transportation.AutoTransportation.models.Order;
import com.transportation.AutoTransportation.models.User;
import com.transportation.AutoTransportation.repository.AcceptOrderRepository;
import com.transportation.AutoTransportation.repository.CarRepository;
import com.transportation.AutoTransportation.repository.OrderRepository;
import com.transportation.AutoTransportation.service.AcceptOrderService;
import com.transportation.AutoTransportation.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class RequestController {
    @Autowired
    OrderService orderService;
    @Autowired
    AcceptOrderService acceptOrderService;
    @Autowired
    AcceptOrderRepository acceptOrderRepository;
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/request")
    public String request(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("allOrder", orderService.findAllOrder());
        return "request";
    }

    @PostMapping("/request")
    public String AddRequest(@AuthenticationPrincipal User user,
                             @RequestParam(required = true, defaultValue = "" ) Long orderId,
                             @RequestParam(required = true, defaultValue = "" ) String action,
                             Model model) {

        if (action.equals("accept")) {
            Order order = orderService.findOrderById(orderId);
            Car car = carRepository.findByDriverId(user.getId());
            AcceptOrder acceptOrder = new AcceptOrder();
            acceptOrder.setModel(car.getCarModel());
            acceptOrder.setCarNumber(car.getCarNumber());
            acceptOrder.setDriver(user.getLast_name());
            acceptOrder.setOrderId(orderId);
            acceptOrder.setPrice(order.getPayment());
            acceptOrder.setUserId(order.getUserId());
            acceptOrderRepository.save(acceptOrder);
        }

        return "redirect:/request";
    }
}
