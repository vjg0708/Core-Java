package com.odyssey.utilities;

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
    ExtentSparkReporter loadReport;

    public ReportGenerator(ExtentReports reportInstance,
                           ExtentSparkReporter loadReport){

        this.reportInstance = reportInstance;
        this.loadReport = loadReport;
        reportInstance.attachReporter(loadReport);
    }

    public ExtentTest createTestCase(String name){

        return  reportInstance.createTest(name);
    }

    public void passTestCase(String message, ExtentTest testcase){

        testcase.pass(message);
    }

    public void failTestCase(String message, ExtentTest testcase,
                             WebDriver driver, String path) throws IOException {

        File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourceFile, new File(path));
        testcase.fail(message + path);
    }


}
