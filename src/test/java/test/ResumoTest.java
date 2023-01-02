package test;

import base.BaseTest;
import core.DriverFactory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import page.MenuPage;
import page.ResumoPage;

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
    }

}
