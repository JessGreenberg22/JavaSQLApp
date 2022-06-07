package model;
/*this is the Contact model*/

public class contact {
    private int contactId;
    private String contactName;
    private String email;

    public contact (int contactId, String contactName, String email){
        this.contactId = contactId;
        this.contactName = contactName;
        this.email = email;
    }
    /*getters for the contact model*/
    public int getContactId(){
        return contactId;
    }
    public String getContactName(){
        return contactName;
    }
    public String getEmail(){
        return email;
    }

    /*setters*/

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
