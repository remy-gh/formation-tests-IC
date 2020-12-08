package test.java;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exercice7 {
    WebDriver driver;

    public boolean verifyElementPresent( WebDriver driver, By locator) {
        try{
            driver.findElement(locator);
            return true;
        }
        catch(Exception NoSuchElementException) {
            return false;
        }
    }

    @Before
    public void setUp() {
        // récupération du chemin du driver
        String chromeDriverPath = System.setProperty("webdriver.chrome.driver", "c:\\drivers\\chromedriver_86.exe");

        // initialisation du driver
        driver = new ChromeDriver();

        // lancement du mode maximisé
        driver.manage().window().maximize();
    }

    @Test
    public void valeursAVerifier() {

    }

    @After
    public void tearDown() {
        // fermeture du navigateur
        driver.quit();
    }
}
