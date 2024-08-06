package spring_pro.entity;

/**
 * @author Enki
 * @ClassName User
 * @Description: TODO
 * @Date 2024/8/6 21:34
 * @Version 1.0
 */
public class User {
    /**
     * user id
     */
    private int userId;

    /**
     * username.
     */
    private String userName;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
