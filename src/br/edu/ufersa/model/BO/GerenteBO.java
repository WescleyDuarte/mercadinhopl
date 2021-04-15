package br.edu.ufersa.model.BO;

import br.edu.ufersa.model.VO.*;

import java.util.ArrayList;
import java.util.Scanner;

import br.edu.ufersa.model.DAO.CaixaDAO;
import br.edu.ufersa.model.DAO.GerenteDAO;
import br.edu.ufersa.model.DAO.UsuarioDAO;

public class GerenteBO {

	static Scanner scanner = new Scanner(System.in);
	private GerenteVO gerente = new GerenteVO();
	private	GerenteDAO gerenteDAO = new GerenteDAO();
	private ArrayList<GerenteVO> gerentes = new ArrayList<GerenteVO>();
    private int controlador;
	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	private CaixaDAO caixaDAO = new CaixaDAO();



    public void cadastrarGerente(int id) { //melhorar o tratamento futuramento com as outras opções de polimofismo

		if(usuarioDAO.buscarUsuarioPorID(id)!=null && gerenteDAO.buscarGerente(id)==null && caixaDAO.buscarCaixa(id)==null ){
			
			controlador=0;
			while(controlador==0){

				System.out.println("\nDigite o CPF do caixa");
				gerente.setCpf(scanner.nextInt());

				if( gerente.getCpf()> 10000000000L && gerente.getCpf() < 99999999999L){
					controlador++;
					
					gerente.setNome(usuarioDAO.buscarUsuarioPorID(id).getNome());
					gerente.setSexo(usuarioDAO.buscarUsuarioPorID(id).getSexo());
					gerente.setIdade(usuarioDAO.buscarUsuarioPorID(id).getIdade());
					gerente.setId(id);
					gerente.setLogin(usuarioDAO.buscarUsuarioPorID(id).getLogin());
					gerente.setSenha(usuarioDAO.buscarUsuarioPorID(id).getSenha());
					
					
					gerenteDAO.cadastrar(gerente);


				}
			}
		}
			
	}


	public void alterar(int id){
		
		if(gerenteDAO.buscarGerente(id)!=null){

			gerente = gerenteDAO.buscarGerente(id);

			System.out.println(gerente.toString());
			controlador=0;
			while(controlador==0){
				System.out.println("\nDigite o novo CPF do Gerente: ");
				gerente.setCpf(scanner.nextInt());

				if( gerente.getCpf()> 10000000000L && gerente.getCpf() < 99999999999L){

					gerente.setNome(usuarioDAO.buscarUsuarioPorID(id).getNome());
					gerente.setSexo(usuarioDAO.buscarUsuarioPorID(id).getSexo());
					gerente.setIdade(usuarioDAO.buscarUsuarioPorID(id).getIdade());
					gerente.setId(id);
					gerente.setLogin(usuarioDAO.buscarUsuarioPorID(id).getLogin());
					gerente.setSenha(usuarioDAO.buscarUsuarioPorID(id).getSenha());

					gerentes = gerenteDAO.buscaExcludente(id);

					GerenteDAO.cadastrarAuxiliar(gerente);
					controlador++;
					for(int i=0; gerentes.get(i)!=null;i++){

						gerenteDAO.cadastrar(gerentes.get(i));
					}
				}else{
					System.out.println("\n Cpf invalido");
				}
			}
		}else{
			System.out.println("\n não foi possivel alterar ou gerente não existe");
		}
	}

	public void deletar(int id){
		gerentes = gerenteDAO.buscaExcludente(id);

		
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
