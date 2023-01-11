package com.example.manage_payments.service;

import com.example.manage_payments.model.Payment;
import com.example.manage_payments.repository.PaymentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class CreatePaymentServiceTest {

    @Mock
    PaymentRepository repository;

    @InjectMocks
    CreatePaymentService service;

    @Test
    void createPayment_shouldCallSaveMethod() {
        String name = "test";
        double sum = 100;
        String paymentID = service.createPayment(name, sum);
        Optional<Payment> paymentI = repository.findById(paymentID);
        Assertions.assertNotNull(paymentI);
    }
}