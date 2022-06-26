package pl.coderslab.seleniumcourse;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AssertionsTest {
    @Test
    public void shouldBeAnExampleInUsingAssertions() {
        assertEquals(42, 42);
        assertEquals(3.14, 3.14, 0.01);
        assertEquals(true, true, "this will be shown if this assertion fails");
        assertNotEquals(true, false);
        assertTrue(true);
        assertFalse(false);
        Object o = new Object();
        Object o2 = o;
        assertSame(o , o2);
        assertArrayEquals(new int[]{1,2}, new int[]{1,2});
        assertThrows(NullPointerException.class,
                () -> { throw new NullPointerException("example");});
    }
}
