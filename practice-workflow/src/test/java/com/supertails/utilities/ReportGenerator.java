package com.supertails.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ReportGenerator {

    ExtentReports reportInstance;
    ExtentSparkReporter buildReport;

    public ReportGenerator(ExtentReports reportInstance,
                           ExtentSparkReporter buildReport){

        this.reportInstance = reportInstance;
        this.buildReport = buildReport;
        this.reportInstance.attachReporter(buildReport);

    }

    public ExtentTest createTestCase(String testCaseName){

        return reportInstance.createTest(testCaseName);
    }

    public void passTestCase(ExtentTest testCase, String message){

        testCase.pass(message);
    }

    public void failTestCase(ExtentTest testCase,
                             String message, WebDriver driver,
                             String ssName) throws IOException {

        File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourceFile, new File("C:\\Users\\harrish.vijay\\eclipse-workspace\\practice-workflow\\src\\test\\java\\com\\supertails\\resources\\%s.jpg",ssName));

        testCase.fail(message + testCase.addScreenCaptureFromPath("%s.jpg",ssName));
    }
}
