package page;

import base.BasePage;
import org.openqa.selenium.By;

public class ResumoPage extends BasePage {

    public void excluirMovimentacao(){
        clicar(By.xpath("//span[@class ='glyphicon glyphicon-remove-circle']"));
    }

    public String obterMensagemSucesso(){
        return obterValorPorTexto(By.xpath("//div[@class='alert alert-success']"));
    }
}
