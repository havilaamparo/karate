package automacao;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.apache.commons.io.FileUtils;

class AutomacaoTest {

    @Test
    // void testParallel() {
    // Results results = Runner.path("classpath:automacao")
    // //.outputCucumberJson(true)
    // .parallel(5);
    // assertEquals(0, results.getFailCount(), results.getErrorMessages());
    // }

    void testParallel() {
        Results results = Runner.path("classpath:automacao").tags("@cadastrar")
                .outputCucumberJson(true)
                .parallel(5);
        generateReport(results.getReportDir());
        assertTrue(results.getFailCount() == 0, results.getErrorMessages());
    }
    // Estava assim antes
    // void testParallel() {
    // Results results = Runner.path("classpath:automacao").tags("@cadastrar")
    // .parallel(5);
    // assertEquals(0, results.getFailCount(), results.getErrorMessages());
    // }

    public static void generateReport(String karateOutputPath) {
        Collection<File> jsonFiles = FileUtils.listFiles(new File(karateOutputPath), new String[] { "json" }, true);
        List<String> jsonPaths = new ArrayList<>(jsonFiles.size());
        jsonFiles.forEach(file -> jsonPaths.add(file.getAbsolutePath()));
        Configuration config = new Configuration(new File("target"), "demo");
        ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, config);
        reportBuilder.generateReports();
    }

}
