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

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetStatusPaymentServiceTest {

    @Mock
    PaymentRepository paymentRepository;

    @InjectMocks
    GetStatusPaymentService service;

    @Test
    void getRandomPaymentStatus() {
        String randomPaymentStatus = service.getRandomPaymentStatus();
        Assertions.assertNotEquals("NEW", randomPaymentStatus);
    }

    @Test
    void getStatus() {
        Payment payment = new Payment();
        payment.setId("123");
        when(paymentRepository.findById(payment.getId())).thenReturn(Optional.of(payment));
        String status = service.getStatus(payment.getId());
        Assertions.assertNotEquals("NEW", status);
    }
}