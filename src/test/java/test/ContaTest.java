package test;

import base.BaseTest;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import page.ContasPage;
import page.MenuPage;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContaTest extends BaseTest {
    MenuPage menuPage = new MenuPage();
    ContasPage contasPage = new ContasPage();
    @Test
    public void test1_InserirConta(){
        menuPage.acessarTelaInserirConta();

        contasPage.setNome("Conta teste");
        contasPage.salvar();
        Assert.assertEquals("Conta adicionada com sucesso!", contasPage.obterMensagemSucesso());
    }

    @Test
    public void test2_AlterarConta(){
        menuPage.acessarListasConta();

        contasPage.clicarAlterarConta("Conta teste");

        contasPage.setNome("Conta do Teste Alterada");
        contasPage.salvar();

        Assert.assertEquals("Conta alterada com sucesso!", contasPage.obterMensagemSucesso());
    }

    @Test
    public void test3_InserirContaMesmoNome(){
        menuPage.acessarTelaInserirConta();

        contasPage.setNome("Conta do Teste Alterada");
        contasPage.salvar();
        Assert.assertEquals("Já existe uma conta com esse nome!", contasPage.obterMensagemErro());
    }

}
