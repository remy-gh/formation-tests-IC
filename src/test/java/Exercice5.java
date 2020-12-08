package test.java;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exercice5 {
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
        // navigation vers la page d'accueil
        driver.get("http://localhost:51/servlets/com.mercurytours.servlet.WelcomeServlet");

        assertEquals("Welcome: Mercury Tours", driver.getTitle());

        // saisie du champs login
        driver.findElement(By.name("userName")).click();
        driver.findElement(By.name("userName")).sendKeys("great.cthulhu");

        // saisie du champs password
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys("password");

        // click sur le bouton login
        driver.findElement(By.name("login")).click();

        assertEquals("Find a Flight: Mercury Tours:", driver.getTitle());

        // exercice 6
        assertTrue(verifyElementPresent(driver, By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[1]/td/font/font/b/font/font")));


        // click sur le bouton signoff
        driver.findElement(By.linkText("SIGN-OFF")).click();

        assertEquals("Sign-on: Mercury Tours", driver.getTitle());
    }

    @After
    public void tearDown() {
        // fermeture du navigateur
        driver.quit();
    }
}
