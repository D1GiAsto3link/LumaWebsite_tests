package Reporting;


import Org.Luma.Runner.Testx1;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentHtmlReporter {
  static WebDriver driver = Testx1.driver;

    public static ExtentTest test;
    public static ExtentReports extent;
    public static ExtentSparkReporter spark;
    public static String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    public static String FileReporter ="C:\\Users\\Digi_WS\\IdeaProjects\\LumaDrive\\src\\test\\java\\Org\\Luma\\Extentweb\\Reporters_" +timeStamp +".html";
    /*ExtentHtmlReporter htmlReporter =  new
            ExtentHtmlReporter(System.getProperty("C:\\Users\\Digi_WS\\IdeaProjects\\LumaDrive\\src\\test\\java\\Org\\Luma\\Reporters")
            +"/Reporters/extentReport.html");*/


        public static void initReports() {
            extent = new ExtentReports();
            spark = new ExtentSparkReporter(FileReporter);
            extent.attachReporter(spark);
            spark.config().setTheme(Theme.DARK);
            spark.config().setDocumentTitle(" Luma Automation Report");
            spark.config().setReportName("Extent Reports");
            driver = Testx1.driver;
        }

    public static String getScreenshot(String testCaseName) throws IOException {
        File source = ((TakesScreenshot) Testx1.driver).getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String fileName = "image_" + testCaseName + "_" + timestamp + ".png";
        String path = System.getProperty("user.dir") + "src/test/java/Org/Luma/Reporters" + fileName;
        FileUtils.copyFile(source, new File(path));
        return path;
    }


    public static ExtentTest createTest(String testcasename) {
        test = extent.createTest(testcasename);
        return test;
    }


    public static void flushReports() throws IOException {
        extent.flush();
        Desktop.getDesktop().browse(new File(FileReporter).toURI());
    }

}
