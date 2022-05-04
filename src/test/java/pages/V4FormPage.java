package pages;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import suporte.GetTimeStamp;
import suporte.Print;

public class V4FormPage extends BasePage {
    @Rule
    public TestName tn = new TestName();

    public V4FormPage(WebDriver browser) {
        super(browser);
    }

    public V4FormPage clicarBotaoAddRecord(){
        browser.findElement(By.cssSelector("#gcrud-search-form > div.header-tools > div.floatL.t5 > a")).click();
        return this;
    }

    public V4FormPage preencherName(String name){
        browser.findElement(By.id("field-customerName")).sendKeys(name);
        return this;
    }

    public V4FormPage preencherLastName(String lastName){
        browser.findElement(By.id("field-contactLastName")).sendKeys(lastName);
        return this;
    }

    public V4FormPage preencherFirstName(String firstName){
        browser.findElement(By.id("field-contactFirstName")).sendKeys(firstName);
        return this;
    }

    public V4FormPage preencherPhone(String phone){
        browser.findElement(By.id("field-phone")).sendKeys(phone);
        return this;
    }

    public V4FormPage preencherAddressLine1(String addressLine){
        browser.findElement(By.id("field-addressLine1")).sendKeys(addressLine);
        return this;
    }

    public V4FormPage preencherAddressLine2(String addressLine){
        browser.findElement(By.id("field-addressLine2")).sendKeys(addressLine);
        return this;
    }

    public V4FormPage preencherCity(String city){
        browser.findElement(By.id("field-city")).sendKeys(city);
        return this;
    }

    public V4FormPage preencherState(String state){
        browser.findElement(By.id("field-state")).sendKeys(state);
        return this;
    }

    public V4FormPage preencherPostalCode(String postalCode){
        browser.findElement(By.id("field-postalCode")).sendKeys(postalCode);
        return this;
    }

    public V4FormPage preencherCountry(String country){
        browser.findElement(By.id("field-country")).sendKeys(country);
        return this;
    }

    //só aceita inteiro ou double
    public V4FormPage preencherSalesRepEmployeeNumber(String EmployeeNumber){
        browser.findElement(By.id("field-salesRepEmployeeNumber")).sendKeys(EmployeeNumber);
        return this;
    }

    public V4FormPage preencherCreditLimit(String CreditLimit){
        browser.findElement(By.id("field-creditLimit")).sendKeys(CreditLimit);
        return this;
    }

    public V4FormPage clicarBotaoSave(){
        try {
            browser.findElement(By.id("form-button-save")).click();
            Thread.sleep(1200);
            return this;
        }catch (Exception e){
            System.out.println("Erro ao tentar salvar: \n"+e.getMessage());
        }
        return null;
    }

    public V4FormPage validaMensagemSave(){
        String msm = browser.findElement(By.id("report-success")).getText();
        Assert.assertEquals("Your data has been successfully stored into the database. Edit Record or Go back to list", msm);
        criarEvidenciaMensagemSave();
        return this;
    }

    public V4FormPage preencherFullForm(String name, String lastName, String firstName, String phone, String address1, String address2, String city, String state,
                                        String postalCode, String country, String employeeNumber, String creditLimit){
        preencherName(name);
        preencherLastName(lastName);
        preencherFirstName(firstName);
        preencherPhone(phone);
        preencherAddressLine1(address1);
        preencherAddressLine2(address2);
        preencherCity(city);
        preencherState(state);
        preencherPostalCode(postalCode);
        preencherCountry(country);
        preencherSalesRepEmployeeNumber(employeeNumber);
        preencherCreditLimit(creditLimit);

        //criar evidencia dos campos preenchidos
        criarEvidenciaFormPreenchido();
        return this;
    }

    //=====================Evidencias
    public void criarEvidenciaFormPreenchido(){
        Print.printTela(browser,"reports\\imgs"+ GetTimeStamp.dataHora() + tn.getMethodName() + ".png");
    }

    public void criarEvidenciaMensagemSave(){
        Print.printTela(browser,"reports\\imgs"+ GetTimeStamp.dataHora() + tn.getMethodName() + ".png");
    }

}