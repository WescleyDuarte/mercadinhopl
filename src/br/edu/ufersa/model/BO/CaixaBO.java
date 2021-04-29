package br.edu.ufersa.model.BO;

import br.edu.ufersa.model.DAO.*;
import br.edu.ufersa.model.VO.*;

import java.util.Scanner;
//import java.util.*;
import java.util.ArrayList;
public class CaixaBO extends UsuarioBO{

    static Scanner scanner = new Scanner(System.in);
	private CaixaDAO caixaDAO = new CaixaDAO();
	private CaixaVO caixa = new CaixaVO();
	private ArrayList<CaixaVO> caixas = new ArrayList<CaixaVO>();
	private int controlador = 0;
	//private UsuarioDAO usuarioDAO= new UsuarioDAO();
	private GerenteDAO gerenteDAO = new GerenteDAO();


    @Override
    public void cargo(){
        //Aqui teremos condição para relaização de alteração na nota( ou outra opção mais detalhada) // precisamos da interface grafica  para utilizar melhor
    }


    
	//precisa ter uma condiÃ§Ã£o onde ele for cadastrar se a opÃ§Ã£o for caixa entÃ£o entra aqui
	//passando o id do usuario
    public void cadastrarCaixa(){
	
			controlador=0;
			while(controlador!=7){

				if(controlador==0){
					System.out.println("\nDigite o Salario do Caixa");
					caixa.setSalario(scanner.nextFloat());

					if( caixa.getSalario()> 1100 && caixa.getSalario()!=0){
						controlador++;
					}

				if(controlador==1){
					System.out.println("\nDigite o Nome do caixa");
					caixa.setNome(scanner.next());
				}

					if(caixa.getNome() != null && caixa.getNome()!=""){
					controlador ++;
					}

				if(controlador==2){
						System.out.println("\nDigite o Sexo do caixa");
						caixa.setSexo(scanner.next());

					}

					if(caixa.getSexo().equalsIgnoreCase("Masculino") || caixa.getSexo().equalsIgnoreCase("Feminino")){
                    	controlador++;
                    }

				if(controlador==3){
						System.out.println("\nDigite o Idade do caixa");
						caixa.setIdade(scanner.nextInt());

					}
					if(caixa.getIdade()>0){
						controlador++;
					}

				if(controlador==4){
					System.out.println("\nDigite o ID do caixa");
					caixa.setId(scanner.nextInt());

				}
					if(caixaDAO.buscarCaixa(caixa.getId())==null && caixaDAO.buscarCaixa(caixa.getId())==null && caixa.getId()!=0 && caixa.getId()>0){ 
						controlador++;
					}
				
					// ESTOU EDITANDO AQUI AINDA
				if(controlador==5){
					System.out.println("\nDigite o Login do caixa");
					caixa.setLogin(scanner.next());
	
					}

					//Criar uma Busca de Login No caixa e no gerente
					if(gerenteDAO.buscarLoginGerente(caixa.getLogin())==null && caixaDAO.buscarLoginCaixa(caixa.getLogin())==null &&caixa.getLogin()!=null && caixa.getLogin()!=""){
						controlador++;
					}
				if(controlador==6){
					System.out.println("\nDigite o Senha do caixa");
					caixa.setSenha(scanner.next());
				}
					if(caixa.getSenha()!=null && caixa.getSenha()!=""){
						controlador++;
						caixaDAO.cadastrar(caixa);
					}

				}

				System.out.println("não foi possivel colocar os dados, insira novamente!");
			}
	}


	// ALTERAR E DELETAR Ã‰ USANDO O ID DO USUARIO QUE O CAIXA HERDA
	public void alterar(int id){

		caixa = caixaDAO.buscarCaixa(id);

		if(caixaDAO.buscarCaixa(id)!=null){
			System.out.println(caixa.toString());

			controlador=0;
			if(caixaDAO.buscarCaixa(id)!=null){

				caixa = caixaDAO.buscarCaixa(id);
	
				System.out.println(caixa.toString());
				controlador=0;
				while(controlador!=7){
	
					if(controlador==0){
						System.out.println("\nDigite o Salario do Caixa");
						caixa.setSalario(scanner.nextFloat());
	
						if( caixa.getSalario()> 1100 && caixa.getSalario()!=0){
							controlador++;
						}
					if(controlador==1){
						System.out.println("\nDigite o Nome do caixa");
						caixa.setNome(scanner.next());
					}
	
						if(caixa.getNome() != null && caixa.getNome()!=""){
						controlador ++;
						}
	
					if(controlador==2){
							System.out.println("\nDigite o Sexo do caixa");
							caixa.setSexo(scanner.next());
	
						}
	
						if(caixa.getSexo().equalsIgnoreCase("Masculino") || caixa.getSexo().equalsIgnoreCase("Feminino")){
							controlador++;
						}
	
					if(controlador==3){
							System.out.println("\nDigite o Idade do caixa");
							caixa.setIdade(scanner.nextInt());
	
						}
						if(caixa.getIdade()>0){
							controlador++;
						}
	
					if(controlador==4){
						System.out.println("\nDigite o ID do caixa");
						caixa.setId(scanner.nextInt());
	
					}
						if(caixaDAO.buscarCaixa(caixa.getId())==null && caixaDAO.buscarCaixa(caixa.getId())==null && caixa.getId()!=0 && caixa.getId()>0){ 
							controlador++;
						}
					
					if(controlador==5){
						System.out.println("\nDigite o Login do caixa");
						caixa.setLogin(scanner.next());
		
						}

						if(caixaDAO.buscarLoginCaixa(caixa.getLogin())==null && gerenteDAO.buscarLoginGerente(caixa.getLogin())==null &&caixa.getLogin()!=null && caixa.getLogin()!=""){
							controlador++;
						}
					if(controlador==6){
						System.out.println("\nDigite o Senha do caixa");
						caixa.setSenha(scanner.next());
					}
						if(caixa.getSenha()!=null && caixa.getSenha()!=""){
							controlador++;
						}
					}
	
					System.out.println("não foi possivel colocar os dados, insira novamente!");
				}
				caixas = caixaDAO.buscaExcludente(id);
	
				CaixaDAO.cadastrarAuxiliar(caixa);
	
				for(int i=0; caixas.get(i)!=null;i++){
					caixaDAO.cadastrar(caixas.get(i));
				}
	
			}
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
    
}
