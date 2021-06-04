package br.edu.ufersa.mercadoGpp.model.VO;

import java.io.*;

public class ItemVendaVO implements Serializable {

	private static final long serialVersionUID = 5L;

	private float quantidade;
	private ProdutoVO produto;

	public ItemVendaVO() {

	}

	public ItemVendaVO(int quantidade, ProdutoVO produto) {

		setQuantidade(quantidade);
		setProduto(produto);
	}

	public float getQuantidade() {
		return quantidade;
	}

	public ProdutoVO getProduto(){
		return produto;

	}

	public void setQuantidade(float quantidadeNew) {
		if(quantidadeNew > 0) {
			this.quantidade = quantidadeNew;
		}
		else System.out.println("Quantidade inválida!");
	}

	public void setProduto(ProdutoVO produto) {
		if(produto != null) {
			
			this.produto = produto;
		}
		else System.out.println("Produto invalido!");
	}


	public String toString() {
		String out = "";

		out = out + "\n" + "Quantidade: " + quantidade;
		out = out + "\n" + "Produto: " + produto;

		return out;
	}
}
