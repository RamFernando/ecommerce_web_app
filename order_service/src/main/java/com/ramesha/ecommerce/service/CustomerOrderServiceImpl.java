package com.ramesha.ecommerce.service;

import com.ramesha.ecommerce.model.CustomerOrder;
import com.ramesha.ecommerce.repository.CustomerOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService{

    @Autowired
    CustomerOrderRepository orderRepository;

    @Override
    public CustomerOrder addOrder(CustomerOrder customerOrder) {
        return orderRepository.save(customerOrder);
    }

    @Override
    public List<CustomerOrder> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<CustomerOrder> getOrderById(Integer id) {
        return orderRepository.findById(id);
    }
}
