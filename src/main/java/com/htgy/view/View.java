package com.htgy.view;

/*
 * ��ͼ��
 */

//@Component @Component��ָ�������������ù����ʱ�����ǿ���ʹ�����ע����б�ע�� 
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