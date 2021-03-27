package VO;
public class UsuarioVO{
	private int id;
	private String login;
	private String senha;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		if(id > 0) {
			this.id = id;
		}
		else System.out.println("ID invalido");
	}

	public String getLogin() {
		return login;
	}

	public void setIdade(String login) {
		if(login != null && login != "") {
			this.login = login;
		}
		else System.out.println("Login inválido!");
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		if(senha != null && senha != "") {
			this.senha = senha;
		}
		else System.out.println("Senha invalido!");
	}

	public String toString() {
		String out = "";

		out = out + "\n" + "id: " + id;
		out = out + "\n" + "Login: " + login;
		out = out + "\n" + "Senha: " + senha;
	}

	public void cadastrar(UsuarioVO usuario){
		//Cadastrar os dados do novo usuario para enviar ao BD.
	}
	public void alterar(UsuarioVO usuario){
		login = usuario.login;
		senha = usuario.senha;
		//salvar alterações no BD
	}
	public void deletar(UsuarioVO usuario){
		//Deletar do BD
	}
}
