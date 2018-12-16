package com.brat.sso.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class JwtUser {
	private String userName;
	private Collection<GrantedAuthority> role;

	public JwtUser(String userName, Collection<GrantedAuthority> role) {
		this.userName = userName;
		this.role = role;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Collection<GrantedAuthority> getRole() {
		return role;
	}

	public void setRole(Collection<GrantedAuthority> role) {
		this.role = role;
	}
}
