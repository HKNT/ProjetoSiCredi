package suporte;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class Print {
    public static void printTela(WebDriver browser, String nomeArq){
        File print = ((TakesScreenshot)browser).getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(print, new File(nomeArq));
        }catch (Exception e){
            System.out.println("Erro ao tentar gerar o arquivo com prints do teste - Classe Print\n"+e.getMessage());
        }
    }
}