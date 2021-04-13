package mercadinhopl.model.VO;

import java.io.*;

public class ItemCompraVO implements Serializable{

	private static final long serialVersionUID = 4L;

	private int codigoCompra;
	private float quantidade;
	private ProdutoVO produto;

	public ItemCompraVO() {

	}

	public ItemCompraVO(int codigoProduto, int codigoCompra, int quantidade) {
		setCodigoCompra(codigoCompra);
		setQuantidade(quantidade);
		setProduto(produto);
	}
	
	public int getCodigoCompra() {
		return codigoCompra;
	}

	public float getQuantidade() {
		return quantidade;
	}

	public ProdutoVO getProduto() {
		return produto;
	}

	public void setCodigoCompra(int codigoCompra) {
		if(codigoCompra > 0) {
			this.codigoCompra = codigoCompra;
		}
		else System.out.println("Codigo de compra invalido!");
	}

	public void setQuantidade(int quantidade) {
		if(quantidade > 0) {
			this.quantidade = quantidade;
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

		out = out + "\n" + "Codigo Compra: " + codigoCompra;
		out = out + "\n" + "Quantidade: " + quantidade;
		out = out + "\n" + "Produto: " + produto.getDescricao();
		return out;
	}
}
