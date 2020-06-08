package example;

import org.testng.annotations.Test;

public class TestClass3 {

    TestClass3() {
        System.out.println("Instantiate test class 3");
    }

    @Test
    public void test3() {
        System.out.println(String.format("Gradle test worker is: %s", System.getProperty("org.gradle.test.worker")));
        System.out.println(String.format("Thread id is: %s", Thread.currentThread().getId()));
        System.out.println("test 3 is launched");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
