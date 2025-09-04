package edu.dosw.lab;

public class Location {
    private String city;
    private String neighborhood;

    public Location(String city, String neighborhood) {
        this.city = city;
        this.neighborhood = neighborhood;
    }

    // Getters y setters
    public String getCity() {return city;}

    public void setCity(String city) {this.city = city;}

    public String getNeighborhood() {return neighborhood;}

    public void setNeighborhood(String neighborhood) {this.neighborhood = neighborhood;}
}
