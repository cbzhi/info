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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.cglib.beans.BeanCopier.Generator;


@Entity(name = "role")
@Table
public class Role {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private int id ;
	
	@Column(name = "rolename")
	private String rolename ;
	
	@ManyToMany(cascade={CascadeType.ALL})
	@JoinTable(name="role_function",joinColumns={@JoinColumn(name="role_id")},
	inverseJoinColumns={@JoinColumn(name="function_id")})
	private List<Function> function ;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public List<Function> getFunction() {
		return function;
	}
	public void setFunction(List<Function> function) {
		this.function = function;
	}
	
	
}
