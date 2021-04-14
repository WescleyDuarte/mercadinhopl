package mercadinhopl.model.VO;
import java.io.*;

public class GerenteVO implements Serializable{

	private static final long serialVersionUID = 3L;
	
	private String nome;
	private int idade;
	private String sexo;
	private long cpf;

	public GerenteVO() {

	}

	public GerenteVO(String nome, int idade, String sexo, long cpf) {
		setNome(nome);
		setIdade(idade);
		setSexo(sexo);
		setCpf(cpf);
	}
	
	public String getNome() {
		return nome;
	}

	public int getIdade() {
		return idade;
	}

	public String getSexo() {
		return sexo;
	}

	public long getCpf() {
		return cpf;
	}

	public void setNome(String nome) {
			this.nome = nome;
	}

	public void setIdade(int idade) {
			this.idade = idade;
	}

	public void setSexo(String sexo) {
			this.sexo = sexo;	
	}

	public void setCpf(long cpf) {
			this.cpf = cpf;
	}

	public String toString() {
		String out = "";

		out = out + "\n" + "Nome: " + nome;
		out = out + "\n" + "Idade: " + idade;
		out = out + "\n" + "Sexo: " + sexo;
		out = out + "\n" + "CPF: " + cpf;

		return out;
	}
}	
