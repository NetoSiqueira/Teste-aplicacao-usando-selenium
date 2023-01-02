package test;

import base.BaseTest;
import core.DriverFactory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import page.MenuPage;
import page.ResumoPage;

import java.util.List;

import static core.DriverFactory.getDriver;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ResumoTest extends BaseTest {

private MenuPage menuPage = new MenuPage();
private ResumoPage page = new ResumoPage();

    @Test
    public void test1_ExcluirMovimentacao(){
        menuPage.acessarTelaResumoMensal();

        page.excluirMovimentacao();
        Assert.assertEquals("Movimentação removida com sucesso!", page.obterMensagemSucesso());
    }

    @Test
    public void test2_ResumoMensal(){
        menuPage.acessarTelaResumoMensal();

       Assert.assertEquals("Seu Barriga - Extrato", getDriver().getTitle());
//    try{
//        DriverFactory.getDriver().findElement(By.xpath("//*[@id='tabelaExtrato']/tbody/tr"));
//        Assert.fail();
//    }catch (NoSuchElementException e){
//
//    }

        List<WebElement> elementosEncontrado =
                DriverFactory.getDriver().findElements(By.xpath("//*[@id='tabelaExtrato']/tbody/tr"));

        Assert.assertEquals(0, elementosEncontrado.size());
    }

}
