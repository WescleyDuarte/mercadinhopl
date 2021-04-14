package mercadinhopl.model.VO;

import java.io.*;

public class UsuarioVO implements Serializable {

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
		if(id > 0) {
			this.id = id;
		}
		else System.out.println("ID invalido");
	}

	public void setLogin(String login) {
		if(login != null && login != "") {
			this.login = login;
		}
		else System.out.println("Login inválido!");
	}

	public void setSenha(String senha) {
		if(senha != null && senha != "") {
			this.senha = senha;
		}
		else System.out.println("Senha invalido!");
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
