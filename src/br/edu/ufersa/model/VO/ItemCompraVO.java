package mercadinhopl.model.VO;

import java.io.*;

public class ItemCompraVO implements Serializable{

	private static final long serialVersionUID = 4L;

	private int codigoProduto;
	private int codigoCompra;
	private int quantidade;

	public ItemCompraVO() {

	}

	public ItemCompraVO(int codigoProduto, int codigoCompra, int quantidade) {
		setCodigoProtudo(codigoProduto);
		setCodigoCompra(codigoCompra);
		setQuantidade(quantidade);
	}

	public int getCodigoProduto() {
		return codigoProduto;
	}
	
	public int getCodigoCompra() {
		return codigoCompra;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setCodigoProtudo(int codigoProduto) {
		if(codigoProduto > 0) {
			this.codigoProduto = codigoProduto;
		}
		else System.out.println("Codigo do produto invalido!");
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

	public String toString() {
		String out = "";

		out = out + "\n" + "Codigo Produto: " + codigoProduto;
		out = out + "\n" + "Codigo Compra: " + codigoCompra;
		out = out + "\n" + "Quantidade: " + quantidade;
		return out;
	}
}
