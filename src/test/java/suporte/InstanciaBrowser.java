package suporte;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


public class InstanciaBrowser {
    //Dados BrowserStack
    public static final String AUTOMATE_USERNAME = "hugotavares_MHPQAw";
    public static final String AUTOMATE_ACCESS_KEY = "NBvD9RFGdnaqxafAfoWv";
    public static final String Url = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public static WebDriver createInstanceChrome(){
        System.setProperty("webdriver.chrome.driver", "driversChrome\\chromedriver_navVersion101\\chromedriver.exe");

        WebDriver browser;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        browser = new ChromeDriver(options);
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        browser.get("https://www.grocerycrud.com/v1.x/demo/my_boss_is_in_a_hurry/bootstrap");

        return browser;
    }

    public static WebDriver createInstanceBrowserStack(){

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("os_version", "10");
        caps.setCapability("resolution", "1280x800");
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "100.0");
        caps.setCapability("os", "Windows");
        caps.setCapability("name", "BStack-[Java] Teste SiCredi"); // test name
        caps.setCapability("build", "BStack Build Number 1"); // CI/CD job or build name

        WebDriver browser = null;

        try{
            browser = new RemoteWebDriver(new URL(Url), caps);
        }catch (MalformedURLException e){
            System.out.println("Erro ao tentar criar a instancia do browserStack (URL):"+e.getMessage());
        }

        assert browser != null;
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        browser.get("https://www.grocerycrud.com/v1.x/demo/my_boss_is_in_a_hurry/bootstrap");

        return browser;
    }
}