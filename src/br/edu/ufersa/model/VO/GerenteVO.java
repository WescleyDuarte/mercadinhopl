package br.edu.ufersa.model.VO;

public class GerenteVO extends UsuarioVO{

	private static final long serialVersionUID = 3L;
	
	private long cpf;

	public GerenteVO() {

	}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
			this.cpf = cpf;
	}

	public String toString() {
		String out = "";

		out = out + "\n" + "CPF: " + cpf;

		return out;
	}
}	
