package test;

import base.BaseTest;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import page.ContasPage;
import page.MenuPage;
import page.MovimentacaoPage;
import utils.DataUtils;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static core.Propriedades.NOME_CONTA_ALTERADA;
import static utils.DataUtils.obterDataFormatada;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MovimentacaoTest extends BaseTest {
    private MenuPage menuPage = new MenuPage();
    private MovimentacaoPage page = new MovimentacaoPage();
    @Test
    public void test1_InserirMovimentacao(){
        menuPage.acessarTelaInserirMovimentacao();

        page.setDataMovimentacao(obterDataFormatada(new Date()));
        page.setDataPagamento(obterDataFormatada(new Date()));
        page.setDescricao("Pagamento");
        page.setInteressado("Neto");
        page.setValor("1627");
        page.setConta(NOME_CONTA_ALTERADA);
        page.setSituacaoPago();
        page.salvar();

        Assert.assertEquals("Movimentação adicionada com sucesso!", page.obterMensagemSucesso());
    }

    @Test
    public void test2_CamposObrigatorios(){
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
    public void test3_InserirMovimentacaoFutura(){
        menuPage.acessarTelaInserirMovimentacao();

        Date dataFutura = DataUtils.obterDataComDiferencaDias(5);
        page.setDataMovimentacao(obterDataFormatada(dataFutura));
        page.setDataPagamento(obterDataFormatada(dataFutura));
        page.setDescricao("Pagamento");
        page.setInteressado("Neto");
        page.setValor("1627");
        page.setConta(NOME_CONTA_ALTERADA);
        page.setSituacaoPago();
        page.salvar();

        List<String> erros = page.obterErros();
        Assert.assertTrue(erros.contains("Data da Movimentação deve ser menor ou igual à data atual"));
        Assert.assertEquals(1, erros.size());

    }



}
