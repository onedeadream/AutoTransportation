package com.transportation.AutoTransportation.controller;

import com.transportation.AutoTransportation.models.Order;
import com.transportation.AutoTransportation.models.User;
import com.transportation.AutoTransportation.repository.AcceptOrderRepository;
import com.transportation.AutoTransportation.repository.UserRepository;
import com.transportation.AutoTransportation.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class MainController {

    @Autowired
    OrderService orderService;
    @Autowired
    AcceptOrderRepository acceptOrderRepository;

    @GetMapping("/")
    public String addOrder(@AuthenticationPrincipal User user,
                           Model model) {
        model.addAttribute("allOrder", orderService.findAllOrder());
        model.addAttribute("orderNotifications", acceptOrderRepository.findByUserId(user.getId()));
        model.addAttribute("orderForm", new Order());
        return "homePage";
    }

    @PostMapping("/")
    public String addUser(@ModelAttribute("orderForm") @Valid Order orderForm,
                          @AuthenticationPrincipal User user,
                          Model model) {
        orderService.saveOrder(orderForm, user);
        return "homePage";
    }

}
