package VO;
public class ItemCompraVO{
	private int codigoProduto;
	private int codigoCompra;
	private int quantidade;

	public int getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProtudo(int codigoProduto) {
		if(codigoProduto > 0) {
			this.codigoProduto = codigoProduto;
		}
		else System.out.println("Codigo do produto invalido!");
	}
	
	public int getCodigoCompra() {
		return codigoCompra;
	}

	public void setCodigoCompra(int codigoCompra) {
		if(codigoCompra > 0) {
			this.codigoCompra = codigoCompra;
		}
		else System.out.println("Codigo de compra invalido!");
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		if(quantidade > 0) {
			this.quantidade = quantidade;
		}
		else System.out.println("Quantidade inválida!");


	public String toString() {
		String out = "";

		out = out + "\n" + "Codigo Produto: " + codigoProduto;
		out = out + "\n" + "Codigo Compra: " + codigoCompra;
		out = out + "\n" + "Quantidade: " + quantidade;
	}

	public void adicionar(ItemCompraVO itemCompra){
		//adicionar o item na compra
	}
	public void alterar(ItemCompraVO itemCompra){
		codigoProduto = itemCompra.codigoProduto;
		codigoCompra = itemCompra.codigoCompra;
		quantidade = itemCompra.quantidade;
	}
	public void remover(ItemCompraVO itemCompra){
		//remove um item da quantidade.
	}

}
