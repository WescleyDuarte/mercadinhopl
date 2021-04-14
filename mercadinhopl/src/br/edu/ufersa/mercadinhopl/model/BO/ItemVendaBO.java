package mercadinhopl.model.BO;

import java.util.*;
import java.io.*;
import mercadinhopl.model.VO.*;
import mercadinhopl.model.DAO.*;

public class ItemVendaBO {
	
	static Scanner scanner = new Scanner(System.in);
	ItemVendaVO itemVenda = new ItemVendaVO();
	VendaVO venda = new VendaVO();

	//private int codigoTemporario; // receber o codigo do produto para fazer a pesquisa se existe um produto com esse codigo.

    public ItemVendaVO adicionarItemVenda(int codigoVenda, int codigoProduto){
		
		itemVenda.setCodigoVenda(codigoVenda);
		System.out.println("Entre com a quantidade do produto a ser adicionado: ");
		itemVenda.setQuantidade(scanner.nextInt());

		ProdutoVO produto = new ProdutoVO();
		ProdutoDAO produtoDAO = new ProdutoDAO();
		produto = produtoDAO.buscarProdutoPorCodigo(codigoProduto);


		itemVenda.setProduto(produto);

		return itemVenda;
		
		/*
		if (receberProduto != null){

			itemVenda.setProduto(receberProduto);
			itemVendaDAO.cadastrar(itemVenda);
			itemVendaDAO.listar();
		}

		receberVenda = vendaDAO.buscarVenda(itemVenda.getCodigoVenda());
		
		if (receberVenda != null) {
			receberVenda.setItemVenda(itemVenda);
			vendaDAO.cadastrar(receberVenda);
		}
		else {
			VendaBO vendaBO = new VendaBO();
			vendaBO.cadastrarVenda(itemVenda);
		}*/
	}

	public void remover(ItemVendaVO itemVenda){
		// remove um item da venda
	}

	public void alterar(ItemVendaVO itemVenda){
		// altera um item da venda
	}
}
