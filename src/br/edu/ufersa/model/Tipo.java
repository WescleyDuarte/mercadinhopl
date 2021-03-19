class Tipo{

	int codigo;
	String nome;
	String formaDeVenda;

	public void cadastrar(Tipo tipo){
		// cadastra um tipo		
	}

	public void alterar(Tipo tipo){
		codigo = tipo.codigo; // altera o codigo do tipo
                nome = tipo.nome; // altera o nome do tipo
                formaDeVenda = tipo.formaDeVenda; // altera a forma de venda do tipo
	}

	void deletar(Tipo tipo){
		// vai deletar um tipo
	}

	public Tipo buscar(String nome){
		// retorna o tipo que corresponde ao nome passado
	}

	public Tipo buscar(int codigo){
		// retorna o tipo que corresponde ao código passado
	}
}	
