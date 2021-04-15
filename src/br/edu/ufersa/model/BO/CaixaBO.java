package br.edu.ufersa.model.BO;

import java.util.ArrayList;
import java.util.Scanner;

import br.edu.ufersa.model.DAO.*;
import br.edu.ufersa.model.VO.*;

public class CaixaBO {

	static Scanner scanner = new Scanner(System.in);
	CaixaDAO caixaDAO = new CaixaDAO();
	CaixaVO caixa = new CaixaVO();
	ArrayList<CaixaVO> caixas = new ArrayList<CaixaVO>();

    public void cadastrarCaixa(){
		
		System.out.println("Entre com o nome do caixa: ");
		caixa.setNome(scanner.next());;
		System.out.println("Entre com a idade do caixa: ");
		caixa.setIdade(scanner.nextInt());
		System.out.println("Entre com o sexo do caixa: ");
		caixa.setSexo(scanner.next());
		System.out.println("Entre com o salario do caixa: ");
		caixa.setSalario(scanner.nextFloat());

		caixaDAO.cadastrar(caixa);
		caixaDAO.listar();
	}

	public void alterar(String nomeDoCaixa){

		CaixaVO caixaParaAlterar = new CaixaVO();

		CaixaDAO buscador = new CaixaDAO();

		caixaParaAlterar = buscador.buscarCaixa(nomeDoCaixa);

		// fazer o busca tipo do Caixa
		System.out.println(caixaParaAlterar.toString());
		

		System.out.println("\nDigite o novo Nome para o Caixa: ");
		caixaParaAlterar.setNome(scanner.next());
		System.out.println("\nDigite a nova Idade para o Caixa: ");
		caixaParaAlterar.setIdade(scanner.nextInt());
		System.out.println("\nDigite o novo Sexo do Caixa: ");
		caixaParaAlterar.setSexo(scanner.next());
		System.out.println("\nDigite o novo Salario do Caixa: ");
		caixaParaAlterar.setNome(scanner.next());

		caixas = caixaDAO.buscaExcludente(nomeDoCaixa);

		CaixaDAO.cadastrarAuxiliar(caixaParaAlterar);

		for(int i=0;caixas.get(i)!=null;i++){

			caixaDAO.cadastrar(caixas.get(i));
		}
		
	}

	public void deletar(String nomeDoCaixa){

		caixas = caixaDAO.buscaExcludente(nomeDoCaixa);

		
		for(int i= 0;caixas.get(i)!=null;i++){
			
			caixa = caixas.get(i);
			if(i==0){
			CaixaDAO.cadastrarAuxiliar(caixa);
			}else{				
					caixaDAO.cadastrar(caixas.get(i));
				}
			}

		}
	
	// public void buscar (){ //talvez não seja necessário considerar depois
	// 	//Buscar caixa baseado no nome do Caixa
	// 	//Retornar Caixa;	
	// }
}
		

