package test;

import base.LoginBase;
import core.BaseTest;
import org.junit.Assert;
import org.junit.Test;

public class TestVerificacao extends BaseTest {
    private LoginBase verificacao = new LoginBase();

    @Test
    public void Verificar(){
       Assert.assertEquals("Seu Barriga", verificacao.VerificarTelaInicial());
    }

}
