package com.amine.citiesapi.security;

import java.util.Date;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.security.Key;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtTokenUtils {
	
	private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS512);

	
	public String generateToken(Authentication authentication) {
		String username = authentication.getName();
		Date currentDate = new Date();
		Date expiryDate = new Date(currentDate.getTime() + SecurityConstants.JWT_EXPIRATION);
		
		String token = Jwts.builder()
				.setSubject(username)
				.setIssuedAt(currentDate)
				.setExpiration(expiryDate)
				.signWith(key, SignatureAlgorithm.HS512)
				.compact();
		
		return token;
	}
	
	public String generateToken(String username) {
		Date currentDate = new Date();
		Date expiryDate = new Date(currentDate.getTime() + SecurityConstants.JWT_EXPIRATION);
		
		String token = Jwts.builder()
				.setSubject(username)
				.setIssuedAt(currentDate)
				.setExpiration(expiryDate)
				.signWith(key, SignatureAlgorithm.HS512)
				.compact();
		
		return token;
	}
	
	public String getUsernameFromJwt(String token) {
		Claims claims = Jwts.parser()
				.setSigningKey(key)
				.parseClaimsJws(token)
				.getBody();
		return claims.getSubject();
	}
	
	public boolean validateToken(String token) {
		try {
			Jwts.parser().setSigningKey(key).parseClaimsJws(token);
			return true;			
		}catch(Exception e) {
			throw new AuthenticationCredentialsNotFoundException("Token was expired or incorrect");
		}
	}

}
