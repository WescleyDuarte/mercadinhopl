package br.edu.ufersa.model.VO;

public class CaixaVO extends UsuarioVO{

	private static final long serialVersionUID = 1L;
	
	private float salario;

	public CaixaVO() {

	}
	public CaixaVO(String nome,String sexo,int idade,int id,String login,String senha,float salario){
		super(nome,sexo,idade,id,login,senha);
		setSalario(salario);
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public String toString() {
		String out = "";
		out = super.toString();
		out = out + "\n" + "Salario: " + salario;

		return out;
	}
}
