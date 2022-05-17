package model;

import java.sql.Time;
import java.sql.Timestamp;
/** Appointments Model
 * @Author Jessica Greenberg Student ID 001462404
 */

/**Appointment Object Class*/
public class Appointments {
    private int appointmentId;
    private String title;
    private String description;
    private String location;
    private String type;
    private Timestamp startDateTime;
    private Timestamp endDateTime;
    private int customerId;
    private int userId;
    private int contactId;

    /**Constructor for Appointments*/

    public Appointments (int appointmentId, String title, String description, String location, String type, Timestamp startDateTime,
                             Timestamp endDateTime, int customerId, int userId, int contactId)
    {
        this.appointmentId = appointmentId;
        this.title = title;
        this.description = description;
        this.location = location;
        this.type = type;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.customerId = customerId;
        this.userId = userId;
        this.contactId = contactId;
    }
    /**Getters*/
    public int getAppointmentId()
    {return appointmentId;}

    public String getTitle()
        {return title;}

    public String getDescription()
    {return description;}

    public String getLocation()
    {return location;}

    public String getType()
    {return type;}

    public Timestamp getStartDateTime()
    {return startDateTime;}

    public Timestamp getEndDateTime()
    {return endDateTime;}

    public int getCustomerId()
    {return customerId;}

    public int getUserId()
    {return userId;}

    public int getContactId()
    {return contactId;}

    /**Setters*/
    public void setAppointmentId(int appointmentId)
    {this.appointmentId = appointmentId;}

    public void setTitle(String title)
    {this.title = title;}

    public void setDescription(String description)
    {this.description = description;}

    public void setLocation(String location)
    {this.location = location;}

    public void setType(String type)
    {this.type = type;}

    public void setStartDateTime(Timestamp startDateTime)
    {this.startDateTime = startDateTime;}

    public void setEndDateTime(Timestamp endDateTime)
    {this.endDateTime = endDateTime;}

    public void setCustomerIdId(int customerId)
    {this.customerId = customerId;}

    public void setUserId(int userId)
    {this.userId = userId;}

    public void setContactId(int contactId)
    {this.contactId = contactId;}
}
