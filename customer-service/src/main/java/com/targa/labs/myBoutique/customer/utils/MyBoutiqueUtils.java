package com.targa.labs.myBoutique.customer.utils;

import com.auth0.jwt.JWT;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;

public class MyBoutiqueUtils {
    static public Long getCartIdFromToken(String token){
        String cartId = JWT.require(HMAC512(TokenProperties.secret.getBytes()))
                .build()
                .verify(token)
                .getSubject();
        System.out.println("afafsf 3 "+cartId);
        return Long.parseLong(cartId);
    }
}
