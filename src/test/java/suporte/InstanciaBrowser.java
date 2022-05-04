package suporte;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class InstanciaBrowser {

    public static WebDriver createInstanceChrome(){
        System.setProperty("webdriver.chrome.driver", "driversChrome\\chromedriver_navVersion101\\chromedriver.exe");

        WebDriver browser;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        browser = new ChromeDriver(options);

        browser.get("https://www.grocerycrud.com/v1.x/demo/my_boss_is_in_a_hurry/bootstrap");

        return browser;
    }
}
