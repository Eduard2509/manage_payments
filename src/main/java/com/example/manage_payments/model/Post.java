package com.example.manage_payments.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Post implements Serializable {

    private String name;
    private double cost;
    private String status;
}
