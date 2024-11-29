package edu.projet.pfe.services;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import edu.projet.pfe.entities.User;

public class UserDetailsImpl implements UserDetails {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String username;
	private String email;
	private boolean status;
	@JsonIgnore
	private String password;
	private String role;
	private List<GrantedAuthority> authorities;

	public UserDetailsImpl(Long id, String username, String email, String password, String role,
			boolean status) {
		this.id = id;
		this.username=username;
		this.email = email;
		this.password = password;
		this.role = role;
		this.status = status;
	}

	public static UserDetailsImpl build(User user) {

		return new UserDetailsImpl(user.getId(), user.getUsername(), user.getEmail(),
				user.getPassword(), user.getRole(), user.getStatus());
	}

	public UserDetailsImpl(User user) {

		this.username=user.getUsername();
		this.password = user.getPassword();
		this.status = user.getStatus();
		this.authorities = Arrays.stream(user.getRole().split(",")).map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDetailsImpl user = (UserDetailsImpl) o;
		return Objects.equals(id, user.id);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	

	@Override
	public String getUsername() {
		return username;
	}

}