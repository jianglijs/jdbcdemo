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
//@Service�������������ڱ�עҵ������,��ʾ����һ��bean.   
//�Զ�����bean������ʵ����һ����д��ĸΪСд��bean������Chineseʵ����Ϊchinese�������Ҫ�Լ���������:@Service("���Լ��ĵ�bean��")��
//�˴���ServiceImpl��ʼ��Ϊ����Ϊ"sI"��bean
public class ServiceImpl implements Serviceinterface{
    @Resource
    private UserDAOImpl dao;
    
    //�˺Ż����벻��Ϊ��
    public HashMap<String, Object> dealNull(){
        HashMap<String, Object> map = new HashMap<String,Object>();
        List<String> msgList = new ArrayList<String>(); 
        msgList.add("�˺Ż����벻��Ϊ��");
        map.put("msg", msgList);
        return map;
    }
    //��¼�ɹ�
    public HashMap<String, Object> loginSuccess(){
        HashMap<String, Object> map = new HashMap<String,Object>();
        List<String> msgList = new ArrayList<String>(); 
        msgList.add("��ϲ������¼�ɹ�");
        map.put("msg", msgList);
        return map;
    }
    //�˺Ż��������
    public HashMap<String, Object> error(){
        HashMap<String, Object> map = new HashMap<String,Object>();
        List<String> msgList = new ArrayList<String>(); 
        msgList.add("�˺Ż��������");
        map.put("msg", msgList);
        return map;
    }
    //��Ϣ������
    public HashMap<String, Object> intact(){
        HashMap<String, Object> map = new HashMap<String,Object>();
        List<String> msgList = new ArrayList<String>(); 
        msgList.add("�뽫��Ϣ��д����");
        map.put("msg", msgList);
        return map;
    }
    //��Ϣ����ȷ
    public HashMap<String, Object> correct(){
        HashMap<String, Object> map = new HashMap<String,Object>();
        List<String> msgList = new ArrayList<String>(); 
        msgList.add("����ȷ��д��Ϣ");
        map.put("msg", msgList);
        return map;
    }
    //���벻һ��
    public HashMap<String, Object> consistent(){
        HashMap<String, Object> map = new HashMap<String,Object>();
        List<String> msgList = new ArrayList<String>(); 
        msgList.add("������������벻һ��");
        map.put("msg", msgList);
        return map;
    }
    //�˺Ŵ���
    public HashMap<String, Object> accountExist(){
        HashMap<String, Object> map = new HashMap<String,Object>();
        List<String> msgList = new ArrayList<String>(); 
        msgList.add("�˺��Ѵ���");
        map.put("msg", msgList);
        return map;
    }
    //�û�������
    public HashMap<String, Object> usernameExist(){
        HashMap<String, Object> map = new HashMap<String,Object>();
        List<String> msgList = new ArrayList<String>(); 
        msgList.add("�û����Ѵ���");
        map.put("msg", msgList);
        return map;
    }


    //���˺Ų�ѯ
    public boolean queryAccount(String account){
        try{
            dao.queryAccount(account);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    //���û�����ѯ
    public  boolean queryUsername(String username){
        try{
            dao.queryUsername(username);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    //��ѯ
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
    //����
    public void insert(String account,String password,String username){
        dao.insert(account,password,username);
    }
}