import org.testng.annotations.BeforeSuite;

public class BaseTest {

    @BeforeSuite
    protected void beforeSuite() {
        System.out.println("Before suite");
    }
}
