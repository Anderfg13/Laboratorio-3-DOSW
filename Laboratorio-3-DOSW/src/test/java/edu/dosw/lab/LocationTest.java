package edu.dosw.lab;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocationTest {

    private Location location;

    @BeforeEach
    void setUp() {
        location = new Location("Bogotá", "Chapinero");
    }

    @Test
    void testLocationCreation() {
        assertEquals("Bogotá", location.getCity());
        assertEquals("Chapinero", location.getNeighborhood());
    }

    @Test
    void testSettersAndGetters() {
        location.setCity("Medellín");
        location.setNeighborhood("El Poblado");

        assertEquals("Medellín", location.getCity());
        assertEquals("El Poblado", location.getNeighborhood());
    }

    @Test
    void testDifferentObjectsNotEqual() {
        Location another = new Location("Cali", "San Antonio");

        // Son objetos distintos aunque tengan diferentes datos
        assertNotEquals(location, another);

        // Pero sus atributos sí son correctos
        assertEquals("Cali", another.getCity());
        assertEquals("San Antonio", another.getNeighborhood());
    }
}
