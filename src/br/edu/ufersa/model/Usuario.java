class Usuario{
	int id;
	String login;
	String senha;

	public void cadastrar(Usuario usuario){
		//Cadastrar os dados do novo usuario para enviar ao BD.
	}
	public void alterar(Usuario usuario){
		login = usuario.login;
		senha = usuario.senha;
		//salvar alterações no BD
	}
	public void deletar(Usuario usuario){
		//Deletar do BD
	}
}
