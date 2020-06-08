package example;

import org.testng.annotations.Test;

public class TestClass2 {
    TestClass2() {
        System.out.println("Instantiate test class 2");
    }

    @Test
    public void test2() {
        System.out.println(String.format("Gradle test worker is: %s", System.getProperty("org.gradle.test.worker")));
        System.out.println(String.format("Thread id is: %s", Thread.currentThread().getId()));
        System.out.println("test 2 is launched");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
