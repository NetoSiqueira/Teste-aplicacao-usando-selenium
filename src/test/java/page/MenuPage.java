package page;

import base.BasePage;

public class MenuPage extends BasePage {

    public void acessarTelaInserirConta(){
        clicarLink("Contas");
        clicarLink("Adicionar");
    }
    public void acessarListasConta(){
        clicarLink("Contas");
        clicarLink("Listar");
    }

    public void acessarTelaInserirMovimentacao(){
        clicarLink("Criar Movimentação");
    }

    public void acessarTelaResumoMensal(){
        clicarLink("Resumo Mensal");
    }

    public void acessarTelaPrincipal(){
        clicarLink("Home");
    }
}
