package br.edu.ufersa.mercadoGpp.model.BO;


import java.util.*;
//import java.io.*;
import br.edu.ufersa.mercadoGpp.model.VO.*;
import br.edu.ufersa.mercadoGpp.model.DAO.*;

public class VendaBO {
    
	static Scanner scanner = new Scanner(System.in);
	VendaDAO vendaDAO = new VendaDAO();
	
    
    public void cadastrar(VendaVO vendaVO){
		
		Calendar c = Calendar.getInstance();
		vendaVO.setData(c.getTime());
		
		vendaDAO.cadastrar(vendaVO);

	}

	public List<ItemVendaVO> removerItem(List<ItemVendaVO> itens,ItemVendaVO itemRemovido) {

		int index = itemRemovido.indexOf(itemRemovido);
		if(itens.contains(itemRemovido)){
			if(itens.set(itemRemovido.indexOf(itemRemovido), itemRemovido.getQuantidade()));
		}

	}

	int codiguin = 0;
	public int gerarCodigo() {

		Random random = new Random();

		do{
			codiguin = random.nextInt(100);
		}
		while(vendaDAO.buscarVenda(codiguin) != null);

		return codiguin;

	}
}
