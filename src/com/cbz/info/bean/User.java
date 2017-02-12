package com.cbz.info.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="User")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id ;
	
	@NotNull(message = "username不能为空")
	@Size(min=3,max=20,message="{username.size}")
	@Column(name="username")
	private String username ;
	
	@NotNull(message = "password不能为空")
	@Size(min=3,max=20,message="{password.size}")
	@Column(name="password")
	private String password ;
	
	
	@Column(name="query_password")
	private String query_password ;
	
	@Column(name="mobile")
	private String mobile ;
	
	@Column(name="email")
	private String email ;
	
	@Column(name="status")
	private int status ;
	
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="role_id")
	private Role role ;
	
	@ManyToMany(cascade={CascadeType.ALL})
	@JoinTable(name="function_user",joinColumns={@JoinColumn(name="user_id")},inverseJoinColumns={@JoinColumn(name="function_id")})
	private List<Function> function ;
	
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public List<Function> getFunction() {
		return function;
	}
	public void setFunction(List<Function> function) {
		this.function = function;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getQuery_password() {
		return query_password;
	}
	public void setQuery_password(String query_password) {
		this.query_password = query_password;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
