package br.edu.ufersa.model.VO;

import java.io.*;

public class ItemVendaVO implements Serializable {

	private static final long serialVersionUID = 5L;

	
	private int codigoVenda; // codigo da venda final
	private float quantidade;
	private ProdutoVO produto;

	public ItemVendaVO() {

	}

	public ItemVendaVO(int codigoVenda, int quantidade, ProdutoVO produto) {

		setCodigoVenda(codigoVenda);
		setQuantidade(quantidade);
		setProduto(produto);
	}

	public int getCodigoVenda() {
		return codigoVenda;
	}

	public float getQuantidade() {
		return quantidade;
	}

	public ProdutoVO getProduto(){
		return produto;

	}


	public void setCodigoVenda(int codigoVenda) {
		if(codigoVenda > 0) {
			this.codigoVenda = codigoVenda;
		}
		else System.out.println("Codigo de venda invalido!");
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

		out = out + "\n" + "Codigo Venda: " + codigoVenda;
		out = out + "\n" + "Quantidade: " + quantidade;
		out = out + "\n" + "Produto: " + produto;

		return out;
	}
}
