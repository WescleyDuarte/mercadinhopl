package mercadinhopl.model.BO;
import mercadinhopl.model.DAO.ProdutoDAO;
import mercadinhopl.model.DAO.TipoDAO;
import mercadinhopl.model.VO.ProdutoVO;
import mercadinhopl.model.VO.TipoVO;

import java.util.ArrayList;
import java.util.Scanner;


public class ProdutoBO {

    static Scanner scanner = new Scanner(System.in);
    
    ProdutoVO produto = new ProdutoVO();
    ProdutoDAO produtoDAO = new ProdutoDAO();
    ArrayList<ProdutoVO> produtos = new ArrayList<ProdutoVO>();
    private String nTipo; //auxiliar para receber o nome do tipo.
    
    public void cadastrar() {

        System.out.println("\nDigite o codigo do produto:");
		produto.setCodigo(scanner.nextInt());

		System.out.println("\nDigite a descricao:");
        produto.setDescricao(scanner.next());

        System.out.println("\nDigite a marca:");
        produto.setMarca(scanner.next());

	    System.out.println("\nDigite a quantidade de estoque do produto:");
        produto.setQuantidade(scanner.nextInt());

        System.out.println("\nDigite o preço unitario ou Kg:");
        produto.setValor(scanner.nextFloat());

        //Aqui vc recebe o nome do tipo que vc quer, ele vai fazer a pesquisa se existe.
        System.out.println("\nDigite o nome do tipo:");
		nTipo= scanner.next();
        TipoVO receberTipo = new TipoVO();

        TipoDAO tNew = new TipoDAO();

        receberTipo = tNew.buscarTipo(nTipo); // rever isso dos tipos diferentes.

        System.out.println("\nDigite o setor:");
        produto.setSetor(scanner.next());

    if (receberTipo != null){
        produto.setTipo(receberTipo);
        ProdutoDAO.cadastrar(produto);
    }
    }

    public void alterar(int codigo) {

        ProdutoVO produtoAlterar = new ProdutoVO();
		ProdutoDAO search = new ProdutoDAO();
        TipoBO tipo = new TipoBO();

		produtoAlterar = search.buscarProdutoPorCodigo(codigo);
		System.out.println(produtoAlterar.toString());

		System.out.println("\nEntre com o novo código para o produto: ");
		produtoAlterar.setCodigo(scanner.nextInt());
		System.out.println("\nEntre com a nova descrição para o produto: ");
		produtoAlterar.setDescricao(scanner.next());
		System.out.println("\nEntre com uma nova marca para o produto: ");
		produtoAlterar.setMarca(scanner.next());
        System.out.println("\nEntre com uma nova quantidade para o produto: ");
        produtoAlterar.setQuantidade(scanner.nextFloat());
        System.out.println("\nEntre com um valor novo para o produto: ");
        produtoAlterar.setValor(scanner.nextFloat());
        System.out.println("\nEntre com um novo tipo para o produto: ");
        produtoAlterar.setTipo(tipo.buscar(scanner.next()));
        System.out.println("\nEntre com um novo setor para o produto: ");
        produtoAlterar.setSetor(scanner.next());

		produtos = produtoDAO.buscaExcludente(codigo);

		ProdutoDAO.cadastrarAuxiliar(produtoAlterar);

		for(int i = 0; produtos.get(i) != null; i++){

			ProdutoDAO.cadastrar(produtos.get(i));
		}
    }

    public void deletar(ProdutoVO produto) {
        // deleta um produto do arquivo
    }

    public ProdutoVO buscar(int codigo) {
        return null;
        // busca o produto que corresponde ao código passado
    }

    public ProdutoVO buscar(String marca){
        return null;
		// busca o produto que corresponde a marca passada
	}
}
