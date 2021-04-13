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
		if (nome != null && nome != "") {
			this.nome = nome;
		}
		else System.out.println("Nome invalido!");
	}

	public void setIdade(int idade) {
		if(idade > 0) {
			this.idade = idade;
		}
		else System.out.println("Idade inválida!");
	}

	public void setSexo(String sexo) {
		if(sexo.equalsIgnoreCase("Masculino") || sexo.equalsIgnoreCase("Feminino")) {
			this.sexo = sexo;
		}
		else System.out.println("Sexo inválido!");
	}

	public void setCpf(long cpf) {
		if((cpf > 10000000000L) && (cpf < 99999999999L)) {
			this.cpf = cpf;
		}
		else System.out.println("CPF inválido!");
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
