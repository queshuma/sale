package com.example.sale.config;

import lombok.Data;

@Data
public class Token {
    private String token;
    private long expireTime;
}
