package example;

import org.testng.annotations.Test;

@Test
public class TestClass1 {
    TestClass1() {
        System.out.println("Instantiate test class 1");
    }

    @Test
    public void test1() {
        System.out.printf("Gradle test worker is: %s%n", System.getProperty("org.gradle.test.worker"));
        System.out.println("test 1 is launched");
        System.out.printf("Thread id is: %s%n", Thread.currentThread().getId());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
