package mercadinhopl.model.BO;

import mercadinhopl.model.VO.*;

import java.util.ArrayList;
import java.util.Scanner;

import mercadinhopl.model.DAO.GerenteDAO;

public class GerenteBO {

	static Scanner scanner = new Scanner(System.in);
	GerenteVO gerente = new GerenteVO();
	GerenteDAO gerenteDAO = new GerenteDAO();
	ArrayList<GerenteVO> gerentes = new ArrayList<GerenteVO>();
    
    public void cadastrarGerente() {

		System.out.println("Entre com o nome do gerente: ");
		gerente.setNome(scanner.next());
		System.out.println("Entre com a idade do gerente: ");
		gerente.setIdade(scanner.nextInt());
		System.out.println("Entre com o sexo do gerente: ");
		gerente.setSexo(scanner.next());
		System.out.println("Entre com o CPF do gerente: ");
		gerente.setCpf(scanner.nextLong());

		gerenteDAO.cadastrar(gerente);
		gerenteDAO.listar();
	}

	public void alterar(String nomeDoGerente){
		GerenteVO gerenteParaAlterar = new GerenteVO();

		GerenteDAO buscador = new GerenteDAO();

		gerenteParaAlterar = buscador.buscarGerente(nomeDoGerente);

		// fazer o busca tipo do Caixa
		System.out.println(gerenteParaAlterar.toString());
		

		System.out.println("\nDigite o novo Nome para o Caixa: ");
		gerenteParaAlterar.setNome(scanner.next());
		System.out.println("\nDigite a nova Idade para o Caixa: ");
		gerenteParaAlterar.setIdade(scanner.nextInt());
		System.out.println("\nDigite o novo Sexo do Caixa: ");
		gerenteParaAlterar.setSexo(scanner.next());
		System.out.println("\nDigite o novo Salario do Caixa: ");
		gerenteParaAlterar.setNome(scanner.next());

		gerentes = gerenteDAO.buscaExcludente(nomeDoGerente);

		GerenteDAO.cadastrarAuxiliar(gerenteParaAlterar);

		for(int i=0; gerentes.get(i)!=null;i++){

			gerenteDAO.cadastrar(gerentes.get(i));
		}
	}

	public void deletar(String nomeDoGerente){
		gerentes = gerenteDAO.buscaExcludente(nomeDoGerente);

		
		for(int i= 0;gerentes.get(i)!=null;i++){
			
			gerente =	gerentes.get(i);
			if(i==0){
			GerenteDAO.cadastrarAuxiliar(gerente);
			}else{				
					gerenteDAO.cadastrar(gerentes.get(i));
				}
			}
	}

	// public void buscar (long cpf){  // estanos vendo se quando for criar as interfaces vamos utilizar
	// 	// busca o gerente correspondente ao nome recebido
	// }
}
