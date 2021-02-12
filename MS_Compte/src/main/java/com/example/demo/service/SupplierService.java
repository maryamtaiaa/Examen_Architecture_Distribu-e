package com.example.demo.service;

import com.example.demo.entities.Compte;
import com.example.demo.entities.Operation;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.function.Supplier;

@Service
public class SupplierService {
    private Long num=0L;
    @Bean
    public Supplier<Operation> opertionSupplier(){
        return ()-> new Operation(
                num,
                new Date(),
                Math.random()*1000,
                Math.random()>0.5?"DEBIT":"CREDIT",
                new Compte());
    }
}
