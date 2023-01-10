package com.example.manage_payments.repository;

import com.example.manage_payments.model.Payment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, String> {

    Optional<Payment> findById(String id);
}
