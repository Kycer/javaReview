package com.study.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yk
 * @version 1.0 Date: 2017/6/9
 */
public class jwtTest {

    public static void main(String[] args) {
        jwtTest jwtTest = new jwtTest();
        Claims jdhoe = jwtTest.getClaimsFromToken(jwtTest.generateToken(), "jdhoe");
        System.out.println(jdhoe);

        System.out.println(jdhoe.getExpiration());
    }

    public String  generateToken(){
        Map<String, Object> map = new HashMap();
        map.put("username", "yksoul");
        long nowMillis = System. currentTimeMillis();

        JwtBuilder builder = Jwts.builder()
                .setClaims(map)
                .setIssuedAt(new Date( nowMillis))
                .setExpiration(new Date( nowMillis + 3600000))
                .signWith(SignatureAlgorithm.HS512, "jdhoe");
        System.out.println(builder.compact());
        return builder.compact();
    }

    public Claims getClaimsFromToken(String token, String secret) {
        Claims claims = Jwts. parser()
                .setSigningKey(secret)
                .parseClaimsJws(token).getBody();
        return claims;
    }
}
