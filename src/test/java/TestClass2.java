import org.testng.annotations.Test;

public class TestClass2 extends BaseTest {

    @Test(groups = {"TEST2"}, invocationCount = 5)
    public void test2() {
        System.out.println(String.format("Gradle test worker is: %s", System.getProperty("org.gradle.test.worker")));
        System.out.println("test 2 is launched");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
