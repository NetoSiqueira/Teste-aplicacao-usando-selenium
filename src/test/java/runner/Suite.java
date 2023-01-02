package runner;

import org.junit.runner.RunWith;
import test.*;

@RunWith(org.junit.runners.Suite.class)
@org.junit.runners.Suite.SuiteClasses({
      ContaTest.class,
      MovimentacaoTest.class,
        RemoverMovimentacaoContaTest.class,
      SaldoTest.class,
        ResumoTest.class
})
public class Suite {
}
