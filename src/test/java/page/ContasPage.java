package page;

import base.BasePage;
import org.openqa.selenium.By;

public class ContasPage extends BasePage {
    public void setNome(String nome){
        escreve(By.id("nome"), nome);
    }
    public void salvar(){
        clicarBotaoPorTexto("Salvar");
    }

    public String obterMensagemSucesso(){
        return obterValorPorTexto(By.xpath("//div[@class='alert alert-success']"));
    }

    public String obterMensagemErro(){return obterValorPorTexto(By.xpath("//div[@class='alert alert-danger']"));}
    public void clicarAlterarConta(String valor){
        obterCelula("Conta", valor, "Ações","tabelaContas")
                .findElement(By.xpath(".//span[@class='glyphicon glyphicon-edit']")).click();
    }

    public void clicarRemoverConta(String valor){
        obterCelula("Conta", valor, "Ações","tabelaContas")
                .findElement(By.xpath(".//span[@class='glyphicon glyphicon-remove-circle']")).click();
    }
}
