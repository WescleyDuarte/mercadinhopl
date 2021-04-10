package mercadinhopl.model.BO;

import java.io.*;
import java.util.*;
import mercadinhopl.model.VO.*;
import mercadinhopl.model.DAO.*;


public class TipoBO {

    static Scanner scanner = new Scanner(System.in);
	TipoVO tipo = new TipoVO();
	TipoDAO tipoDAO = new TipoDAO();
	ArrayList<TipoVO> tipos = new ArrayList<TipoVO>();

	public void cadastrarTipo(){
			
		System.out.println("\nEntre com um código para o tipo: ");
		tipo.setCodigo(scanner.nextInt());
		System.out.println("\nEntre com um nome para o tipo: ");
		tipo.setNome(scanner.next());
		System.out.println("\nEntre com uma forma de venda para o tipo: ");
		tipo.setFormaDeVenda(scanner.next());

		TipoDAO.cadastrar(tipo);	
	
	}


	public void alterar(String nomeDoTipo){

		TipoVO tipoParaAlterar = new TipoVO();

		TipoDAO buscador = new TipoDAO();

		tipoParaAlterar = buscador.buscarTipo(nomeDoTipo);

		System.out.println(tipoParaAlterar.toString());
		

		System.out.println("\nEntre com um código para o tipo: ");
		tipoParaAlterar.setCodigo(scanner.nextInt());
		System.out.println("\nEntre com um nome para o tipo: ");
		tipoParaAlterar.setNome(scanner.next());
		System.out.println("\nEntre com uma forma de venda para o tipo: ");
		tipoParaAlterar.setFormaDeVenda(scanner.next());

		tipos = tipoDAO.buscaExcludente(nomeDoTipo);

		TipoDAO.cadastrarAuxiliar(tipoParaAlterar);

		for(int i=0;tipos.get(i)!=null;i++){

			TipoDAO.cadastrar(tipos.get(i));
		}
		
	}

	public void deletar(String nomeDoTipo){
		
		tipos = tipoDAO.buscaExcludente(nomeDoTipo);

		
		for(int i=0;tipos.get(i)!=null;i++){
			
			tipo = tipos.get(i);
			if(i==0){
			TipoDAO.cadastrarAuxiliar(tipo);
			}else{				
					TipoDAO.cadastrar(tipos.get(i));
				}
			}

		}


	public void buscar(){
		
		System.out.println("Entre com o nome do tipo a ser buscado: ");

		tipoDAO.buscarTipo(scanner.nextLine());
	}
}
