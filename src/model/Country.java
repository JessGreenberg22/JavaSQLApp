package model;
/**This is the Country Model*/
public class Country {
    private int countryId;
    private String countryName;

    public Country(int countryId, String countryName){
        this.countryName = countryName;
        this.countryId = countryId;
    }


    //*Getters*//
    public String getCountryName(){
        return countryName;
    }

    public int getCountryId(){
        return countryId;
    }

    //*Setters*//
    public void setCountryName(String countryName){
        this.countryName = countryName;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }
}
