package com.brat.sso.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.brat.sso.filters.AuthenticUser;


@Component("userPrivilege")
public class UserPrivilege {

	
	public Boolean isAdmin(){
		Collection<GrantedAuthority> authorities = getLoggedInUser().getAuthorities();
		for(GrantedAuthority authority : authorities){
			if(authority.getAuthority().equals("ROLE_ADMIN")){
				return true;
			}
		}
		return false;
	}
	
	public Boolean allowedToEdit(String empId){
		if(getLoggedInUser().getEmpId().equals(empId)){
			return true;
		}
		return false;
	}
	
	public Boolean allowedToView(String empId){
		if(getLoggedInUser().getEmpId().equals(empId)){
			return true;
		}
		return false;
	}
	
	public AuthenticUser getLoggedInUser(){
		AuthenticUser authUser = (AuthenticUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return authUser;
	}
	
	/**
	 * 
	 * @param addedByEmpId
	 * @return
	 */
	public Boolean isAllowedToViewFiles(String userOfficialEmpId){
		if(getLoggedInUser().getEmpId().equals(userOfficialEmpId) || isAdmin()){
			return true;
		}
		return false;
	}
	
	
	public List<String> getAllRolesFormatted(){
		List<String> roles = new ArrayList<>();
		Collection<GrantedAuthority> authorities = getLoggedInUser().getAuthorities();
		authorities.forEach(role -> roles.add(role.getAuthority().substring(5).substring(0,1).toUpperCase() +
				role.getAuthority().substring(6).toLowerCase()));
		return roles;
	}
}
