package br.edu.ufersa.model.VO;

public class GerenteVO extends UsuarioVO {

    private static final long serialVersionUID = 3L;
	
	private long cpf;
    
	public GerenteVO() {

	}

	public GerenteVO(String nome,String sexo,int idade,int id,String login,String senha,long cpf){
		super(nome,sexo,idade,id,login,senha);
		setCpf(cpf);
	}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
			this.cpf = cpf;
	}

	public String toString() {
		String out = "";
		out = super.toString();
		out = out + "\n" + "CPF: " + cpf;

		return out;
	}

}
