package com.htgy.userdao.impl;

/*
 * UserDAOImplʵ��
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.htgy.userdao.UserDAO;
import com.htgy.user.User;

@Repository("dao")
public class UserDAOImpl implements UserDAO{
    //һ��template����һ�����ݿ⣬Ҳ���Լ̳�JdbcDaoSupportʵ��
    @Resource
    private JdbcTemplate template;  
    // �˷�����USEMBO���Ӧ���ֶβ�ѯ�������η���userPO��  
//    public Collection<UserPO> doquery() {  
//        String sql = "SELECT T.USERID,T.USERNAME,T.USERAGE FROM USERMBO T";  
//        return super.getJdbcTemplate().query(sql, new RowMapper() {  
//            public Object mapRow(ResultSet rs, int num) throws SQLException {  
//                UserPO user = new UserPO();  
//                user.setUserId(rs.getInt("USERID"));  
//                user.setUserName(rs.getString("USERNAME"));  
//                user.setUserAge(rs.getInt("USERAGE"));  
//                return user;  
//            }  
//        });  
    
//        public User doquery(final String account,final String password){
//         User user = (User) this.template.queryForObject(
//                "SELECT account, password FROM user WHERE account=?",
//                new Object[]{account},
//                new RowMapper() {
//                    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//                        User user = new User();
//                        user.setAccount(rs.getString(account));
//                        user.setPassword(rs.getString(password));
//                        return user;
//                    }
//                });
//        return user;
//    }  
    
        //���˺Ų�ѯ�����˺Ų������򱨴�
        @SuppressWarnings({ "unchecked", "rawtypes" })
        @Override
        public User queryAccount(String account){
            User user = (User) this.template.queryForObject(
                    "SELECT account, password,username FROM user WHERE account=?",
                    new Object[]{account}, 
                    new RowMapper() {
                        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                            User user = new User();
                            user.setAccount(rs.getString("account")); 
                            user.setPassword(rs.getString("password"));
                            user.setUsername(rs.getString("username"));
                            System.out.println("queryAccount username = "+user.getUsername());
                            return user;
                        }
                    });
            return user;
        }  
        
        //���û�����ѯ���������򱨴�
        @SuppressWarnings({ "unchecked", "rawtypes" })
        @Override
        public User queryUsername(String username){
            User user = (User) this.template.queryForObject(
                    "SELECT account, password,username FROM user WHERE username=?",
                    new Object[]{username},
                    new RowMapper() {
                        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                            User user = new User();
                            user.setAccount(rs.getString("account")); 
                            user.setPassword(rs.getString("password"));
                            user.setUsername(rs.getString("username"));
                            System.out.println("queryUsername username = "+user.getUsername());
                            return user;
                        }
                    });
            return user;
        }  
        
        //�����û�
        @Override
        public void insert(String account,String password,String username){
            this.template.update(
                    "INSERT INTO user (account, password,username) values (?, ?, ?)", 
                    new Object[] {account,password,username});
        }

//        class UserRowMapper implements RowMapper {  
//            public Object mapRow(ResultSet rs, int index) throws SQLException {  
//                User user = new User();  
//                user.setAccount(rs.getString("account"));
//                user.setPassword(rs.getString("password"));
//                return user;  
//            }  
//        }  
//          
//        public List findAllByRowMapperResultReader(String accont) {  
//            String sql = "SELECT * FROM USER";  
//            return this.template.queryForObject(sql,new UserRowMapper());  
//        }  
}