package edu.projet.pfe.domain;

public class JwtResponse  {

	private String token;
	private Long id;
	private String username;
	private String email;
	private String role;
    private boolean status;
	public JwtResponse(String token, Long id, String username ,String email, String role , boolean status) {
		this.token = token;
		this.id = id;
		this.username=username;
		this.email = email;
		this.role = role;
		this.status=status;
	}

	

	
	
	public String getToken() {
		return token;
	}





	public void setToken(String token) {
		this.token = token;
	}





	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	
}