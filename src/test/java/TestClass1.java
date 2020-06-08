import org.testng.annotations.Test;

public class TestClass1 extends BaseTest {

    @Test(groups = {"TEST2"}, invocationCount = 3)
    public void test1() {
        System.out.println(String.format("Gradle test worker is: %s", System.getProperty("org.gradle.test.worker")));
        System.out.println("test 1 is launched");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
