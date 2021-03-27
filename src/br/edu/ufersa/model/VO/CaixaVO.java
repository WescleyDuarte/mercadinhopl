package VO;
public class CaixaVO{
	private String nome;
	private int idade;
	private String sexo;
	private float salario;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome != null && nome != "") {
			this.nome = nome;
		}
		else System.out.println("Nome invalido!");
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		if(idade > 0) {
			this.idade = idade;
		}
		else System.out.println("Idade invalida!");
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		if(sexo.equalsIgnoreCase("Masculino") || sexo.equalsIgnoreCase("Feminino")) {
			this.sexo = sexo;
		}
		else System.out.println("Sexo invalido!");
	}

	public float getSalario() {
		return salario;
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
	}

	public void cadastrar(CaixaVO caixa){
		//Enviar o cadastro do caixa para o BD
	}

	public void alterar(CaixaVO caixa){
		nome = caixa.nome;
		idade = caixa.idade;
		sexo = caixa.sexo;
		salario = caixa.salario;
		//Enviar alterações para o BD
	}
	public void deletar(CaixaVO caixa){
		//Deletar do BD

	}
	public CaixaVO buscar(String nome){
		//Buscar caixa baseado no nome do Caixa
		//Retornar Caixa;	
	}
		

}
