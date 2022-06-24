package com.social.socialMedia;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegistrationForm {

	@NotNull
	@Size(min=2, max=15, message = "length should be between 2 and 15 characters.")
	private String name;
	
	@NotNull
	private String password;
	
	@NotNull
	private String confirmPassword;
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassWord() {
		return this.password;
	}

	public void setPassWord(String password) {
		this.password = password;
		matchPassword();
	}
	
	public String getConfirmPassWord() {
		return this.confirmPassword;
	}

	public void setConfirmPassWord(String confirmPassword) {
		this.confirmPassword = confirmPassword;
		matchPassword();
	}
	
	public void matchPassword() {
		if (this.password == null || this.confirmPassword == null) {
			return;
		} else if (!this.password.equals(confirmPassword)) {
			this.confirmPassword = null;
		}
	}
}
