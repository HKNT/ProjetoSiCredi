package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;



public class TemaV4Page extends BasePage {

    public TemaV4Page(WebDriver browser) {
        super(browser);
    }

    //colocando no tema V4
    public V4FormPage alteraTemaParaBootStrapV4(){
        WebElement temas   = browser.findElement(By.cssSelector("#switch-version-select"));
        Select selecaoTema = new Select(temas);

        selecaoTema.selectByIndex(3);
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        return new V4FormPage(browser);
    }
}
