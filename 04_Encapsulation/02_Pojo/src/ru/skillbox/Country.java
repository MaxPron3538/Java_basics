package ru.skillbox;

public class Country
{
    private String countryName;
    private int numberOfPeople;
    private double squareCountry;
    private String nameOfCapital;
    private boolean accessToTheSea;

    Country(String countryName)
    {
        this.countryName = countryName;
    }

    public String getCountryName(){ return countryName;}

    public int getTheNumberOfPeople(){ return  numberOfPeople;}

    public double getSquareCountry(){ return squareCountry;}

    public String getNameOfCapital(){ return nameOfCapital;}

    public boolean getAccessToTheSea(){ return accessToTheSea;}

    public void setCountryName(String countryName)
    {
        this.countryName = countryName;
    }

    public void setTheNumberOfPeople(int numberOfPeople)
    {
        this.numberOfPeople = numberOfPeople;
    }

    public void setSquareCountry(double squareCountry)
    {
        this.squareCountry = squareCountry;
    }

    public  void setNameOfCapital(String nameOfCapital)
    {
        this.nameOfCapital = nameOfCapital;
    }

    public  void setAccessToTheSea(boolean accessToTheSea)
    {
        this.accessToTheSea = accessToTheSea;
    }
}
