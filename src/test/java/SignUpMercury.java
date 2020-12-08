package test.java;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SignUpMercury {
    WebDriver driver;

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
    public void registerAccount() throws InterruptedException {
        // lancement du navigateur sur une URL
        driver.get("http://localhost:51/servlets/com.mercurytours.servlet.WelcomeServlet");

        // click sur REGISTER pour charger le formulaire
        driver.findElement(By.linkText("REGISTER")).click();

        // saisie des champs du formulaire de création de compte
        driver.findElement(By.name("firstName")).sendKeys("Great");
        driver.findElement(By.name("lastName")).sendKeys("Cthulhu");
        driver.findElement(By.name("phone")).sendKeys("0123456789");
        driver.findElement(By.name("email")).sendKeys("cthulhu@greatoldones.com");
        driver.findElement(By.name("address1")).sendKeys("42 rue des cultistes");
        driver.findElement(By.name("address2")).sendKeys("");
        driver.findElement(By.name("city")).sendKeys("R'lyeh");
        driver.findElement(By.name("state")).sendKeys("Pacific");
        driver.findElement(By.name("postalCode")).sendKeys("66666");
        driver.findElement(By.name("country")).sendKeys("215");
        driver.findElement(By.name("userName")).sendKeys("great.cthulhu");
        driver.findElement(By.name("password")).sendKeys("password");
        driver.findElement(By.name("confirmPassword")).sendKeys("password");

        // click pour envoyer le formulaire
        driver.findElement(By.name("register")).click();


        // attente de 5 secondes - méthode pas propre

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        // attente de 5 secondes - méthode propre car utilise le wait du navigateur
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        // fermeture du navigateur
        driver.quit();
    }
}
