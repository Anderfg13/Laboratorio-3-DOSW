package edu.dosw.lab;

import java.time.LocalDateTime;

public class Branch {
    private String typeRequest;
    private LocalDateTime creationRequest;
    private int branchID;

    private Location location;

    public Branch(String type, String city) {
        this.typeRequest = type;
        this.creationRequest = LocalDateTime.now();
        this.branchID = (int) (Math.random() * 1000);
        this.location = new Location(city, "Default Neighborhood");
    }

    // Getters y setters
    public String getTypeRequest() {return typeRequest;}

    public void setTypeRequest(String typeRequest) {this.typeRequest = typeRequest;}

    public LocalDateTime getCreationRequest() {return creationRequest;}

    public void setCreationRequest(LocalDateTime creationRequest) {this.creationRequest = creationRequest;}

    public int getBranchID() {return branchID;}

    public void setBranchID(int branchID) {this.branchID = branchID;}

    public Location getLocation() {return location;}

    public void setLocation(Location location) {this.location = location;}
}
