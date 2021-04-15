package br.edu.ufersa.model.BO;

//import java.io.*;
import java.util.*;
import br.edu.ufersa.model.VO.*;
import br.edu.ufersa.model.DAO.*;


public class TipoBO {

    static Scanner scanner = new Scanner(System.in);
	TipoVO tipo = new TipoVO();
	TipoDAO tipoDAO = new TipoDAO();
	ArrayList<TipoVO> tipos = new ArrayList<TipoVO>();

	public void cadastrarTipo(){

		int cod;
		String nome;
		String formaDeVenda;

		int controlador = 0;

		while(controlador==0){
			
			System.out.println("\nEntre com um código para o tipo: ");
			cod = (scanner.nextInt());
			if(cod>0 && tipoDAO.buscarTipoPorCod(cod)== null){
				tipo.setCodigo(cod);
				controlador++;
			}
			while(controlador ==1){
				System.out.println("\nEntre com um nome para o tipo: ");
				nome=(scanner.next());
				if(tipoDAO.buscarTipo(nome)==null &&  nome != null && nome !=""){
					tipo.setNome(nome);
					controlador++;
				}
				while(controlador == 2){
					System.out.println("\nEntre com uma forma de venda para o tipo: ");
					formaDeVenda=(scanner.next());
					if(formaDeVenda.equalsIgnoreCase("KG") || formaDeVenda.equalsIgnoreCase("Unidade")){
						tipo.setFormaDeVenda(formaDeVenda);
						TipoDAO.cadastrar(tipo);
						controlador++;
					}
				}
			}
		}
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


	public TipoVO buscar(String nomeTipo){
		
		return tipoDAO.buscarTipo(nomeTipo);
	}
}
