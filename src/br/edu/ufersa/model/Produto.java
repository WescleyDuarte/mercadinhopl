import br.edu.ufersa.model.Tipo;
class Produto{

	int codigo;
	String descricao;
	String marca;
	int quantidade;
	float valor;
	Tipo tipo;
	String setor;

	public void cadastrar(Produto produto){
		// cadastra um produto no BD;
	}

	public void alterar(Produto produto){
		codigo = produto.codigo;
		descricao = produto.descricao;
		marca = produto.marca;
		quantidade = produto.quantidade;
		valor = produto.valor;
		tipo = produto.tipo;
		setor = produto.setor;
	}

	public void deletar(Produto produto){
		// deleta um produto do BD
	}

	public Produto buscar(int codigo){
		// busca o produto que corresponde ao código passado
	}

	public Produto buscar(String marca){
		// busca o produto que corresponde a marca passada
	}
}
