package br.edu.ufersa.model.VO;


public class UsuarioVO extends PessoaVO {

	private static final long serialVersionUID = 8L;

	private int id;
	private String login;
	private String senha;

	// CONSTRUTORES
	public UsuarioVO() {

	}

	public UsuarioVO(int id, String login, String senha) {
		setId(id);
		setLogin(login);
		setSenha(senha);
	}

	// GETS
	public int getId() {
		return id;
	}

	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}

	// SETS
	public void setId(int id) {
			this.id = id;
	}

	public void setLogin(String login) {
			this.login = login;
	}

	public void setSenha(String senha) {
			this.senha = senha;
	}

	// TOSTRING
	public String toString() {
		String out = "";

		out = out + "\n" + "id: " + id;
		out = out + "\n" + "Login: " + login;
		out = out + "\n" + "Senha: " + senha;
		return out;
	}
}
