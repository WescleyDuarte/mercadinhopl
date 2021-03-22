class Caixa{
	String nome;
	int idade;
	String sexo;
	float salario;

	public void cadastrar(Caixa caixa){
		//Enviar o cadastro do caixa para o BD
	}

	public void alterar(Caixa caixa){
		nome = caixa.nome;
		idade = caixa.idade;
		sexo = caixa.sexo;
		salario = caixa.salario;
		//Enviar alterações para o BD
	}
	public void deletar(Caixa caixa){
		//Deletar do BD

	}
	public Caixa buscar(String nome){
		//Buscar caixa baseado no nome do Caixa
		//Retornar Caixa;	
	}
		

}
