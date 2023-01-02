package test;

import page.LoginPage;
import base.BaseTest;
import org.junit.Assert;
import org.junit.Test;

public class TestVerificacao extends BaseTest {

private LoginPage verificacao = new LoginPage();

    @Test
    public void Verificar(){
       Assert.assertEquals("Seu Barriga", verificacao.VerificarTelaInicial());
    }

}
