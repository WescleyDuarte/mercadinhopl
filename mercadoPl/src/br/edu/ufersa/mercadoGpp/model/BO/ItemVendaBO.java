package br.edu.ufersa.mercadoGpp.model.BO;

import java.util.*;
//import java.io.*;
import br.edu.ufersa.mercadoGpp.model.VO.*;
import br.edu.ufersa.mercadoGpp.model.DAO.*;

public class ItemVendaBO {
	
	static Scanner scanner = new Scanner(System.in);
	List<ItemVendaVO> itensVenda = new ArrayList<ItemVendaVO>();
	ItemVendaVO itemVenda = new ItemVendaVO();
	ItemVendaDAO itemVendaDAO = new ItemVendaDAO();
	ProdutoDAO produto = new ProdutoDAO();
	VendaDAO venda = new VendaDAO();

    public List<ItemVendaVO> adicionarItemVenda(ItemVendaVO item) {
				
		itensVenda.add(item);
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

	public List<ItemVendaVO> removerItemVenda(ItemVendaVO itemRemovido){
		
		itemVenda = itemVendaDAO.buscarItemVenda(scanner.nextInt());
		itensVenda.remove(itemVenda);
		return itensVenda;
	}
}
