package ru.skillbox;

public class Country {

    String countryName;
    int populationSize;
    double square;                //km2
    String capitalName;
    boolean seaAccess;


    public Country(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getPopulationSize() {
        return populationSize;
    }

    public void setPopulationSize(int populationSize) {
        this.populationSize = populationSize;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public String getCapitalName() {
        return capitalName;
    }

    public void setCapitalName(String capitalName) {
        this.capitalName = capitalName;
    }

    public boolean isSeaAccess() {
        return seaAccess;
    }

    public void setSeaAccess(boolean seaAccess) {
        this.seaAccess = seaAccess;
    }
}
