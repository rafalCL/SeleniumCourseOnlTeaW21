package pl.coderslab.seleniumcourse.examples;

import org.junit.jupiter.api.*;

public class ExampleTest {
    @Test
    public void test1() {
        System.out.println("test1");
    }

    @Test
    public void test2() {
        System.out.println("test2");
    }

    @Disabled
    @Test
    public void test3() {
        System.out.println("test3");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("run before each test");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("run after each test");
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("run before all tests");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("run after all tests");
    }
}
