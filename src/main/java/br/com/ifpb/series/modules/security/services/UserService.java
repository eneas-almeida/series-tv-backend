package br.com.ifpb.series.modules.security.services;

import org.springframework.security.core.context.SecurityContextHolder;

import br.com.ifpb.series.modules.security.JwtUser;

public class UserService {
	
	public static JwtUser authenticated() {
		try {
			return (JwtUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		catch (Exception e) {
			return null;
		}
	}
}