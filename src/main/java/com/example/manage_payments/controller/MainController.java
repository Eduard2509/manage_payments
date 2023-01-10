package com.example.manage_payments.controller;

import com.example.manage_payments.model.Post;
import com.example.manage_payments.service.CreatePaymentService;
import com.example.manage_payments.service.GetStatusPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {

    CreatePaymentService createPaymentService;
    GetStatusPaymentService getStatusPaymentService;

    @Autowired
    public MainController(CreatePaymentService createPaymentService, GetStatusPaymentService getStatusPaymentService) {
        this.createPaymentService = createPaymentService;
        this.getStatusPaymentService = getStatusPaymentService;
    }

    @PostMapping("/")
    public Post getStatusPayment(@RequestBody Post post){
        String payment = createPaymentService.createPayment(post.getName(), post.getCost());
        String status = getStatusPaymentService.getStatus(payment);
        post.setStatus(status);
        return post;
    }


}
