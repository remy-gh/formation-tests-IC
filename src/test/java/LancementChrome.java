package test.java;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LancementChrome {

    @Test
    public void testLancementChrome() {
        // récupération du chemin du driver
        String chromeDriverPath = System.setProperty("webdriver.chrome.driver", "c:\\drivers\\chromedriver_86.exe");

        // initialisation du driver
        WebDriver driver = new ChromeDriver();

        // lancement du mode maximisé
        driver.manage().window().maximize();

        // attente de 5 secondes - méthode propre car utilise le wait du navigateur
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // lancement du navigateur sur une URL
        driver.get("http://demo.guru99.com/test/newtours/");

        // attente de 5 secondes - méthode pas propre
/*
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
 */

        // fermeture du navigateur
        driver.quit();
    }
}
