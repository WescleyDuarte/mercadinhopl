package br.edu.ufersa.model.BO;

import java.util.ArrayList;
import java.util.Scanner;

import br.edu.ufersa.model.DAO.*;
import br.edu.ufersa.model.VO.*;

public class CaixaBO {

	static Scanner scanner = new Scanner(System.in);
	private CaixaDAO caixaDAO = new CaixaDAO();
	private CaixaVO caixa = new CaixaVO();
	private ArrayList<CaixaVO> caixas = new ArrayList<CaixaVO>();
	private int controlador = 0;
	private UsuarioDAO usuarioDAO= new UsuarioDAO();
	private GerenteDAO gerenteDAO = new GerenteDAO();

	//precisa ter uma condição onde ele for cadastrar se a opção for caixa então entra aqui
	//passando o id do usuario
    public void cadastrarCaixa(int id){
		
		if(usuarioDAO.buscarUsuarioPorID(id)!=null && gerenteDAO.buscarGerente(id)==null && caixaDAO.buscarCaixa(id)==null){

			controlador=0;
			while(controlador==0){

				System.out.println("Entre com o Salario do caixa: ");
				caixa.setSalario(scanner.nextFloat());		
				
				if(caixa.getSalario()>1100){
					controlador++;

					caixa.setNome(usuarioDAO.buscarUsuarioPorID(id).getNome());
					caixa.setSexo(usuarioDAO.buscarUsuarioPorID(id).getSexo());
					caixa.setIdade(usuarioDAO.buscarUsuarioPorID(id).getIdade());
					caixa.setId(id);
					caixa.setLogin(usuarioDAO.buscarUsuarioPorID(id).getLogin());
					caixa.setSenha(usuarioDAO.buscarUsuarioPorID(id).getSenha());

					caixaDAO.cadastrar(caixa);
				}
			}
		
		}else{
			System.out.println("\n ID Para relacionar Caixa invalido");
		}
	}


	// ALTERAR E DELETAR É USANDO O ID DO USUARIO QUE O CAIXA HERDA
	public void alterar(int id){

		caixa = caixaDAO.buscarCaixa(id);

		if(caixaDAO.buscarCaixa(id)!=null){
			System.out.println(caixa.toString());

			controlador=0;
			while(controlador==0){
				System.out.println("digite o novo Salario para o Caixa:");
				caixa.setSalario(scanner.nextFloat());

				if(caixa.getSalario()>=1100){

						caixa.setNome(usuarioDAO.buscarUsuarioPorID(id).getNome());
						caixa.setSexo(usuarioDAO.buscarUsuarioPorID(id).getSexo());
						caixa.setIdade(usuarioDAO.buscarUsuarioPorID(id).getIdade());
						caixa.setId(id);
						caixa.setLogin(usuarioDAO.buscarUsuarioPorID(id).getLogin());
						caixa.setSenha(usuarioDAO.buscarUsuarioPorID(id).getSenha());


					caixas = caixaDAO.buscaExcludente(id);

					CaixaDAO.cadastrarAuxiliar(caixa);
					controlador++;
					for(int i=0;caixas.get(i)!=null;i++){

						caixaDAO.cadastrar(caixas.get(i));
					}
				}else{
					System.out.println("\nSalario invalido");
				}

			}
		}else{
			System.out.println("\n não foi possivil alterar o valor do salario do caixa tente novamente (valor>1100)");
		}
		
	}

	public void deletar(int id){

		caixas = caixaDAO.buscaExcludente(id);

		
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
		

