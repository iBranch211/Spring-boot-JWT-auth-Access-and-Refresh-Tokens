package com.amine.citiesapi.security;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.amine.citiesapi.dao.auth.AuthUserRepository;
import com.amine.citiesapi.entities.auth.AuthUser;
import com.amine.citiesapi.entities.auth.Role;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	AuthUserRepository authUserRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AuthUser authUser = authUserRepository.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("User can't be found"));
		return new User(authUser.getUsername(), authUser.getPassword(), mapRolesToAuthorities(authUser.getRoles()));
	}
	
	private Collection<GrantedAuthority> mapRolesToAuthorities(List<Role> roles){
		return roles.stream().map(role->new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

}
