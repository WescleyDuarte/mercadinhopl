package br.edu.ufersa.model.VO;

import java.io.Serializable;

public class ProdutoVO implements Serializable{

	private static final long serialVersionUID = 6L;

	private int codigo;
	private String descricao;
	private String marca;
	private float quantidade;
	private float valor;
	private TipoVO tipo;
	private String setor;

	public ProdutoVO(int codigo, String descricao, String marca, float quantidade, float valor, TipoVO tipo, String setor) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.marca = marca;
		this.quantidade = quantidade;
		this.valor = valor;
		this.tipo = tipo;
		this.setor = setor;
	}
	public ProdutoVO(){}

	public int getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getMarca() {
		return marca;
	}

	public float getQuantidade() {
		return quantidade;
	}

	public float getValor() {
		return valor;
	}

	public TipoVO getTipo() {
		return tipo;
	}

	public String getSetor() {
		return setor;
	}

	public void setCodigo(int codigo) {
		if(codigo > 0) {
			this.codigo = codigo;
		}
		else System.out.println("Codigo invalido!");
	}

	public void setDescricao(String descricao) {
		if(descricao != null && descricao != "") {
			this.descricao = descricao;
		}
		else System.out.println("Descricao invalida!");
	}

	public void setMarca(String marca) {
		if(marca != null && marca != "") {
			this.marca = marca;
		}
		else System.out.println("Marca invalida!");
	}

	public void setQuantidade(float quantidade) {
		if(quantidade > 0) {
			this.quantidade = quantidade;
		}
		else System.out.println("Quantidade inválida!");
	}

	public void setValor(float valor) {
		if(valor > 0) {
			this.valor = valor;
		}
		else System.out.println("Valor inválido!");
	}

	public void setTipo(TipoVO tipo) {
		if(tipo != null) {
			this.tipo = tipo;
		}
		else System.out.println("Tipo invalido!");
	}

	public void setSetor(String setor) {
		if(setor != null && setor != "") {
			this.setor = setor;
		}
		else System.out.println("Setor invalido!");
	}

	public String toString() {
		String out = "";

		out = out + "\n" + "Codigo: " + codigo;
		out = out + "\n" + "Descrição: " + descricao;
		out = out + "\n" + "Marca: " + marca;
		out = out + "\n" + "Quantidade em estoque: " + quantidade;
		out = out + "\n" + "Valor: " + valor;
		out = out + "\n" + "Tipo: " + tipo.getnome();
		out = out + "\n" + "Setor: " + setor;

		return out;
	}
}