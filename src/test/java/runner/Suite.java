package runner;

import base.BaseTest;
import core.Propriedades;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import page.LoginPage;
import test.*;

@RunWith(org.junit.runners.Suite.class)
@org.junit.runners.Suite.SuiteClasses({
      ContaTest.class,
      MovimentacaoTest.class,
        RemoverMovimentacaoContaTest.class,
      SaldoTest.class,
        ResumoTest.class
})
public class Suite{
    private static LoginPage verificacao = new LoginPage();
    @BeforeClass
    public static void inicializa(){
        verificacao.acessarTelaInicial();
        verificacao.setEmail("neto@neto.com");
        verificacao.setSenha("1234");
        verificacao.entrar();
    }

    @AfterClass
    public static void finalizar(){
        Propriedades.FECHAR_BROWSER = true;
    }
}
