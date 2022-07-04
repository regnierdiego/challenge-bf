import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "json:target/MyReports/report.json",
                "junit:target/MyReports/report.xml"
        },
        publish = true,
        features = "src/test/resources/features/",
        tags = "@001"
)
public class RunCucumberTest {
}
