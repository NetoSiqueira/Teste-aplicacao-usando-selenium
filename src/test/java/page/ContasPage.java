package page;

import base.BasePage;
import org.openqa.selenium.By;

public class ContasPage extends BasePage {
    public void adicionarContas(String nome){
        escreve(By.id("nome"), nome);
    }
    public void salvar(){
        clicar(By.xpath("//button[.='Salvar']"));
    }

    public String obterMensagemSucesso(){
        return obterValorPorTexto(By.xpath("//div[@class='alert alert-success']"));
    }
}
