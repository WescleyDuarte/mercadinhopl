package br.edu.ufersa.model.BO;

//import java.io.*;
import java.util.*;


import br.edu.ufersa.model.VO.*;
import br.edu.ufersa.model.DAO.*;

public class CompraBO {
	int m;
	static Scanner scanner = new Scanner(System.in);
	CompraVO compra = new CompraVO();
	CompraDAO compraDAO = new CompraDAO();
	ItemCompraBO itemCompra = new ItemCompraBO();
    
    public void cadastrar(){
	
		System.out.println("Entre com o codigo da compra: ");
		compra.setCodigo(scanner.nextInt());;

		while(m != 4) {
			System.out.println("(1)Adicionar item");
			System.out.println("\n(2)Alterar item");
			System.out.println("\n(3)Remover item");
			System.out.println("\n(4)Finalizar");
			m = scanner.nextInt();
			switch (m) {
				case 1:
					compra.setItemCompra(itemCompra.adicionarItemCompra(compra.getCodigo()));
					break;
				case 2:
					compra.setItemCompra(itemCompra.alterarItemCompra(compra.getItemCompra()));
					break;
				case 3:
					compra.setItemCompra(itemCompra.removerItemCompra(compra.getItemCompra()));
					break;
				case 4:
					break;
				default:
					System.out.println("Numero invalido!");
			}
		}
		
		for(int i = 0; i < compra.getItemCompra().size(); i++) {
			compra.setValorTotal(compra.getItemCompra().get(i).getQuantidade() * compra.getItemCompra().get(i).getProduto().getValor());
		}

		Calendar c = Calendar.getInstance();
		compra.setData(c.getTime());
		
		compraDAO.cadastrar(compra);
		System.out.println(compra.toString());
	}
}
