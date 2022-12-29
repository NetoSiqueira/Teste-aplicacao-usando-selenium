package page;


import base.BasePage;
import org.openqa.selenium.By;

import static core.DriverFactory.getDriver;

public class LoginPage extends BasePage {
    private final By verificacao =  By.xpath(".//div/a[.='Seu Barriga']");

    public String VerificarTelaInicial(){
        return obterValorPorTexto(verificacao);
    }

    public void acessarTelaInicial(){
        getDriver().get("https://seubarriga.wcaquino.me/login");
    }
    public void setEmail(String email){
        escreve(By.id("email"), email);
    }

    public void setSenha(String senha){
        escreve(By.id("senha"), senha);
    }

    public void entrar(){
        clicar(By.xpath("//button[.='Entrar']"));
    }


}
