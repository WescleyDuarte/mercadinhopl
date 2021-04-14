package mercadinhopl.model.VO;
import java.io.Serializable;
import java.util.*;

public class CompraVO implements Serializable{

	static final long serialVersionUID = 2L;

	private int codigo;
	private List<ItemCompraVO> itemCompra;
	private float valorTotal;
	private Calendar data = Calendar.getInstance();

	public CompraVO() {

	}

	public CompraVO(int codigo, ItemCompraVO itemCompra, float valorTotal, Date data) {
		setCodigo(codigo);
		setItemCompra(itemCompra);
		setValorTotal(valorTotal);
		setData(data);
	}

	public int getCodigo() {
		return codigo;
	}

	public List<ItemCompraVO> getItemCompra() {
		return itemCompra;
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

	public void setItemCompra(ItemCompraVO itemCompraNew) {

		if(itemCompraNew != null){
			this.itemCompra.add(itemCompraNew);
		}
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
		out = out + "\n" + "Itens Compra: " + itemCompra.toString();
		out = out + "\n" + "Valor Total: " + valorTotal;
		out = out + "\n" + "Data: " + data.getTime();
		return out;
	}
}
