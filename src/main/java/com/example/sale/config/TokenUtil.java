package com.example.sale.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenUtil {
    private static final String TOKEN_SECRET = "your_token_secret"; // Token 密钥，可以从配置文件中读取

    public static String generateToken(String username) {
        Date now = new Date();
        Date expireTime = new Date(now.getTime() + 6 * 60 * 60 * 1000); // Token 过期时间为 24 小时
        Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
        String token = JWT.create()
                .withClaim("username", username)
                .withExpiresAt(expireTime)
                .sign(algorithm);
        return token;
    }

    public static boolean verifyToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            verifier.verify(token);
            return true;
        } catch (JWTVerificationException e) {
            return false;
        }
    }
}
