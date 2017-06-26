package com.htgy.service;

/*
 * Service�ӿ� @Service�������������ڱ�עҵ������,��ʾ����һ��bean.   
 * �Զ�����bean������ʵ����һ����д��ĸΪСд��bean������Chineseʵ����Ϊchinese�������Ҫ�Լ���������:@Service("���Լ��ĵ�bean��")��
 */
import java.util.HashMap;
public interface Serviceinterface {
    public boolean queryAccount(String account);
    public boolean queryUsername(String username);
    public void insert(String account,String password,String username);
    public boolean doquery(String account,String password);
    public HashMap<String, Object> dealNull();
    public HashMap<String, Object> loginSuccess();
    public HashMap<String, Object> error();
    public HashMap<String, Object> intact();
    public HashMap<String, Object> correct();
    public HashMap<String, Object> consistent();
    public HashMap<String, Object> accountExist();
    public HashMap<String, Object> usernameExist();
}