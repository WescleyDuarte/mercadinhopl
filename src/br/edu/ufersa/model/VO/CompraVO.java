package mercadinhopl.model.VO;
import java.io.Serializable;
import java.util.*;

public class CompraVO implements Serializable{

	static final long serialVersionUID = 2L;

	private int codigo;
	private int quantidade;
	private float valorTotal;
	private Calendar data = Calendar.getInstance();

	public CompraVO() {

	}

	public CompraVO(int codigo, int quantidade, float valorTotal, Date data) {
		setCodigo(codigo);
		setQuantidade(quantidade);
		setValorTotal(valorTotal);
		setData(data);
	}

	public int getCodigo() {
		return codigo;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public float getValorTotal() {
		return valorTotal;
	}

	public Calendar getData() {
		return data;
	}

	public void setCodigo(int codigo) {
		if(codigo > 0) {
			this.codigo = codigo;
		}
		else System.out.println("Codigo invalido!");
	}

	public void setQuantidade(int quantidade) {
		if(quantidade > 0) {
			this.quantidade = quantidade;
		}
		else System.out.println("Quantidade inválida!");
	}

	public void setValorTotal(float valorTotal) {
		if(valorTotal > 0) {
			this.valorTotal = valorTotal;
		}
		else System.out.println("Valor total inválido!");
	}

	public void setData(Date data) {
		if(data != null)
			this.data.setTime(data);
		else System.out.println("Data inválida!");
	}

	public String toString() {
		String out = "";

		out = out + "\n" + "Código: " + codigo;
		out = out + "\n" + "Quantidade: " + quantidade;
		out = out + "\n" + "Valor Total: " + valorTotal;
		out = out + "\n" + "Data: " + data.getTime();
		return out;
	}
}
