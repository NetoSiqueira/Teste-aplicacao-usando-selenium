package page;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static core.DriverFactory.getDriver;

public class MovimentacaoPage extends BasePage {

    public void setDataMovimentacao (String data){
        escreve(By.id("data_transacao"), data);
    }

    public void setDataPagamento(String pagammento){
        escreve(By.id("data_pagamento"), pagammento);
    }

    public void setDescricao(String descricao){
        escreve(By.id("descricao"), descricao);
    }

    public void setInteressado(String interessado){
        escreve(By.id("interessado"), interessado);
    }

    public void setValor(String valor){
        escreve(By.id("valor"), valor);
    }

    public void setConta(String conta){
        selecionarCombo(By.id("conta"), conta);
    }
    public void setSituacaoPago(){
        clicarRadio(By.id("status_pago"));
    }
    public void salvar(){
        clicarBotaoPorTexto("Salvar");
    }

    public String obterMensagemSucesso() {
        return obterValorPorTexto(By.xpath("//div[@class='alert alert-success']"));
    }
    public List<String> obterErros(){
      List<WebElement> erros =  getDriver().findElements(By.xpath("//div[@class='alert alert-danger']//li"));
      List<String> retorno = new ArrayList<String>();
        for (WebElement erro: erros) {
            retorno.add(erro.getText());
        }
        return retorno;
    }
}
