package br.edu.ufersa.mercadoGpp.model.VO;



public class CaixaVO extends UsuarioVO{

	private static final long serialVersionUID = 1L;
	
	private float salario;

	public CaixaVO() {

	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public String toString() {
		String out = "";
		out = out + "\n" + "Salario: " + salario;

		return out;
	}
}
