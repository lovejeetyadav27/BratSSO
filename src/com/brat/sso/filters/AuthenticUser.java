package com.brat.sso.filters;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;


/** The AuthenticUser class to extend the User Class from Spring extends the
 * number of fields offered by Spring User class */
public class AuthenticUser extends User {

	
	private static final long serialVersionUID = 1L;
	private final String email;
	private final String empId;
	private final String emergancycontact;
	private final String address;
	private final String phone;
	private final String lastName;
	private final String firstName;
	private final String username;
	private final Timestamp lastLogin;
	private final Date joiningDate;
	
	
	
	public AuthenticUser(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities,String email,String empId,String emergencyContact, String address,String phone,
			String lastName, String firstName,Timestamp lastLogin, Date joiningDate) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		this.email = email;
		this.empId = empId;
		this.emergancycontact = emergencyContact;
		this.address = address;
		this.phone = phone;
		this.lastName = lastName;
		this.firstName = firstName;
		this.username = username;
		this.lastLogin = lastLogin;
		this.joiningDate = joiningDate;
	}


	public String getEmail() {
		return email;
	}


	public String getEmpId() {
		return empId;
	}


	public String getEmergancycontact() {
		return emergancycontact;
	}


	public String getAddress() {
		return address;
	}


	public String getPhone() {
		return phone;
	}


	public String getLastName() {
		return lastName;
	}


	public String getFirstName() {
		return firstName;
	}


	public String getUsername() {
		return username;
	}


	public Date getJoiningDate() {
		return joiningDate;
	}
	
	
}
