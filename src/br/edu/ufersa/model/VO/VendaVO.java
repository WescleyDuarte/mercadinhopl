package VO;
import java.util.Calendar;

public class VendaVO{
	
	private int codigo; //int codigoProduto que virá para ser adicionado;
	private int quantidade;	// quantidade total de itens na compra
	private float valorTotal;
	private Calendar data;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		if(codigo > 0) {
			this.codigo = codigo;
		}
		else System.out.println("Codigo invalido!")
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		if(quantidade > 0) {
			this.quantidade = quantidade;
		}
		else System.out.println("Quantidade inválida!");

	public float getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(float valorTotal) {
		if(valorTotal > 0) {
			this.valorTotal = valorTotal;
		}
		else System.out.println("Valor total inválido!");
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		if(data != null) {
			this.data = data;
		}
		else System.out.println("Data invalida!")
	}

	public String toString() {
		String out = "";

		out = out + "\n" + "Código: " + codigo;
		out = out + "\n" + "Quantidade: " + quantidade;
		out = out + "\n" + "Valor Total: " + valorTotal;
		out = out + "\n" + "Data: " + data;
	}

	public void cadastrar(VendaVO venda){
		// cadastra uma venda no BD
	}

	public void alterar(VendaVO venda){
		codigo = venda.codigo;
	      //codigoProduto = venda.codigoProduto;
		quantidade = venda.quantidade;
		valorTotal = venda.valorTotal;
		data = venda.data;
	}

	public VendaVO buscar(int codigo){
		// busca a venda correspondente ao código recebido
	}

	public VendaVO buscar(Calendar data){
		// busca vendas correspondentes a data recebida
	}
}
