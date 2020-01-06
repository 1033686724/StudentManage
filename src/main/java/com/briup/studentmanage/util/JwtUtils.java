package com.briup.studentmanage.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.SignatureException;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * JSON Web Token
 *
 * @author LiuChuanWei
 * @date 2019-12-11
 */
public class JwtUtils {

    /**
     * key
     */
    private final static String SECRET_KEY = "0123456789_0123456789_0123456789";
    /**
     */
    private final static long TOKEN_EXPIRE_MILLIS = 1000 * 60 * 60;

    /**
     * token
     * @param claimMap
     * @return
     */
    public static String createToken(Map<String, Object> claimMap) {
        long currentTimeMillis = System.currentTimeMillis();
        return Jwts.builder()
                .setId(UUID.randomUUID().toString())
                .setIssuedAt(new Date(currentTimeMillis))
                .setExpiration(new Date(currentTimeMillis + TOKEN_EXPIRE_MILLIS))
                .addClaims(claimMap)
                .signWith(generateKey())
                .compact();
    }

    /**
     * ֤token
     * @param token
     * @return 0
     */
    public static int verifyToken(String token) {
        try {
            Jwts.parser().setSigningKey(generateKey()).parseClaimsJws(token);
            return 0;
        } catch (ExpiredJwtException e) {
            e.printStackTrace();
            return 1;
        } catch (UnsupportedJwtException e) {
            e.printStackTrace();
            return 2;
        } catch (MalformedJwtException e) {
            e.printStackTrace();
            return 3;
        } catch (SignatureException e) {
            e.printStackTrace();
            return 4;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return 5;
        }
    }

    /**
     * token
     * @param token
     * @return
     */
    public static Map<String, Object> parseToken(String token) {
        return Jwts.parser()
                .setSigningKey(generateKey())
                .parseClaimsJws(token)
                .getBody();
    }

    /**
     * @return
     */
    public static Key generateKey() {
       return new SecretKeySpec(SECRET_KEY.getBytes(), SignatureAlgorithm.HS256.getJcaName());
    }
}