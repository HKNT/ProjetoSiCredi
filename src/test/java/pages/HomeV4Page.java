package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;



public class HomeV4Page extends BasePage {

    public HomeV4Page(WebDriver browser) {
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

    public HomeV4Page buscaNome(String name){
        WebElement textField = browser.findElement(By.cssSelector("#gcrud-search-form > div.scroll-if-required > table > thead > tr.filter-row.gc-search-row > td:nth-child(3) > input"));
        textField.sendKeys(name);
        textField.sendKeys(Keys.ENTER);
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return this;
    }

    public HomeV4Page marcarCheckBoxGeral(){
        browser.findElement(By.cssSelector("#gcrud-search-form > div.scroll-if-required > table > thead > tr.filter-row.gc-search-row > td.no-border-right > div > input")).click();
        return this;
    }

    public HomeV4Page clicarDelete(){
        try{
            browser.findElement(By.cssSelector("#gcrud-search-form > div.scroll-if-required > table > thead > tr.filter-row.gc-search-row > td.no-border-left > div.floatL > a > span")).click();
            Thread.sleep(2000);
        }catch (Exception e){
            System.out.println("Erro ao clicar no botão delete da HomeV4Page: "+e.getMessage());
        }
        return this;
    }

    public HomeV4Page validarMensagemConfirmacaoDeletePopUp(){
        String msg = browser.findElement(By.cssSelector("body > div.container-fluid.gc-container > div.row > div.delete-multiple-confirmation.modal.fade.in.show > div > div > div.modal-body > p.alert-delete-multiple")).getText();
        Assert.assertTrue(msg.contains("Are you sure that you want to delete those"));
        return this;
    }

    public HomeV4Page clicarDeletePopUp(){
        try{
            browser.findElement(By.cssSelector("body > div.container-fluid.gc-container > div.row > div.delete-multiple-confirmation.modal.fade.in.show > div > div > div.modal-footer > button.btn.btn-danger.delete-multiple-confirmation-button")).click();
            Thread.sleep(1000);
        }catch (Exception e){
            System.out.println("Erro ao tentar clicar no botão Delete no PopUp da HomeV4Page: "+e.getMessage());
        }
        return this;
    }

    public void validarMensagemDeleteConfirmado(){
        String msg = browser.findElement(By.cssSelector("body > div.alert.alert-success.growl-animated.animated.bounceInDown > span:nth-child(4) > p")).getText();
        Assert.assertEquals("Your data has been successfully deleted from the database.", msg);
    }
}
