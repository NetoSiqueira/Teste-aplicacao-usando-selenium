package base;


import core.BaseTest;
import core.DriverFactory;
import org.openqa.selenium.By;

public class LoginBase extends BaseTest {

    private final By verificacao =  By.xpath(".//div/a[.='Seu Barriga']");

    public String VerificarTelaInicial(){
        return basePage.obterValorPorTexto(verificacao);
    }
}
