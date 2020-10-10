package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import vo.User;

import tools.JdbcUtil;

public class UserDao {
    private static JdbcUtil jdbcUtil = new JdbcUtil();

    public User getUserByUserName(String userName){
        User user = null;

        Connection con = (Connection) jdbcUtil.getConnection();
        String sql = "select * from t_user";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                String name = rs.getString("userName");
                if(name.equals(userName)){
                    user = new User(
                            rs.getString("userName"),
                            rs.getString("password"),
                            rs.getString("chrName"),
                            rs.getString("role")
                    );
                    break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }




        jdbcUtil.closeAll(rs,ps,con);

        return user;
    }

}


