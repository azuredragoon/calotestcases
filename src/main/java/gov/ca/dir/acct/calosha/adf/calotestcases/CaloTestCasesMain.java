package gov.ca.dir.acct.calosha.adf.calotestcases;

import static org.junit.Assert.*;
import org.junit.Before;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.math.BigDecimal;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class CaloTestCasesMain {
    private String inspectionNumber = "210000023";
    private static final String userName = "tpan";
    private static final String password = "welcome2";//"Welcome!1";
    private BigDecimal paymentAmount = new BigDecimal(154);
    private String employerSearchString = "Target";

    private WebDriver driver;
    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver","C:\\Firefox\\geckodriver.exe");

        FirefoxOptions options = new FirefoxOptions();
        options.setBinary("C:\\Firefox\\firefox.exe");

        WebDriver driver = new FirefoxDriver(options);

        String baseUrl = "http://cssoady3/caloshamaster/faces";//"http://cssoady3:7777/caloshamaster/faces";//
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);



        driver.get(baseUrl + "/faces/appLogin.jspx");
        driver.findElement(By.id("pt1:it2::content")).clear();
        driver.findElement(By.id("pt1:it1::content")).sendKeys(userName);
        driver.findElement(By.id("pt1:it2::content")).clear();
        driver.findElement(By.id("pt1:it2::content")).sendKeys(password);
        driver.findElement(By.id("pt1:cb1")).click();


        Wait wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(45))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(Exception.class);
        //assertEquals("CALOSHA Main Screen", driver.getTitle());
    }
}
