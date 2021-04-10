package mercadinhopl.model.VO;

import java.io.Serializable;

public class CaixaVO implements Serializable{

	private static final long serialVersionUID = 1L;

	private String nome;
	private int idade;
	private String sexo;
	private float salario;

	public CaixaVO() {

	}

	public CaixaVO(String nome, int idade, String sexo, float salario) {
		setNome(nome);
		setIdade(idade);
		setSexo(sexo);
		setSalario(salario);
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

	public float getSalario() {
		return salario;
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
		else System.out.println("Idade invalida!");
	}

	public void setSexo(String sexo) {
		if(sexo.equalsIgnoreCase("Masculino") || sexo.equalsIgnoreCase("Feminino")) {
			this.sexo = sexo;
		}
		else System.out.println("Sexo invalido!");
	}

	public void setSalario(float salario) {
		if(salario > 1000) {
			this.salario = salario;
		}
		else System.out.println("Salário invalido!");
	}

	public String toString() {
		String out = "";

		out = out + "\n" + "Nome: " + nome;
		out = out + "\n" + "Idade: " + idade;
		out = out + "\n" + "Sexo: " + sexo;
		out = out + "\n" + "Salario: " + salario;

		return out;
	}
}
