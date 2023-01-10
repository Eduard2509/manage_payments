package com.example.manage_payments.service;

import com.example.manage_payments.model.Payment;
import com.example.manage_payments.model.PaymentStatus;
import com.example.manage_payments.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class GetStatusPaymentService {

    Random random = new Random();

    PaymentRepository paymentRepository;

    @Autowired
    public GetStatusPaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public String getRandomPaymentStatus() {
        List<PaymentStatus> statuses = Arrays.asList(PaymentStatus.values());
        int randomNumberStatus = random.nextInt(1, PaymentStatus.values().length);
        return statuses.get(randomNumberStatus).name();
    }

    public String getStatus(String idPayment) {
        Payment findPayment = paymentRepository.findById(idPayment).get();
        String randomPaymentStatus = getRandomPaymentStatus();
        findPayment.setStatus(randomPaymentStatus);
        paymentRepository.save(findPayment);
        return randomPaymentStatus;
    }
}
