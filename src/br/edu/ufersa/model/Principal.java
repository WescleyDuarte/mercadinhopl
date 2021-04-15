package br.edu.ufersa.model;

import br.edu.ufersa.model.BO.*;

public class Principal {
    public static void main(String[] args) {
        TipoBO tipo = new TipoBO();
        ProdutoBO produto = new ProdutoBO();
        VendaBO venda = new VendaBO();

        tipo.cadastrarTipo();
        produto.cadastrar();
        venda.cadastrar();
    }
}
