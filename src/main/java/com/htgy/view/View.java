package com.htgy.view;

/*
 * 视图类
 */

//@Component @Component泛指组件，当组件不好归类的时候，我们可以使用这个注解进行标注。 
public class View {
    private String loginSuccess;
    private String registSuccess;
    private String registFail;
    private String login;
    private String regist;
    public String getLoginSuccess() {
        return loginSuccess;
    }
    public void setLoginSuccess(String loginSuccess) {
        this.loginSuccess = loginSuccess;
    }
    public String getRegistSuccess() {
        return registSuccess;
    }
    public void setRegistSuccess(String registSuccess) {
        this.registSuccess = registSuccess;
    }
    public String getRegistFail() {
        return registFail;
    }
    public void setRegistFail(String registFail) {
        this.registFail = registFail;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getRegist() {
        return regist;
    }
    public void setRegist(String regist) {
        this.regist = regist;
    }
}