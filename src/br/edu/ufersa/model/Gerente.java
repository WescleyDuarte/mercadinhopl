class Gerente{
	String nome;
	int idade;
	String sexo;
	int cpf;

	public void cadastrar(Gerente gerente){
		// cadastra um gerente no BD			
	}

	public void alterar(Gerente gerente){
		nome = gerente.nome;
		idade = gerente.idade;
		sexo = gerente.sexo;
		cpf = gerente.cpf;
	}

	public void deletar(Gerente gerente){
		// deleta um gerente do BO
	}

	public void buscar(String nome){
		// busca o gerente correspondente ao nome recebido
	}

	public void buscar (int cpf){
		// busca o gerente correspondente ao nome recebido
	}
}	
