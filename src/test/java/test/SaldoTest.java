package test;

import base.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import page.HomePage;
import page.MenuPage;

import static core.Propriedades.NOME_CONTA_ALTERADA;

public class SaldoTest extends BaseTest {
private MenuPage menuPage = new MenuPage();
private HomePage page = new HomePage();
    @Test
    public void testSaldoConta(){
        menuPage.acessarTelaPrincipal();
        Assert.assertEquals("1627.00", page.obterSaldoConta(NOME_CONTA_ALTERADA));
    }

}
