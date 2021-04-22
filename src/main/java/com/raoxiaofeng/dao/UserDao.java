package com.raoxiaofeng.dao;

import com.raoxiaofeng.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDao implements IUserDao{
    @Override
    public boolean saveUser(Connection con, User user) throws SQLException {
        //insert..into usertable -- write code yourself
        String sql = "INSERT INTO usertable(username,password,email,gender,birthdate)" + "values(?,?,?,?,?)";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1,user.getUsername());
        st.setString(2,user.getPassword());
        st.setString(3,user.getEmail());
        st.setString(4,user.getGender());
        st.setDate(5, (java.sql.Date) user.getBirthdate());
        st.executeUpdate();
        st.close();

        return true;
    }

    @Override
    public int deleteUser(Connection con, User user) throws SQLException {
        //delete .... where id = ?
        String sql = "delete from usertable where id='"+user.getId()+"'";
        PreparedStatement st = con.prepareStatement(sql);
        int a = st.executeUpdate();
        st.close();
        return a;
    }

    @Override
    public int updateUser(Connection con, User user) throws SQLException {
        //update...where id=?
        String sql = "update usertable set username = '"+user.getUsername()+"',"
                +"password = '" + user.getPassword()+"',"
                +"email = '" + user.getEmail()+"',"
                +"gender = '" + user.getGender()+"',"
                +"birthdate = '" + user.getBirthdate()+"'"
                +"where id = " + user.getId();
        PreparedStatement st = con.prepareStatement(sql);
        int a = st.executeUpdate();
        st.close();
        return a;
    }

    @Override
    public User findById(Connection con, Integer id) throws SQLException {
        //select -- where id=? -- write jdbc code yourself
        String sql = "select id,username,password,email,gender,birthdate from usertable where id="+id;
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        User user = null;
        if(rs.next()){
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
        }
        return user;
    }

    @Override
    public User findByUsernamePassword(Connection con, String username, String password) throws SQLException {
        String sql = "select id,username,password,email,gender,birthdate from usertable where username='"+username+" 'and password='"+password+"'";
        PreparedStatement st = con.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        User user = null;
        if(rs.next()){
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
        }
        return user;
    }

    @Override
    public List<User> findByUsername(Connection con, String username) throws SQLException {
        String sql = "select id,username,password,email,gender,birthdate from usertable where username='"+username+"'";
        PreparedStatement st = con.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        List<User> User = new ArrayList<User>();
        User user = null;
        if(rs.next()){
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
            User.add(user);
        }
        return User;
    }

    @Override
    public List<User> findByPassword(Connection con, String password) throws SQLException {
        String sql = "select id,username,password,email,gender,birthdate from usertable where password='"+password+"'";
        PreparedStatement st = con.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        List<User> User = new ArrayList<User>();
        User user = null;
        if(rs.next()){
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
            User.add(user);
        }
        return User;
    }

    @Override
    public List<User> findByEmail(Connection con, String email) throws SQLException {
        String sql = "select id,username,password,email,gender,birthdate from usertable where email='"+email+"'";
        PreparedStatement st = con.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        List<User> User = new ArrayList<User>();
        User user;
        if(rs.next()){
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
            User.add(user);
        }
        return User;
    }

    @Override
    public List<User> findByGender(Connection con, String gender) throws SQLException {
        String sql = "select id,username,password,email,gender,birthdate from usertable where gender='"+gender+"'";
        PreparedStatement st = con.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        List<User> User = new ArrayList<User>();
        User user;
        if(rs.next()){
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
            User.add(user);
        }
        return User;
    }

    @Override
    public List<User> findByBirthdate(Connection con, Date birthDate) throws SQLException {
        String sql = "select id,username,password,email,gender,birthdate from usertable where birthdate='"+birthDate+"'";
        PreparedStatement st = con.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        List<User> User = new ArrayList<User>();
        User user;
        if(rs.next()){
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
            User.add(user);
        }
        return User;
    }

    @Override
    public List<User> findAllUser(Connection con) throws SQLException {
        String sql = "select id,username,password,email,gender,birthdate from usertable";
        PreparedStatement st = con.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        List<User> User = new ArrayList<User>();
        User user;
        if(rs.next()){
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
            User.add(user);
        }
        return User;
    }
}
