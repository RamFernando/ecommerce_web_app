package com.ramesha.ecommerce.controller;

import com.ramesha.ecommerce.model.CustomerOrder;
import com.ramesha.ecommerce.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/services")
@CrossOrigin( "*")
public class CustomerOrderController {

    @Autowired
    CustomerOrderService customerOrderService;

    @RequestMapping("/testOrder")
    public String test(){
        return "Hello Order";
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/order/add", method = RequestMethod.POST)
    public CustomerOrder addOrder(@RequestBody CustomerOrder order){
        return customerOrderService.addOrder(order);
    }

    @RequestMapping("/order/getAll")
    public List<CustomerOrder> getAllOrders(){
        return customerOrderService.getAllOrders();
    }

    @RequestMapping("order/{id}")
    public Optional<CustomerOrder> getOrderById(@PathVariable Integer id){
        return customerOrderService.getOrderById(id);
    }
}