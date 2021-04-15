package br.edu.ufersa.model.BO;

import java.util.*;
//import java.io.*;
import br.edu.ufersa.model.VO.*;
import br.edu.ufersa.model.DAO.*;

public class VendaBO {
    int m;
	static Scanner scanner = new Scanner(System.in);
	VendaVO venda = new VendaVO();
	VendaDAO vendaDAO = new VendaDAO();
	ItemVendaBO itemVenda = new ItemVendaBO();
	ProdutoVO produto = new ProdutoVO();
	ProdutoDAO produtoDAO = new ProdutoDAO();
    
    public void cadastrar(){
		
		System.out.println("Entre com o codigo da venda: ");
		venda.setCodigo(scanner.nextInt());

		while(m != 4) {
			System.out.println("(1)Adicionar item");
			System.out.println("\n(2)Alterar item");
			System.out.println("\n(3)Remover item");
			System.out.println("\n(4)Finalizar");
			m = scanner.nextInt();
			switch (m) {
				case 1:
					venda.setItemVenda(itemVenda.adicionarItemVenda(venda.getCodigo()));
					break;
				case 2:
					venda.setItemVenda(itemVenda.alterarItemVenda(venda.getItemVenda()));
					break;
				case 3:
					venda.setItemVenda(itemVenda.removerItemVenda(venda.getItemVenda()));
					break;
				case 4:
					break;
				default:
					System.out.println("Numero invalido!");
			}
		}

		System.out.println("Data da operação: ");
		Calendar c = Calendar.getInstance();
		venda.setData(c.getTime());
		
		vendaDAO.cadastrar(venda);

	}
}
