package model;

public class user {
    private Integer userId;
    private String userName;
    private String password;


public user(Integer userId,String password)
{
    this.userId = userId;
    this.password = password;

}
public user(String userName,String password){
    this.userName = userName;
    this.password = password;
}
public int getUserId(){
    return userId;
}
public String getUserName(){
    return userName;
}
public String getPassword(){
    return password;
}
}
