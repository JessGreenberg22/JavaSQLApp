package model;
/** user Model
 * @Author Jessica Greenberg Student ID 001462404
 */
public class User
{
    private Integer userId;
    private String username;
    private String password;

/**class Constructor*/
public User(Integer userId, String password)
{
    this.userId = userId;
    this.password = password;

}
public User(String username, String password)
{
    this.username = username;
    this.password = password;
}

    public User(int userId, String userName, String userPassword) {
    }


    /**getters*/
public int getUserId()
{ return userId; }

public String getUsername()
{ return username; }

public String getPassword()
{ return password; }

    /**Setters*/
    public void setUserId(int userId)
    {this.userId = userId;}

    public void setUsername(String username)
    {this.username = username;}

    public void setPassword(String password)
    {this.password = password;}
}
