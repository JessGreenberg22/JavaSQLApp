package model;
/** user Model
 * @Author Jessica Greenberg Student ID 001462404
 */
public class user
{
    private Integer userId;
    private String userName;
    private String password;

/**class Constructor*/
public user(Integer userId,String password)
{
    this.userId = userId;
    this.password = password;

}
public user(String userName,String password)
{
    this.userName = userName;
    this.password = password;
}

    public user(int userId, String userName, String userPassword) {
    }


    /**getters*/
public int getUserId()
{ return userId; }

public String getUserName()
{ return userName; }

public String getPassword()
{ return password; }

    /**Setters*/
    public void setUserId(int userId)
    {this.userId = userId;}

    public void setUserName(String userName)
    {this.userName = userName;}

    public void setPassword(String password)
    {this.password = password;}
}
