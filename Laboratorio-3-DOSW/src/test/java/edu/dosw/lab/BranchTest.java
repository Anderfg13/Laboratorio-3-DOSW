package edu.dosw.lab;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class BranchTest {

    private Branch branch;

    @BeforeEach
    void setUp() {
        branch = new Branch("DEPOSITO", "Bogotá");
    }

    @Test
    void testBranchCreation() {
        assertEquals("DEPOSITO", branch.getTypeRequest());
        assertNotNull(branch.getCreationRequest());
        assertTrue(branch.getBranchID() >= 0 && branch.getBranchID() < 1000);
        assertNotNull(branch.getLocation());
        assertEquals("Bogotá", branch.getLocation().getCity());
        assertEquals("Default Neighborhood", branch.getLocation().getNeighborhood());
    }

    @Test
    void testSettersAndGetters() {
        branch.setTypeRequest("RETIRO");
        branch.setBranchID(123);
        LocalDateTime now = LocalDateTime.of(2025, 9, 3, 10, 0);
        branch.setCreationRequest(now);

        Location newLocation = new Location("Medellín", "El Poblado");
        branch.setLocation(newLocation);

        assertEquals("RETIRO", branch.getTypeRequest());
        assertEquals(123, branch.getBranchID());
        assertEquals(now, branch.getCreationRequest());
        assertEquals("Medellín", branch.getLocation().getCity());
        assertEquals("El Poblado", branch.getLocation().getNeighborhood());
    }

    @Test
    void testRandomBranchIdIsDifferentMostTimes() {
        Branch another = new Branch("DEPOSITO", "Cali");
        // No garantizamos unicidad absoluta, pero en la práctica deberían ser diferentes
        assertNotEquals(branch.getBranchID(), another.getBranchID());
    }
}
