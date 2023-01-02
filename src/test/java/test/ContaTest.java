package test;

import base.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import page.ContasPage;
import page.MenuPage;

public class ContaTest extends BaseTest {
    MenuPage menuPage = new MenuPage();
    ContasPage contasPage = new ContasPage();
    @Test
    public void testInserirConta(){
        menuPage.acessarTelaInserirConta();

        contasPage.setNome("Conta teste");
        contasPage.salvar();
        Assert.assertEquals("Conta adicionada com sucesso!", contasPage.obterMensagemSucesso());
    }

    @Test
    public void testAlterarConta(){
        menuPage.acessarListasConta();

        contasPage.clicarAlterarConta("Conta teste");

        contasPage.setNome("Conta do Teste Alterada");
        contasPage.salvar();

        Assert.assertEquals("Conta alterada com sucesso!", contasPage.obterMensagemSucesso());
    }

    @Test
    public void testInserirContaMesmoNome(){
        menuPage.acessarTelaInserirConta();

        contasPage.setNome("Conta do Teste Alterada");
        contasPage.salvar();
        Assert.assertEquals("Já existe uma conta com esse nome!", contasPage.obterMensagemErro());
    }
    @Test
    public void removerContaComMovimentacao(){
        menuPage.acessarListasConta();

        contasPage.clicarRemoverConta("Conta do Teste Alterada");
        Assert.assertEquals("Conta em uso na movimentações", contasPage.obterMensagemErro());
    }
}
