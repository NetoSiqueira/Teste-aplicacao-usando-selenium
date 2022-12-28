package core;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static core.DriverFactory.getDriver;

public class BasePage {
    public void escreve(By locator, String texto){
        getDriver().findElement(locator).sendKeys(texto);
    }


    public String obterValor(By locator){
        return  getDriver().findElement(locator).getAttribute("value");
    }

    
    public void clicar(By locator){
        getDriver().findElement(locator).click();
    }
    public boolean verificarBotaoClicado(By locator){
        return getDriver().findElement(locator).isSelected();
    }


    public void selecionarCombo(By locator, String escolaridade){
        WebElement element = getDriver().findElement(locator);
        Select combo = new Select(element);

        combo.selectByVisibleText(escolaridade);
    }

    public String obterValorCombo(By locator){
        WebElement element = getDriver().findElement(locator);
        Select combo = new Select(element);

        return combo.getFirstSelectedOption().getText();
    }

    public void clicarLink(By locator){
        getDriver().findElement(locator).click();
    }

    public String obterValorPorTexto(By locator){
        return getDriver().findElement(locator).getText();
    }

    public void clicarRadio(By locator){
        getDriver().findElement(locator).click();
    }

    public String alertaObterTextoEAceitar(){
        Alert alert = getDriver().switchTo().alert();
        String valor = alert.getText();
        return valor;
    }

    public void clicarBotaoTabela(String colunaBusca, String valorLinha, String colunaBotao){
        //procurar coluna do registro
        WebElement tabela = getDriver().findElement(By.xpath("//table[@id='elementosForm:tableUsuarios']"));
        int idColuna = obterIndiceColuna(colunaBusca,tabela);

        //encontrar a linha do registro
        int idLinha = obterIndiceLinha(valorLinha, tabela, idColuna);

        //procurar coluna botao
        int idColunaBotao = obterIndiceColuna(colunaBotao,tabela);

        //clicar no botao da celula

        WebElement celula = tabela.findElement(By.xpath(".//tr["+idLinha+"]/td["+idColunaBotao+"]"));
        celula.findElement(By.xpath(".//input")).click();
    }

    public  int obterIndiceLinha(String valorLinha, WebElement tabela, int idColuna) {
        List<WebElement> linhas =  tabela.findElements(By.xpath("./tbody/tr/td["+ idColuna +"]"));
        int idlinha = -1;
        for (int i = 0; i < linhas.size(); i++){
            if(linhas.get(i).getText().equals(valorLinha)){
                idlinha = i+1;
                break;
            }
        }
        return idlinha;
    }

    public int obterIndiceColuna(String coluna, WebElement tabela){

        List<WebElement> colunas = tabela.findElements(By.xpath(".//th"));
        int idColuna = -1;
        for (int i = 0; i < colunas.size(); i++){
            if(colunas.get(i).getText().equals(coluna)){
                idColuna = i+1;
                break;
            }
        }
        return idColuna;
    }

    public void selecionaComboPrime(String radical, String valor){
        getDriver().findElement(By.xpath("//*[@id = '"+radical+":option']/../..//span")).click();
        getDriver().findElement(By.xpath("//*[@id = '"+radical+":option_panel']//li[.='"+valor+"']")).click();

    }
}
