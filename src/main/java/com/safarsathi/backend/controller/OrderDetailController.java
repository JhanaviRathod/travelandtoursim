package com.safarsathi.backend.controller;

import com.safarsathi.backend.entity.OrderDetail;
import com.safarsathi.backend.entity.OrderInput;
import com.safarsathi.backend.service.OrderDetailService;
import com.safarsathi.backend.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderDetailController {
    @Autowired
    private OrderDetailService orderDetailService;

    @PreAuthorize("hasRole('User')")
    @PostMapping({"/placeOrder"})
    public void placeOrder(@RequestBody OrderInput orderInput){
       orderDetailService.placeOrder(orderInput);
    }

    @GetMapping({"/getAllOrderDetails"})
    public List<OrderDetail> getAllOrderDetails(){return orderDetailService.getAllOrderDetails();}
}
