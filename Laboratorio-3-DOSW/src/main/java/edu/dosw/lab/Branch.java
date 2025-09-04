package edu.dosw.lab;

import java.time.LocalDateTime;

public class Branch {
    private int typeRequest;
    private LocalDateTime creationRequest;
    private int branchID;

    private Location location;

    // Getters y setters
    public int getTypeRequest() {return typeRequest;}

    public void setTypeRequest(int typeRequest) {this.typeRequest = typeRequest;}

    public LocalDateTime getCreationRequest() {return creationRequest;}

    public void setCreationRequest(LocalDateTime creationRequest) {this.creationRequest = creationRequest;}

    public int getBranchID() {return branchID;}

    public void setBranchID(int branchID) {this.branchID = branchID;}

    public Location getLocation() {return location;}

    public void setLocation(Location location) {this.location = location;}
}
