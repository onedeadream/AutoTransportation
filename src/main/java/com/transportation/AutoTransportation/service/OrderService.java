package com.transportation.AutoTransportation.service;

import com.transportation.AutoTransportation.models.Order;
import com.transportation.AutoTransportation.models.Role;
import com.transportation.AutoTransportation.models.User;
import com.transportation.AutoTransportation.repository.OrderRepository;
import com.transportation.AutoTransportation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public Order findOrderById(Long orderId) {
        Optional<Order> userFromDb = orderRepository.findById(orderId);
        return userFromDb.orElse(new Order());
    }
    public boolean saveOrder(Order order, User user) {
        order.setUserId(user.getId());
        if(order.getTariff().equals("Economy")){
            order.setPayment(order.getKilometers()*30);
        }

        if(order.getTariff().equals("Comfort")){
            order.setPayment(order.getKilometers()*50);
        }

        if(order.getTariff().equals("Business")){
            order.setPayment(order.getKilometers()*100);
        }
        orderRepository.save(order);
        return true;
    }

    public List<Order> findAllOrder() {
        return orderRepository.findAll();
    }
}
