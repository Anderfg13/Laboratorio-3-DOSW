package edu.dosw.lab;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class BranchTest {

    private Branch branch;
    private Location location;

    @BeforeEach
    void setUp() {
        location = new Location();
        location.setCity("Bogotá");
        location.setNeighborhood("Chapinero");

        branch = new Branch();
        branch.setTypeRequest(1);
        branch.setCreationRequest(LocalDateTime.of(2023, 5, 10, 14, 30));
        branch.setBranchID(101);
        branch.setLocation(location);
    }

    @Test
    void testGettersReturnCorrectValues() {
        assertEquals(1, branch.getTypeRequest());
        assertEquals(LocalDateTime.of(2023, 5, 10, 14, 30), branch.getCreationRequest());
        assertEquals(101, branch.getBranchID());
        assertEquals(location, branch.getLocation());
        assertEquals("Bogotá", branch.getLocation().getCity());
        assertEquals("Chapinero", branch.getLocation().getNeighborhood());
    }

    @Test
    void testSettersUpdateValuesCorrectly() {
        Location newLocation = new Location();
        newLocation.setCity("Medellín");
        newLocation.setNeighborhood("El Poblado");

        branch.setTypeRequest(2);
        branch.setCreationRequest(LocalDateTime.of(2024, 6, 15, 9, 45));
        branch.setBranchID(202);
        branch.setLocation(newLocation);

        assertEquals(2, branch.getTypeRequest());
        assertEquals(LocalDateTime.of(2024, 6, 15, 9, 45), branch.getCreationRequest());
        assertEquals(202, branch.getBranchID());
        assertEquals(newLocation, branch.getLocation());
        assertEquals("Medellín", branch.getLocation().getCity());
        assertEquals("El Poblado", branch.getLocation().getNeighborhood());
    }
}
