package mercadinhopl.model.BO;

import java.util.*;
import java.io.*;
import mercadinhopl.model.VO.*;
import mercadinhopl.model.DAO.*;

public class VendaBO {
    
	static Scanner scanner = new Scanner(System.in);
	VendaVO venda = new VendaVO();
	VendaDAO vendaDAO = new VendaDAO();
	ItemVendaBO itemVenda = new ItemVendaBO();
	ProdutoVO produto = new ProdutoVO();
	ProdutoDAO produtoDAO = new ProdutoDAO();
    
	int codigoProduto;
    public void cadastrarVenda(VendaVO venda){
		
		System.out.println("Entre com o codigo da venda: ");
		venda.setCodigo(scanner.nextInt());

		while(codigoProduto != 0) {
			System.out.println("Digite a codigo do Produto a ser adicionado:");
      		codigoProduto = scanner.nextInt();
			venda.setItemVenda(itemVenda.adicionarItemVenda(venda.getCodigo(), codigoProduto));
		}	

		System.out.println("Data da operação: ");
		Calendar c = Calendar.getInstance();
		venda.setData(c.getTime());
		System.out.println(c.getTime());
		
		vendaDAO.cadastrar(venda);
		vendaDAO.listar();

	}

	public void alterar(VendaVO venda){
		// altera no arquivo
	}

	/*public VendaVO buscar(int codigo){
		// busca a venda correspondente ao código recebido
	}

	public VendaVO buscar(Calendar data){
		// busca vendas correspondentes a data recebida
	}*/
}
