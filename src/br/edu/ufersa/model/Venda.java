import br.edu.ufersa.model.Produto;
import java.util.Calendar;

class Venda{
	
	int codigo;
      //int codigoProduto que virá para ser adicionado;
	int quantidade;	// quantidade total de itens na compra
	float valorTotal;
	Calendar data;

	public void cadastrar(Venda venda){
		// cadastra uma venda no BD
	}

	public void alterar(Venda venda){
		codigo = venda.codigo;
	      //codigoProduto = venda.codigoProduto;
		quantidade = venda.quantidade;
		valorTotal = venda.valorTotal;
		data = venda.data;
	}

	public Venda buscar(int codigo){
		// busca a venda correspondente ao código recebido
	}

	public Venda buscar(Calendar data){
		// busca vendas correspondentes a data recebida
	}
}
