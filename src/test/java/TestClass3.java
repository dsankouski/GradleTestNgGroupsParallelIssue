import org.testng.annotations.Test;

public class TestClass3 {

    @Test(groups = {"TEST1"}, invocationCount = 5)
    public void test3() {
        System.out.println(String.format("Gradle test worker is: %s", System.getProperty("org.gradle.test.worker")));
        System.out.println("test 3 is launched");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
