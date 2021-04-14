package br.edu.ufersa.model.BO;

import br.edu.ufersa.model.VO.*;
import br.edu.ufersa.model.DAO.*;
//import java.io.*;
import java.util.*;

public class ItemCompraBO {
    
	static Scanner scanner = new Scanner(System.in);
	List<ItemCompraVO> itensCompra = new ArrayList<ItemCompraVO>();
	ItemCompraVO itemCompra = new ItemCompraVO();
	ItemCompraDAO itemCompraDAO = new ItemCompraDAO();
	ProdutoDAO produto = new ProdutoDAO();
	CompraDAO compra = new CompraDAO();

    public List<ItemCompraVO> adicionarItemCompra(int codigo){
		int controlador = 0;
		int m;
		itemCompra.setCodigoCompra(codigo);
		while(controlador == 0) {
			System.out.println("Entre com o código do produto a ser adicionado a compra: ");
			m = scanner.nextInt();
			if(produto.buscarProdutoPorCodigo(m) != null) {
				itemCompra.setProduto(produto.buscarProdutoPorCodigo(m));
				controlador++;
			}
			else System.out.println("Produto inválido!\n");
		}

		while(controlador == 1) {
			System.out.println("Entre com a quantidade do produto a ser adicionado: ");
			itemCompra.setQuantidade(scanner.nextFloat());

			if(itemCompra.getQuantidade() > 0) controlador++;
			else System.out.println("Quantidade inválida!");
		}
		itensCompra.add(itemCompra);
		return itensCompra;
	}
	public List<ItemCompraVO> alterarItemCompra(List<ItemCompraVO> itensCompra){
		System.out.println(Arrays.toString(itensCompra.toArray()));

		System.out.println("Digite o código do item a ser alterado: ");
		itemCompra = itemCompraDAO.buscarItemCompra(scanner.nextInt());
		itensCompra.remove(itemCompra);

		System.out.println("Código do produto: " + itemCompra.getProduto().getCodigo());
		System.out.println("\nDigite a nova quantidade de itens: ");
		itemCompra.setQuantidade(scanner.nextInt());
		itensCompra.add(itemCompra);
		return itensCompra;
	}
	public List<ItemCompraVO> removerItemCompra(List<ItemCompraVO> itensCompra){
		System.out.println(Arrays.toString(itensCompra.toArray()));
		
		System.out.println("Digite o código do item a ser removido: ");
		itemCompra = itemCompraDAO.buscarItemCompra(scanner.nextInt());
		itensCompra.remove(itemCompra);
		return itensCompra;
	}
}
