package page;

import base.BasePage;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    public String obterSaldoConta(String nome){

         return    obterCelula("Conta", nome, "Saldo","tabelaSaldo").getText();

    }
}
