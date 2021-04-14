package br.edu.ufersa.model.BO;

import java.io.*;
import java.util.*;


import br.edu.ufersa.model.VO.*;
import br.edu.ufersa.model.DAO.*;

public class CompraBO {

	static Scanner scanner = new Scanner(System.in);
	CompraVO compra = new CompraVO();
	CompraDAO compraDAO = new CompraDAO();
	ItemCompraDAO itemCompra = new ItemCompraDAO();
    
    public void cadastrar(){
	
		System.out.println("Entre com o codigo da compra: ");
		compra.setCodigo(scanner.nextInt());;

		while(codigoProduto != 4) {
			System.out.println("(1)Adicionar item");
			System.out.println("\n(2)Alterar item");
			System.out.println("\n(3)Remover item");
			System.out.println("\n(4)Finalizar");

			switch (scanner.nextInt()) {
				case 1:
					compra.setItemCompra(compraDAO.adicionarItemCompra(compra.getCodigo()));
					break;
				case 2:
					compra.setItemCompra(compraDAO.alterarItemCompra(compra.getItemCompra()));
					break;
				case 3:
					compra.setItemCompra(compraDAO.removerItemCompra(compra.getItemCompra()));
					break;
				case 4:
					break;
				default:
					System.out.println("Numero invalido!");
			}
		}
		
		System.out.println("Data da operação: ");

		Calendar c = Calendar.getInstance();
		compra.setData(c.getTime());
		System.out.println(c.getTime());
		
		compraDAO.cadastrar(compra);
		compraDAO.listar();

	}
	public void deletar(CompraVO compra){
		//Deletar do BD.

	}

	
	public void alterar(CompraVO compra){ 
		//alterar os dados e enviar novamente para o BD
        
	}
}
