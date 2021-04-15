package br.edu.ufersa.model.BO;

import java.util.*;
//import java.io.*;
import br.edu.ufersa.model.VO.*;
import br.edu.ufersa.model.DAO.*;

public class ItemVendaBO {
	
	static Scanner scanner = new Scanner(System.in);
	List<ItemVendaVO> itensVenda = new ArrayList<ItemVendaVO>();
	ItemVendaVO itemVenda = new ItemVendaVO();
	ItemVendaDAO itemVendaDAO = new ItemVendaDAO();
	ProdutoDAO produto = new ProdutoDAO();
	VendaDAO venda = new VendaDAO();

    public List<ItemVendaVO> adicionarItemVenda(int codigo) {
		
		int controlador = 0;
		int m;
		itemVenda.setCodigoVenda(codigo);
		while(controlador == 0) {
			System.out.println("Entre com o código do produto a ser adicionado a venda: ");
			m = scanner.nextInt();
			if(produto.buscarProdutoPorCodigo(m) != null) {
				itemVenda.setProduto(produto.buscarProdutoPorCodigo(m));
				controlador++;
			}
			else System.out.println("Produto inválido!\n");
		}

		while(controlador == 1) {
			System.out.println("Entre com a quantidade do produto a ser adicionado: ");
			itemVenda.setQuantidade(scanner.nextFloat());

			if(itemVenda.getQuantidade() > 0) controlador++;
			else System.out.println("Quantidade inválida!");
		}
		itensVenda.add(itemVenda);
		return itensVenda;
	}

	public List<ItemVendaVO> alterarItemVenda(List<ItemVendaVO> itensVenda){
		System.out.println(Arrays.toString(itensVenda.toArray()));

		System.out.println("Digite o código do item a ser alterado: ");
		itemVenda = itemVendaDAO.buscarItemVenda(scanner.nextInt());
		itensVenda.remove(itemVenda);

		System.out.println("Código do produto: " + itemVenda.getProduto().getCodigo());
		System.out.println("\nDigite a nova quantidade de itens: ");
		itemVenda.setQuantidade(scanner.nextInt());
		itensVenda.add(itemVenda);
		return itensVenda;
	}

	public List<ItemVendaVO> removerItemVenda(List<ItemVendaVO> itensVenda){
		System.out.println(Arrays.toString(itensVenda.toArray()));
		
		System.out.println("Digite o código do item a ser removido: ");
		itemVenda = itemVendaDAO.buscarItemVenda(scanner.nextInt());
		itensVenda.remove(itemVenda);
		return itensVenda;
	}
}
