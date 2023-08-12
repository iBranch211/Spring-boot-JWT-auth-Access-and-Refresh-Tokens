package com.amine.citiesapi.service.auth;

import java.util.Map;

import com.amine.citiesapi.dto.LoginRequestDto;
import com.amine.citiesapi.dto.RefreshTokenRequestDto;
import com.amine.citiesapi.dto.RegisterRequestDto;

public interface AuthService {
	
	public Map<String, Object> register(RegisterRequestDto request);
	public Map<String, Object> login(LoginRequestDto request);
	public Map<String, Object> refreshToken(RefreshTokenRequestDto refreshTokenObject);

}
