package VO;
public class GerenteVO{
	private String nome;
	private int idade;
	private String sexo;
	private long cpf;
	
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
		else System.out.println("Idade inválida!");
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		if(sexo.equalsIgnoreCase("Masculino") || sexo.equalsIgnoreCase("Feminino")) {
			this.sexo = sexo;
		}
		else System.out.println("Sexo inválido!");
	}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		if((cpf > 10000000000) && (cpf < 99999999999)) {
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
	}

	public void cadastrar(GerenteVO gerente){
		// cadastra um gerente no BD			
	}

	public void alterar(GerenteVO gerente){
		nome = gerente.nome;
		idade = gerente.idade;
		sexo = gerente.sexo;
		cpf = gerente.cpf;
	}

	public void deletar(GerenteVO gerente){
		// deleta um gerente do BO
	}

	public GerenteVO buscar(String nome){
		// busca o gerente correspondente ao nome recebido
	}

	public void buscar (long cpf){
		// busca o gerente correspondente ao nome recebido
	}
}	
