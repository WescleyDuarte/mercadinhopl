package mercadinhopl.model.BO;

import java.io.*;
import java.util.*;


import mercadinhopl.model.VO.*;
import mercadinhopl.model.DAO.*;

public class CompraBO {

	static Scanner scanner = new Scanner(System.in);
	CompraVO compra = new CompraVO();
	CompraDAO compraDAO = new CompraDAO();
    
    public void cadastrarCompra(){
		
		System.out.println("Entre com o codigo da compra: ");
		compra.setCodigo(scanner.nextInt());;
		System.out.println("Entre com a quantidade de itens da compra: ");
		compra.setQuantidade(scanner.nextInt());
		System.out.println("Entre com o valor total da compra: ");
		compra.setValorTotal(scanner.nextFloat());
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
