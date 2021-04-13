package mercadinhopl.model.VO;

import java.io.Serializable;

public class TipoVO implements Serializable {

	private static final long serialVersionUID = 7L;

	private int codigo;
	private String nome;
	private String formaDeVenda;

	// CONSTRUTORES
	public TipoVO() {
	}

	public TipoVO(int codigo,String nome,String formaDeVenda){
		setCodigo(codigo);
		setNome(nome);
		setFormaDeVenda(formaDeVenda);
	}

	// GETS
	public int getCodigo() {
		return codigo;
	}
	
	public String getnome() {
		return nome;
	}

	public String getFormaDeVenda() {
		return formaDeVenda;
	}

	// SETS
	public void setCodigo(int codigo) {
		if(codigo > 0) {
			this.codigo = codigo;
		}
		else System.out.println("Codigo invalido!");
	}

	public void setNome(String nome) {
		if (nome != null && nome != "") {
			this.nome = nome;
		}
		else System.out.println("Nome invalido!");
	}

	public void setFormaDeVenda(String formaDeVenda) {
		if(formaDeVenda.equalsIgnoreCase("KG") || formaDeVenda.equalsIgnoreCase("Unidade")) {
			this.formaDeVenda = formaDeVenda;
		}
		else System.out.println("Forma de venda invalida!");
	}

	// TOSTRING
	public String toString() {
		String out = "";

		out = out + "\n" + "Codigo: " + codigo;
		out = out + "\n" + "Nome: " + nome;
		out = out + "\n" + "Forma de Venda: " + formaDeVenda;
		return out;
	}
}

