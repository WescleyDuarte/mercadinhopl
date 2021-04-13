package mercadinhopl;
import java.io.*;
import java.util.*;
import mercadinhopl.model.BO.*;
import mercadinhopl.model.VO.*;
import mercadinhopl.model.DAO.*;

class Principal{
    public static void main (String args[]) {
        
        Scanner scanner = new Scanner(System.in);
        TipoBO tipo = new TipoBO();
        TipoDAO tipoDAO = new TipoDAO();
        ProdutoBO produto = new ProdutoBO();
		ProdutoDAO produtoDAO = new ProdutoDAO();
        VendaBO venda = new VendaBO();
        VendaDAO vendaDAO = new VendaDAO();

        //VendaVO venda = new VendaVO();
        //VendaBO vendaBO = new VendaBO();
    
        tipo.cadastrarTipo();
        produto.cadastrar();
        venda.cadastrarVenda(venda);

        tipoDAO.listar();
        produtoDAO.listar();
        //System.out.println("Entre com o código do produto a ser alterado: ");
        //int codigo = scanner.nextInt();
        //produto.alterar(codigo);

        // String nome;
       
        // System.out.println("\nEscolha o nome do tipo a ser alterado:\n");
		// nome=(scanner.nextLine());
        // tipo.alterar(nome);
        
        // System.out.println("\n");
        // produtoBO.cadastrar();
        
        // System.out.println("\nEntre com o codigo da venda: ");
		// venda.setCodigo(scanner.nextInt()); // pego o codigo do item venda

        // int codigoTemporario;
        // do {
        //     ItemVendaVO itemVenda = new ItemVendaVO(); // o item venda precisa ser criado dentro do laço (estava sendo criado fora) então era como se adicionasse o msm
        //     System.out.println("\nDigite a codigo do Produto (0 para sair):");
        //     codigoTemporario = scanner.nextInt();
        //     if(codigoTemporario != 0) {
        //         produto = produtoDAO.buscarProdutoPorCodigo(codigoTemporario);
        //         itemVenda.setProduto(produto);

        //         System.out.println("\nEntre com a quantidade do produto a ser adicionado: ");
        //         itemVenda.setQuantidade(scanner.nextFloat());
            
        //         itemVenda.setCodigoVenda(venda.getCodigo());; // seto aqui o codigo da venda pra ser igual ao do item da venda 
        //         venda.setItemVenda(itemVenda);
		//         venda.setValorTotal(itemVenda.getProduto().getValor() * itemVenda.getQuantidade());
        //         System.out.println("\n");
        //     }
        // } while (codigoTemporario != 0);

		// System.out.println("\nData da operação: ");
		// Calendar c = Calendar.getInstance();
		// venda.setData(c.getTime());
        // System.out.println(c.getTime());

        // vendaBO.cadastrarVenda(venda);
        // // VendaDAO vendaDAO = new VendaDAO();
        // // vendaDAO.listar();
         scanner.close();
    }
}