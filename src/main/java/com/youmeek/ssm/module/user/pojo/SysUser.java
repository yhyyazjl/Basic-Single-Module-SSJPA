package com.youmeek.ssm.module.user.pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "sys_user")
public class SysUser implements Serializable {
	
	@Id
	@GenericGenerator(name = "IdentifierGenerator", strategy = "identity")
	@GeneratedValue(generator = "IdentifierGenerator")
	@Column(name = "sys_user_id", nullable = false)
	private Long sysUserId;
	
	@Column(name = "sys_user_login_name", nullable = false)
	private String sysUserLoginName;
	
	@Column(name = "sys_user_login_password", nullable = false)
	private String sysUserLoginPassword;
	
	@Column(name = "sys_user_is_delete", nullable = false)
	private String sysUserIsDelete;
	
	@Column(name = "sys_user_register_datetime", nullable = false)
	private Date sysUserRegisterDatetime;
	
	@Column(name = "sys_user_email", nullable = false)
	private String sysUserEmail;
	
	@Column(name = "sys_user_mobile", nullable = false)
	private String sysUserMobile;
	
	public Long getSysUserId() {
		return sysUserId;
	}
	
	public void setSysUserId(Long sysUserId) {
		this.sysUserId = sysUserId;
	}
	
	public String getSysUserLoginName() {
		return sysUserLoginName;
	}
	
	public void setSysUserLoginName(String sysUserLoginName) {
		this.sysUserLoginName = sysUserLoginName;
	}
	
	public String getSysUserLoginPassword() {
		return sysUserLoginPassword;
	}
	
	public void setSysUserLoginPassword(String sysUserLoginPassword) {
		this.sysUserLoginPassword = sysUserLoginPassword;
	}
	
	public String getSysUserIsDelete() {
		return sysUserIsDelete;
	}
	
	public void setSysUserIsDelete(String sysUserIsDelete) {
		this.sysUserIsDelete = sysUserIsDelete;
	}
	
	public Date getSysUserRegisterDatetime() {
		return sysUserRegisterDatetime;
	}
	
	public void setSysUserRegisterDatetime(Date sysUserRegisterDatetime) {
		this.sysUserRegisterDatetime = sysUserRegisterDatetime;
	}
	
	public String getSysUserEmail() {
		return sysUserEmail;
	}
	
	public void setSysUserEmail(String sysUserEmail) {
		this.sysUserEmail = sysUserEmail;
	}
	
	public String getSysUserMobile() {
		return sysUserMobile;
	}
	
	public void setSysUserMobile(String sysUserMobile) {
		this.sysUserMobile = sysUserMobile;
	}
	
	@Override
	public String toString() {
		return "SysUser{" +
				"sysUserId=" + sysUserId +
				", sysUserLoginName='" + sysUserLoginName + '\'' +
				", sysUserLoginPassword='" + sysUserLoginPassword + '\'' +
				", sysUserIsDelete='" + sysUserIsDelete + '\'' +
				", sysUserRegisterDatetime=" + sysUserRegisterDatetime +
				", sysUserEmail='" + sysUserEmail + '\'' +
				", sysUserMobile='" + sysUserMobile + '\'' +
				'}';
	}
}