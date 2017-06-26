package com.htgy.service;

/*
 * Service接口 @Service服务层组件，用于标注业务层组件,表示定义一个bean.   
 * 自动根据bean的类名实例化一个首写字母为小写的bean，例如Chinese实例化为chinese，如果需要自己改名字则:@Service("你自己改的bean名")。
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