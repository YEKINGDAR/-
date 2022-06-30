package model;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * model.User: yzh
 * Date: 2022-06-27
 * Time: 17:01
 */
//每个User对象，则表示user表里的一条记录
public class User {
    private int userId=0;
    private String username="";
    private String password="";


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername(String username) {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
