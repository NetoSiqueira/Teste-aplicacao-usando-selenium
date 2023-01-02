package test;

import base.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import page.HomePage;

public class SaldoTest extends BaseTest {

private HomePage page = new HomePage();
    @Test
    public void testSaldoConta(){
        Assert.assertEquals("1627.00", page.obterSaldoConta("Conta do Teste Alterada"));
    }

}
