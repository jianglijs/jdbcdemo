package com.htgy.userdao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.htgy.user.User;

@SuppressWarnings("all") 
public interface UserDAO{  
    //һ��template����һ�����ݿ⣬Ҳ���Լ̳�JdbcDaoSupportʵ��
    public JdbcTemplate template = null; 

    // �˷�����USEMBO���Ӧ���ֶβ�ѯ�������η���userPO��  
    // public Collection<UserPO> doquery();
    // public User doquery(final String account,final String password);

    //���˺Ų�ѯ
    public User queryAccount(String account);

    //���û�����ѯ
    public User queryUsername(String username);

    //����
    public void insert(String account,String password,String username);

    //        class UserRowMapper implements RowMapper;
    //        public List findAllByRowMapperResultReader(String accont);
}
