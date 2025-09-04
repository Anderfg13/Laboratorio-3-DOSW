package edu.dosw.lab;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocationTest {

    private Location location;

    @BeforeEach
    void setUp() {
        location = new Location();
        location.setCity("Bogotá");
        location.setNeighborhood("Chapinero");
    }

    @Test
    void testGettersReturnCorrectValues() {
        assertEquals("Bogotá", location.getCity());
        assertEquals("Chapinero", location.getNeighborhood());
    }

    @Test
    void testSettersUpdateValuesCorrectly() {
        location.setCity("Medellín");
        location.setNeighborhood("El Poblado");

        assertEquals("Medellín", location.getCity());
        assertEquals("El Poblado", location.getNeighborhood());
    }
}
