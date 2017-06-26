package com.htgy.form;

/*
 * ±Ìµ•¿‡
 */
public class UserForm {
    private String account;
    private String password;
    private String passFirst;
    private String passSecond;
    private String username;
    
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getAccount() {
        return account;
    }
    public void setAccount(String account) {
        this.account = account;
    }
    public String getPassFirst() {
        return passFirst;
    }
    public void setPassFirst(String passFirst) {
        this.passFirst = passFirst;
    }
    public String getPassSecond() {
        return passSecond;
    }
    public void setPassSecond(String passSecond) {
        this.passSecond = passSecond;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
	@Override
	public String toString() {
		return "UserForm [account=" + account + ", password=" + password + ", passFirst=" + passFirst + ", passSecond="
				+ passSecond + ", username=" + username + "]";
	}
    
}