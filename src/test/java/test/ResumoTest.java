package test;

import base.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import page.MenuPage;
import page.ResumoPage;

public class ResumoTest extends BaseTest {

private MenuPage menuPage = new MenuPage();
private ResumoPage page = new ResumoPage();

    @Test
    public void testExcluirMovimentacao(){
        menuPage.acessarTelaResumoMensal();

        page.excluirMovimentacao();
        Assert.assertEquals("Movimentação removida com sucesso!", page.obterMensagemSucesso());
    }


}
