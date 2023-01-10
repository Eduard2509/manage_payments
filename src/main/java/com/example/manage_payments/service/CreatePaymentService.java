package com.example.manage_payments.service;

import com.example.manage_payments.model.Payment;
import com.example.manage_payments.model.PaymentStatus;
import com.example.manage_payments.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreatePaymentService {

    PaymentRepository paymentRepository;

    @Autowired
    public CreatePaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public String createPayment(String name, double sum) {
        Payment payment = new Payment();
        payment.setName(name);
        payment.setSum(sum);
        payment.setStatus(PaymentStatus.NEW.name());
        paymentRepository.save(payment);
        return payment.getId();
    }
}
