package teste;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.TemaV4Page;
import suporte.InstanciaBrowser;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "dadosCadastrais.csv")
public class TestCadastroDados {
    private WebDriver browser;

    @Before
    public void setUp(){
        browser = InstanciaBrowser.createInstanceChrome();
    }

    @Test
    public void testePreencherFormFull (){
        String name            = "Teste Sicredi";
        String lastName        = "Teste";
        String firstName       = "seu nome";
        String phone           = "51 9999-9999";
        String address1        = "Av Assis Brasil, 3970";
        String address2        = "Torre D";
        String city            = "Porto Alegre";
        String state           = "RS";
        String postalCode      = "91000-000";
        String country         = "Brasil";
        String employeerNumber = "001";
        String creditLimit     = "200";
      new TemaV4Page(browser).alteraTemaParaBootStrapV4().clicarBotaoAddRecord()
              .preencherFullForm(name,lastName,firstName,phone,address1,address2,
                      city,state,postalCode,country,employeerNumber,creditLimit)
              .clicarBotaoSave().validaMensagemSave();
    }

    @Test
    public void testePreencherFormFullComCsv (@Param(name="name")String nameET,
                                              @Param(name="lastName")String lastNameET,
                                              @Param(name="firstName")String firstNameET,
                                              @Param(name="phone")String phoneET,
                                              @Param(name="address1")String address1ET,
                                              @Param(name="address2")String address2ET,
                                              @Param(name="city")String cityET,
                                              @Param(name="state")String stateET,
                                              @Param(name="postalCode")String postalCodeET,
                                              @Param(name="country")String countryET,
                                              @Param(name="employeerNumber")String employeerNumberET,
                                              @Param(name="creditLimit")String creditLimitET){

        new TemaV4Page(browser).alteraTemaParaBootStrapV4().clicarBotaoAddRecord()
                .preencherFullForm(nameET,lastNameET,firstNameET,phoneET,address1ET,address2ET,
                        cityET,stateET,postalCodeET,countryET,employeerNumberET,creditLimitET)
                .clicarBotaoSave().validaMensagemSave();
    }

    @After
    public void tearDown(){
        browser.quit();
    }
}