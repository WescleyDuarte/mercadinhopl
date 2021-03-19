class Compra{
	int codigo;
	int quantidade;
	float valorTotal;
	Date data;

	public void cadastrar(Compra compra){
		//Cadastrar a compra no BD para gerar nota fiscal.
	}
	public void deletar(Compra comp){
		//Deletar do BD.

	}

	
	public void alterar(Compra compra){ 
		codigo = compra.codigo;
		quantidade = compra.quantidade;
		valorTotal = compra.valorTotal;
		data = compra.data;

		//alterar os dados e enviar novamente para o BD
	
	}
	
}
