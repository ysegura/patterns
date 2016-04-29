package model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class LocationImplTest {

    private Location sut;

    private Location sut2;

    @Before
    public void setUp() {
        sut = new LocationImpl("Test Location");
        sut2 = new LocationImpl();
    }

    @Test
    public void shouldGetLocation() {
        assertEquals("Test Location", sut.getLocation());
    }

    @Test
    public void shouldSetLocation() {
        sut2.setLocation("Test Location2");
        assertEquals("Test Location2", sut2.getLocation());
    }

    @Test
    public void shouldReturnSameString() {
        assertEquals("Test Location", sut.toString());
    }
}
