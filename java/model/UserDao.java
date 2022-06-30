package model;

import java.sql.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * model.User: yzh
 * Date: 2022-06-27
 * Time: 19:05
 */
public class UserDao {
    //需要实现的操作
    //1.根据用户名来查找用户信息
    //会在登录逻辑中使用
    public User selectByName(String username){
        Connection connection=null;
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        try {
            connection=DBUtil.getConnection();
            String sql="select * from user where username=?";
            statement=connection.prepareStatement(sql);
            statement.setString(1,username);
            resultSet=statement.executeQuery();
            //此处username用unique约束
            if(resultSet.next()){
                User user=new User();
                user.setUserId(resultSet.getInt("userId"));
                user.getUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return null;
    }


    //2.根据用户id来查找用户信息
    //博客详情页，就可以根据用户id来查询作者的名字，把作者的名字显示出来
    public User selectById(int userId){
        Connection connection=null;
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        try {
            connection=DBUtil.getConnection();
            String sql="select * from user where userId=?";
            statement=connection.prepareStatement(sql);
            statement.setInt(1,userId);
            resultSet=statement.executeQuery();
            //此处username用unique约束
            if(resultSet.next()){
                User user=new User();
                user.setUserId(resultSet.getInt("userId"));
                user.getUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return null;
    }
}
