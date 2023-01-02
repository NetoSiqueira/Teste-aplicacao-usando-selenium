package test;

import base.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import page.ContasPage;
import page.MenuPage;
import page.MovimentacaoPage;
import utils.DataUtils;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static utils.DataUtils.obterDataFormatada;

public class MovimentacaoTest extends BaseTest {
    private MenuPage menuPage = new MenuPage();
    private MovimentacaoPage page = new MovimentacaoPage();
    @Test
    public void testInserirMovimentacao(){
        menuPage.acessarTelaInserirMovimentacao();

        page.setDataMovimentacao("01/01/2023");
        page.setDataPagamento("02/01/2023");
        page.setDescricao("Pagamento");
        page.setInteressado("Neto");
        page.setValor("1627");
        page.setConta("Conta do Teste Alterada");
        page.setSituacaoPago();
        page.salvar();

        Assert.assertEquals("Movimentação adicionada com sucesso!", page.obterMensagemSucesso());
    }

    @Test
    public void testCamposObrigatorios(){
        menuPage.acessarTelaInserirMovimentacao();

        page.salvar();
        List<String> erros = page.obterErros();
//      Forma amarrada de verificar
//        Assert.assertEquals("Data da Movimentação é obrigatório", erros.get(0));
//        Assert.assertTrue(erros.contains("Data da Movimentação é obrigatório"));
        Assert.assertTrue(erros.containsAll(Arrays.asList(
                "Data da Movimentação é obrigatório",
                "Data do pagamento é obrigatório",
                "Descrição é obrigatório",
                "Interessado é obrigatório",
                "Valor é obrigatório",
                "Valor deve ser um número"
        )));
        Assert.assertEquals(6, erros.size());
    }

    @Test
    public void testInserirMovimentacaoFutura(){
        menuPage.acessarTelaInserirMovimentacao();

        Date dataFutura = DataUtils.obterDataComDiferencaDias(5);
        page.setDataMovimentacao(obterDataFormatada(dataFutura));
        page.setDataPagamento(obterDataFormatada(dataFutura));
        page.setDescricao("Pagamento");
        page.setInteressado("Neto");
        page.setValor("1627");
        page.setConta("Conta do Teste Alterada");
        page.setSituacaoPago();
        page.salvar();

        List<String> erros = page.obterErros();
        Assert.assertTrue(erros.contains("Data da Movimentação deve ser menor ou igual à data atual"));
        Assert.assertEquals(1, erros.size());

    }
    

}