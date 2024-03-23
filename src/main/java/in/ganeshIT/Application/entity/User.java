package in.ganeshIT.Application.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer uid;
	private String email;
	private String pwd;
	private Long phno;
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Long getPhno() {
		return phno;
	}
	public void setPhno(Long phno) {
		this.phno = phno;
	}
	public User(Integer uid, String email, String pwd, Long phno) {
		super();
		this.uid = uid;
		this.email = email;
		this.pwd = pwd;
		this.phno = phno;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
