package VO;
import java.util.*;

public class CompraVO{
	private int codigo;
	private int quantidade;
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
	}

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

	public void cadastrar(CompraVO compra){
		//Cadastrar a compra no BD para gerar nota fiscal.
	}
	public void deletar(CompraVO compra){
		//Deletar do BD.

	}

	
	public void alterar(CompraVO compra){ 
		codigo = compra.codigo;
		quantidade = compra.quantidade;
		valorTotal = compra.valorTotal;
		data = compra.data;

		//alterar os dados e enviar novamente para o BD
	
	}
	
}
