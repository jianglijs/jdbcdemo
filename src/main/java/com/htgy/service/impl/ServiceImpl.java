package com.htgy.service.impl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.htgy.service.Serviceinterface;
import com.htgy.user.User;
import com.htgy.userdao.impl.UserDAOImpl;

@Service("sI") 
//@Service服务层组件，用于标注业务层组件,表示定义一个bean.   
//自动根据bean的类名实例化一个首写字母为小写的bean，例如Chinese实例化为chinese，如果需要自己改名字则:@Service("你自己改的bean名")。
//此处将ServiceImpl初始化为名称为"sI"的bean
public class ServiceImpl implements Serviceinterface{
    @Resource
    private UserDAOImpl dao;
    
    //账号或密码不能为空
    public HashMap<String, Object> dealNull(){
        HashMap<String, Object> map = new HashMap<String,Object>();
        List<String> msgList = new ArrayList<String>(); 
        msgList.add("账号或密码不能为空");
        map.put("msg", msgList);
        return map;
    }
    //登录成功
    public HashMap<String, Object> loginSuccess(){
        HashMap<String, Object> map = new HashMap<String,Object>();
        List<String> msgList = new ArrayList<String>(); 
        msgList.add("恭喜您，登录成功");
        map.put("msg", msgList);
        return map;
    }
    //账号或密码错误
    public HashMap<String, Object> error(){
        HashMap<String, Object> map = new HashMap<String,Object>();
        List<String> msgList = new ArrayList<String>(); 
        msgList.add("账号或密码错误");
        map.put("msg", msgList);
        return map;
    }
    //信息不完整
    public HashMap<String, Object> intact(){
        HashMap<String, Object> map = new HashMap<String,Object>();
        List<String> msgList = new ArrayList<String>(); 
        msgList.add("请将信息填写完整");
        map.put("msg", msgList);
        return map;
    }
    //信息不正确
    public HashMap<String, Object> correct(){
        HashMap<String, Object> map = new HashMap<String,Object>();
        List<String> msgList = new ArrayList<String>(); 
        msgList.add("请正确填写信息");
        map.put("msg", msgList);
        return map;
    }
    //密码不一致
    public HashMap<String, Object> consistent(){
        HashMap<String, Object> map = new HashMap<String,Object>();
        List<String> msgList = new ArrayList<String>(); 
        msgList.add("两次输入的密码不一致");
        map.put("msg", msgList);
        return map;
    }
    //账号存在
    public HashMap<String, Object> accountExist(){
        HashMap<String, Object> map = new HashMap<String,Object>();
        List<String> msgList = new ArrayList<String>(); 
        msgList.add("账号已存在");
        map.put("msg", msgList);
        return map;
    }
    //用户名存在
    public HashMap<String, Object> usernameExist(){
        HashMap<String, Object> map = new HashMap<String,Object>();
        List<String> msgList = new ArrayList<String>(); 
        msgList.add("用户名已存在");
        map.put("msg", msgList);
        return map;
    }


    //按账号查询
    public boolean queryAccount(String account){
        try{
            dao.queryAccount(account);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    //按用户名查询
    public  boolean queryUsername(String username){
        try{
            dao.queryUsername(username);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    //查询
    public boolean doquery(String account,String password){
        try{
            User user=dao.queryAccount(account);
            if(user.getAccount().equals(account)&&user.getPassword().equals(password)){
                return true;
            }
            else{
                return false;
            }
        }catch(Exception e){
            return false;
        }
    }
    //查找
    public void insert(String account,String password,String username){
        dao.insert(account,password,username);
    }
}