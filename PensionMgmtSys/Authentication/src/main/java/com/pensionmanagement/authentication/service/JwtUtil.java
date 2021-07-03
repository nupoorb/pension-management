package com.pensionmanagement.authentication.service;

import java.util.Date;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class JwtUtil {

    private String secretKey = "secret";
    
    /**
	 * This method extracts UserName from token.
	 * @param token
	 * @return String
	 */
    public String extractUsername(String token) {
    	final Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
    	log.info("getting claims");
        return claims.getSubject();   
    }
    
    /**
	 * This method generates token
	 * @param userDetails
	 * @return  String
	 */
    public String generateToken(UserDetails userDetails) {
    	
    	 return Jwts.builder().setSubject(userDetails.getUsername()).setIssuedAt(new Date(System.currentTimeMillis()))
                 .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30))// token for 30 mins
                 .signWith(SignatureAlgorithm.HS256, secretKey).compact();
    }
    
    /**
	 * This method validates the token .
	 * @param  token
	 * @return  Boolean 
	 */
   public Boolean validateToken(String token)
   {
	 try {
		   Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
		   return true;
	   }
	   catch(Exception e) {
		   return false;
		   
	   }
   }
}