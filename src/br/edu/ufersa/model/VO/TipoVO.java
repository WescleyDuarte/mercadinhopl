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
		this.codigo = codigo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setFormaDeVenda(String formaDeVenda) {
		this.formaDeVenda = formaDeVenda;		
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

