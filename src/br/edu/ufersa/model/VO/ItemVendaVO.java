package VO;

public class ItemVendaVO{
	private int codigoProduto; // codigo do produto a ser vendido
	private int codigoVenda; // codigo da venda final
	private int quantidade;
	private String formaDeVenda; // KG ou Unidade

	public int getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProtudo(int codigoProduto) {
		if(codigoProduto > 0) {
			this.codigoProduto = codigoProduto;
		}
		else System.out.println("Codigo do produto invalido!");
	}

	public int getCodigoVenda() {
		return codigoVenda;
	}

	public void setCodigoVenda(int codigoVenda) {
		if(codigoVenda > 0) {
			this.codigoVenda = codigoVenda;
		}
		else System.out.println("Codigo de venda invalido!");
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		if(quantidade > 0) {
			this.quantidade = quantidade;
		}
		else System.out.println("Quantidade inválida!");

	public String getFormaDeVenda() {
		return formaDeVenda;
	}

	public void setFormaDeVenda(String formaDeVenda) {
		if(formaDeVenda.equalsIgnoreCase("KG") || formaDeVenda.equalsIgnoreCase("Unidade")) {
			this.formaDeVenda = formaDeVenda;
		}
		else System.out.println("Forma de venda invalida!");
	}

	public String toString() {
		String out = "";

		out = out + "\n" + "Codigo Produto: " + codigoProduto;
		out = out + "\n" + "Codigo Venda: " + codigoVenda;
		out = out + "\n" + "Quantidade: " + quantidade;
		out = out + "\n" + "Forma de Venda: " + formaDeVenda;
	}

	public void adicionar(ItemVendaVO itemVenda){
		// adiciona um item na venda
	}

	public void remover(ItemVendaVO itemVenda){
		// remove um item da venda
	}

	public void alterar(ItemVendaVO itemVenda){
		// altera um item da venda
	}
}
