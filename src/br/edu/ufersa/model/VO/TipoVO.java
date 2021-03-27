package VO;
public class TipoVO{

	private int codigo;
	private String nome;
	private String formaDeVenda;

	public int getCodigoo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		if(codigo > 0) {
			this.codigo = codigo;
		}
		else System.out.println("Codigo invalido!")
	}
	
	public String getnome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome != null && nome != "") {
			this.nome = nome;
		}
		else System.out.println("Nome invalido!");
	}

	public String getFormaDeVenda() {
		return formaDeVenda;
	}

	public void setFormaDeVenda(String formaDeVenda) {
		if(formaDeVenda.equalsIgnoreCase("KG") || formaDeVenda.equalsIgnoreCase("Unidade")) {
			this.formaDeVenda = formaDeVenda;
		}
		else System.out.println("Forma de venda invalida!");
	}

	public String toString() {
		String out = "";

		out = out + "\n" + "Codigo: " + codigo;
		out = out + "\n" + "Nome: " + nome;
		out = out + "\n" + "Forma de Venda: " + formaDeVenda;
	}


	public void cadastrar(TipoVO tipo){
		// cadastra um tipo		
	}

	public void alterar(TipoVO tipo){
		codigo = tipo.codigo; // altera o codigo do tipo
                nome = tipo.nome; // altera o nome do tipo
                formaDeVenda = tipo.formaDeVenda; // altera a forma de venda do tipo
	}

	void deletar(TipoVO tipo){
		// vai deletar um tipo
	}

	public TipoVO buscar(String nome){
		// retorna o tipo que corresponde ao nome passado
	}

	public TipoVO buscar(int codigo){
		// retorna o tipo que corresponde ao código passado
	}
}	
