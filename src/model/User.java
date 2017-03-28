package model;

public class User {
    private int user_id;
    private String firstnameua;
	private String surnameua;
    private String patronymicua;
    private String firstnamelatin;
  	private String surnamelatin;
    private String patronymiclatin;
    private String email;
    private String password;
    private String phone;
    private Integer user_group_id;
    private String reason;
    private boolean status;
 
    


    public User() {
    }
    

    public User(String firstnameua, String surnameua, String patronymicua,String firstnamelatin, String surnamelatin, String patronymiclatin, String email, String password,
	  String phone, Integer user_group_id, boolean status, String reason) {
	this.firstnameua = firstnameua;
	this.surnameua = surnameua;
	this.patronymicua = patronymicua;
	this.firstnamelatin = firstnamelatin;
	this.surnamelatin = surnamelatin;
	this.patronymiclatin = patronymiclatin;
	this.email = email;
	this.password = password;
	this.phone = phone;
	this.user_group_id = user_group_id;
	this.status = status;
	this.reason = reason;
    }
    

    public int getUser_id() {
	return user_id;
    }

    public void setUser_id(int user_id) {
	this.user_id = user_id;
    }
    
    public String getFirstnameua() {
		return firstnameua;
	}

	public void setFirstnameua(String firstnameua) {
		this.firstnameua = firstnameua;
	}

	public String getSurnameua() {
		return surnameua;
	}

	public void setSurnameua(String surnameua) {
		this.surnameua = surnameua;
	}

	public String getPatronymicua() {
		return patronymicua;
	}

	public void setPatronymicua(String patronymicua) {
		this.patronymicua = patronymicua;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

    

    public String getFirstnamelatin() {
		return firstnamelatin;
	}


	public void setFirstnamelatin(String firstnamelatin) {
		this.firstnamelatin = firstnamelatin;
	}


	public String getSurnamelatin() {
		return surnamelatin;
	}


	public void setSurnamelatin(String surnamelatin) {
		this.surnamelatin = surnamelatin;
	}


	public String getPatronymiclatin() {
		return patronymiclatin;
	}


	public void setPatronymiclatin(String patronymiclatin) {
		this.patronymiclatin = patronymiclatin;
	}


	public Integer getUser_group_id() {
		return user_group_id;
	}


	public void setUser_group_id(Integer user_group_id) {
		this.user_group_id = user_group_id;
	}
	
	public String getReason() {
		return reason;
	    }

    public void setReason(String reason) {
	this.reason = reason;
    }


	@Override
    public String toString() {
	return "User [user_id=" + user_id + ", firstnameua=" + firstnameua + ", surnameua=" + surnameua 
		+ ", patronymicua=" + patronymicua+ ", firstnamelatin=" + patronymiclatin+ ", surnamelatin=" + surnamelatin
		+ ", patronymiclatin=" + patronymiclatin
		+ ", user_group_id=" + user_group_id
		+ ", email=" + email + ", password=" + password +  ", phone="
		+ phone + ", status=" + status +", reason=" + reason +"]";
    }

    
}
