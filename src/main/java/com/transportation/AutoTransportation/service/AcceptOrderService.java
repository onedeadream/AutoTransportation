package com.transportation.AutoTransportation.service;

import com.transportation.AutoTransportation.repository.AcceptOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AcceptOrderService {
    @Autowired
    AcceptOrderRepository acceptOrderRepository;
    public boolean deleteOrder(Long requestId) {
        if (acceptOrderRepository.findById(requestId).isPresent()) {
            acceptOrderRepository.deleteById(requestId);
            return true;
        }
        return false;
    }


}
