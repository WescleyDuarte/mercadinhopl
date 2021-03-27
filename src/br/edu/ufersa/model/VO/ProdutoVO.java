package VO;
public class ProdutoVO{

	private int codigo;
	private String descricao;
	private String marca;
	private int quantidade;
	private float valor;
	private TipoVO tipo;
	private String setor;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		if(codigo > 0) {
			this.codigo = codigo;
		}
		else System.out.println("Codigo invalido!")
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		if(descricao != null && descricao != "") {
			this.descricao = descricao;
		}
		else System.out.println("Descricao invalida!");
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		if(marca != null && marca != "") {
			this.marca = marca;
		}
		else System.out.println("Marca invalida!");
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		if(quantidade > 0) {
			this.quantidade = quantidade;
		}
		else System.out.println("Quantidade inválida!");

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		if(valor > 0) {
			this.valor = valor;
		}
		else System.out.println("Valor inválido!");
	}

	public TipoVO getTipo() {
		return tipo;
	}

	public void setTipo(TipoVO tipo) {
		if(tipo != null) {
			this.tipo = tipo;
		}
		else System.out.println("Tipo invalido!");
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		if(setor != null && setor != "") {
			this.setor = setor;
		}
		else System.out.println("Setor invalido!");
	}

	public String toString() {
		String out = "";

		out = out + "\n" + "Codigo: " + codigo;
		out = out + "\n" + "Descrição: " + descricao;
		out = out + "\n" + "Marca: " + marca;
		out = out + "\n" + "Quantidade: " + quantidade;
		out = out + "\n" + "Valor: " + valor;
		out = out + "\n" + "Tipo: " + tipo;
		out = out + "\n" + "Setor: " + setor;
	}

	public void cadastrar(ProdutoVO produto){
		// cadastra um produto no BD;
	}

	public void alterar(ProdutoVO produto){
		codigo = produto.codigo;
		descricao = produto.descricao;
		marca = produto.marca;
		quantidade = produto.quantidade;
		valor = produto.valor;
		tipo = produto.tipo;
		setor = produto.setor;
	}

	public void deletar(ProdutoVO produto){
		// deleta um produto do BD
	}

	public ProdutoVO buscar(int codigo){
		// busca o produto que corresponde ao código passado
	}

	public ProdutoVO buscar(String marca){
		// busca o produto que corresponde a marca passada
	}
}
