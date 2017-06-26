package com.htgy.userdao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.htgy.user.User;

@SuppressWarnings("all") 
public interface UserDAO{  
    //一个template访问一个数据库，也可以继承JdbcDaoSupport实现
    public JdbcTemplate template = null; 

    // 此方法把USEMBO表对应的字段查询出来依次放入userPO中  
    // public Collection<UserPO> doquery();
    // public User doquery(final String account,final String password);

    //按账号查询
    public User queryAccount(String account);

    //按用户名查询
    public User queryUsername(String username);

    //增加
    public void insert(String account,String password,String username);

    //        class UserRowMapper implements RowMapper;
    //        public List findAllByRowMapperResultReader(String accont);
}
