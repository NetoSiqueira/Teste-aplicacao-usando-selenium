package test;

import base.BaseTest;
import core.DriverFactory;
import org.junit.Assert;
import org.junit.Test;
import page.MenuPage;
import page.ResumoPage;

import static core.DriverFactory.getDriver;

public class ResumoTest extends BaseTest {

private MenuPage menuPage = new MenuPage();
private ResumoPage page = new ResumoPage();

    @Test
    public void testExcluirMovimentacao(){
        menuPage.acessarTelaResumoMensal();

        page.excluirMovimentacao();
        Assert.assertEquals("Movimentação removida com sucesso!", page.obterMensagemSucesso());
    }

    @Test
    public void testResumoMensal(){
        menuPage.acessarTelaResumoMensal();

       Assert.assertEquals("Seu Barriga - Extrato", getDriver().getTitle());
    }

}
