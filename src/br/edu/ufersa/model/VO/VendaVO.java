package br.edu.ufersa.model.VO;

import java.util.*;
import java.io.*;

public class VendaVO implements Serializable {

	private static final long serialVersionUID = 9L;
	
	private int codigo;
	private List<ItemVendaVO> itemVenda = new ArrayList<ItemVendaVO>();
	private float valorTotal;
	private Calendar data = Calendar.getInstance();

	public VendaVO() {

	}

	public VendaVO(int codigo, List<ItemVendaVO> itemVenda, float valorTotal, Date data) {
		setCodigo(codigo);
		setItemVenda(itemVenda);
		setValorTotal(valorTotal);
		setData(data);
	}

	public int getCodigo() {
		return codigo;
	}

	public List<ItemVendaVO> getItemVenda() {
		return itemVenda;
	}
	
	public float getValorTotal() {
		return valorTotal;
	}

	public Calendar getData() {
		return data;
	}

	public void setCodigo(int newCodigo) {

		if(newCodigo > 0) {
			this.codigo = newCodigo;
		}
		else System.out.println("Codigo invalido!");
	}

	public void setItemVenda(List<ItemVendaVO> itemVendaNew) {
		this.itemVenda.addAll(itemVendaNew);
	}

	//Valor total = quantidade do item + valor base do produto
	public void setValorTotal (float valorDeItemVenda) {

		if((valorDeItemVenda)>0){

			this.valorTotal += valorDeItemVenda;
		
		}else System.out.println("Valor total inválido!");
	}


	public void setData(Date data) {
		if(data != null)
			this.data.setTime(data);
		else System.out.println("Data invalida!");
	}

	public String toString() {
		String out = "";

		out = out + "\n" + "Código de Venda: " + codigo;
		out = out + "\n" + "Item Venda: " + itemVenda.toString();
		out = out + "\n" + "Valor Total: " + valorTotal;
		out = out + "\n" + "Data: " + data.getTime();
		return out;
	}
}
