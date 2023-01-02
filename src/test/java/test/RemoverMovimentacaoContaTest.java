package test;

import base.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import page.ContasPage;
import page.MenuPage;

import static core.Propriedades.NOME_CONTA_ALTERADA;

public class RemoverMovimentacaoContaTest extends BaseTest {
    private MenuPage menuPage = new MenuPage();
    private ContasPage contasPage = new ContasPage();
    @Test
    public void removerContaComMovimentacao(){
        menuPage.acessarListasConta();

        contasPage.clicarRemoverConta(NOME_CONTA_ALTERADA);
        Assert.assertEquals("Conta em uso na movimentações", contasPage.obterMensagemErro());
    }
}
