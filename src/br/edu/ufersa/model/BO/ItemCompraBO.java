package mercadinhopl.model.BO;

import mercadinhopl.model.VO.*;
import mercadinhopl.model.DAO.*;
import java.io.*;
import java.util.Scanner;

public class ItemCompraBO {
    
	static Scanner scanner = new Scanner(System.in);
	ItemCompraVO itemCompra = new ItemCompraVO();
	ItemCompraDAO itemCompraDAO = new ItemCompraDAO();

    public void adicionarItemCompra(){
		
		System.out.println("Entre com o código do produto a ser adicionado a compra: ");
		itemCompra.setCodigoProtudo(scanner.nextInt());
		System.out.println("Entre com o código da compra: ");
		itemCompra.setCodigoCompra(scanner.nextInt());
		System.out.println("Entre com a quantidade do produto a ser adicionado: ");
		itemCompra.setQuantidade(scanner.nextInt());

		itemCompraDAO.cadastrar(itemCompra);
		itemCompraDAO.listar();
	}
	public void alterar(ItemCompraVO itemCompra){
		// altera um item da compra
	}
	public void remover(ItemCompraVO itemCompra){
		//remove um item da quantidade.
	}
}
