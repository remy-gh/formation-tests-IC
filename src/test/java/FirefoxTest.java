package test.java;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxTest {

    @Test
    public void startFirefoxDriver() {
        // récupération du chemin du driver
        String geckoDriverPath = System.setProperty("webdriver.gecko.driver", "c:\\drivers\\geckodriver.exe");

        // initialisation du driver
        WebDriver driver = new FirefoxDriver();

        // lancement du navigateur sur une URL
        driver.get("https://www.google.fr");

        // fermeture du navigateur
        driver.quit();
    }
}
