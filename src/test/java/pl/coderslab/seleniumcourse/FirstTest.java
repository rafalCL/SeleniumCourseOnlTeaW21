package pl.coderslab.seleniumcourse;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstTest {
    @Test
    public void firstTest() {
        // given
        int a = 40;
        int b = 2;
        // when
        int actual = a + b;
        // then
        assertEquals(42, actual);
    }
}
