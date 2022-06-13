package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * JDBC Class
 *
 * @Author Jessica Greenberg Student ID 001462404
 */

public abstract class JDBC {
    private static final String protocol = "jdbc";
    private static final String vendor = ":mysql:";
    private static final String location = "//localhost/";
    private static final String databaseName = "client_schedule";
    private static final String jdbcUrl = protocol + vendor + location + databaseName + "?connectionTimeZone = SERVER"; // LOCAL
    private static final String driver = "com.mysql.cj.jdbc.Driver"; //Driver reference
    private static final String userName = "sqlUser"; // UserName
    private static final String password = "Passw0rd!"; // Password
    public static Connection connection; // Connection Interface




    /*
    Method Opening Connections to the Referenced Database
     */
    public static void openConnection()
    {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(jdbcUrl,userName,password);
            System.out.println("Connection Successful");
        }
        catch (Exception e)
        {
            System.out.println("Error:" + e.getMessage());
        }
    }

public static Connection getConnection() {
        return connection;
        }

    /*Method Closing Connections to the Referenced Database*/
public static void closeConnection() {
    try {
        connection.close();
        System.out.println("Connection Closed" );
    }
    catch(Exception e)
    {
        System.out.println("Error:" + e.getMessage());
    }
}

}