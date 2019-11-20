package com.codersnation.bean;

import java.util.Date;

public class User {
	private long id;
	private String fname;
	private String mname;
	private String lname;
	private String email;
	private String password;
	private String phoneNumber;
	private Date createdAt;
	private String profilePic;
	private String resume;
	private String emailOtp;
	private String emailExpiry;
	private int emailOtpValidated;
	
	
	

	public int getEmailOtpValidated() {
		return emailOtpValidated;
	}

	public void setEmailOtpValidated(int emailOtpValidated) {
		this.emailOtpValidated = emailOtpValidated;
	}

	public String getEmailOtp() {
		return emailOtp;
	}

	public void setEmailOtp(String emailOtp) {
		this.emailOtp = emailOtp;
	}

	public String getEmailExpiry() {
		return emailExpiry;
	}

	public void setEmailExpiry(String emailExpiry) {
		this.emailExpiry = emailExpiry;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", fname=" + fname + ", mname=" + mname + ", lname=" + lname + ", email=" + email
				+ ", password=" + password + ", phoneNumber=" + phoneNumber + ", createdAt=" + createdAt
				+ ", profilePic=" + profilePic + ", resume=" + resume + "]";
	}

}
