package model;

public class Division {

    private int divisionId;
    private int countryId;
    private String division;

    public Division(int divisionId, String division) {
        this.divisionId = divisionId;
        this.countryId = countryId;
        this.division = division;
    }

        /**getters for the divisions model**/
        public int getDivisionId(){
            return divisionId;
        }
        public int getCountryId(){
            return countryId;
    }
    public String getDivision(){
            return division;
    }

    /**Setters for the divisions model*/
    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public void setDivisionId(int divisionId) {
        this.divisionId = divisionId;
    }
}


