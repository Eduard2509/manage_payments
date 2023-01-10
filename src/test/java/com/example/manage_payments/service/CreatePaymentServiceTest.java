package com.example.manage_payments.service;

import com.example.manage_payments.model.Payment;
import com.example.manage_payments.repository.PaymentRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

class CreatePaymentServiceTest {

    @Mock
    PaymentRepository repository;

    @InjectMocks
    CreatePaymentService service;

    @Autowired
    public CreatePaymentServiceTest(CreatePaymentService service) {
        this.service = service;
    }

    @Test
    void createPayment_shouldCallSaveMethod() {
        String name = "test";
        double sum = 100;
        String paymentID = service.createPayment(name, sum);
        Payment payment = repository.findById(paymentID).get();
        verify(repository).save(payment);
    }
}