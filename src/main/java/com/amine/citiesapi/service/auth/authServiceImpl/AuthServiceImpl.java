package com.amine.citiesapi.service.auth.authServiceImpl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.amine.citiesapi.dao.auth.AuthUserRepository;
import com.amine.citiesapi.dao.auth.RoleRepository;
import com.amine.citiesapi.dto.LoginRequestDto;
import com.amine.citiesapi.dto.LoginResponseDto;
import com.amine.citiesapi.dto.RefreshTokenRequestDto;
import com.amine.citiesapi.dto.RefreshTokenResponseDto;
import com.amine.citiesapi.dto.RegisterRequestDto;
import com.amine.citiesapi.dto.RegisterResponseDto;
import com.amine.citiesapi.entities.auth.AuthUser;
import com.amine.citiesapi.entities.auth.Role;
import com.amine.citiesapi.security.JwtRefreshTokenUtils;
import com.amine.citiesapi.security.JwtTokenUtils;
import com.amine.citiesapi.service.auth.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private AuthUserRepository authUserRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private JwtTokenUtils jwtTokenGenerator;
	@Autowired
	private JwtRefreshTokenUtils jwtRefreshTokenGenerator;

	public Map<String, Object> register(RegisterRequestDto request) {
		HashMap<String, Object> responseMap = new HashMap<>();
		if (authUserRepository.existsByUsername(request.getUsername())) {

			responseMap.put("registerResponseDto", new RegisterResponseDto("This user already exists"));
			responseMap.put("status", HttpStatus.BAD_REQUEST);

			return responseMap;
		}

		AuthUser authUser = new AuthUser();
		authUser.setFirstname(request.getFirstname());
		authUser.setLastname(request.getLastname());
		authUser.setUsername(request.getUsername());
		authUser.setPassword(passwordEncoder.encode(request.getPassword()));

		Role role = roleRepository.findByName("USER").get();

		authUser.setRoles(Collections.singletonList(role));

		authUserRepository.save(authUser);

		responseMap.put("registerResponseDto", new RegisterResponseDto("User added successfully"));
		responseMap.put("status", HttpStatus.CREATED);

		return responseMap;
	}

	public Map<String, Object> login(LoginRequestDto request) {

		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);

		String accessToken = jwtTokenGenerator.generateToken(authentication);
		String refreshToken = jwtRefreshTokenGenerator.generateToken(authentication);

		HashMap<String, Object> responseMap = new HashMap<>();

		responseMap.put("loginResponseDto", new LoginResponseDto("Authenticated successfully", accessToken, refreshToken));
		responseMap.put("status", HttpStatus.OK);

		return responseMap;

	}

	public Map<String, Object> refreshToken(RefreshTokenRequestDto refreshTokenObject) {

		if (!jwtRefreshTokenGenerator.validateToken(refreshTokenObject.getRefreshToken())) {
			throw new AuthenticationCredentialsNotFoundException("Token was expired or incorrect");
		}

		String username = jwtRefreshTokenGenerator.getUsernameFromJwt(refreshTokenObject.getRefreshToken());
		String accessToken = jwtTokenGenerator.generateToken(username);

		Map<String, Object> responseMap = new HashMap<>();

		responseMap.put("refreshTokenResponseDto",
				new RefreshTokenResponseDto("Authenticated successfully", accessToken));
		responseMap.put("status", HttpStatus.OK);

		return responseMap;
	}

}
