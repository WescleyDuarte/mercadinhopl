package br.edu.ufersa.mercadoGpp.model.BO;

import br.edu.ufersa.mercadoGpp.model.VO.*;

import java.util.ArrayList;
import java.util.Scanner;

import br.edu.ufersa.mercadoGpp.exception.LoginExistsException;
import br.edu.ufersa.mercadoGpp.model.DAO.GerenteDAO;

public class GerenteBO extends UsuarioBO{

	static Scanner scanner = new Scanner(System.in);
	GerenteVO gerente = new GerenteVO();
	GerenteDAO gerenteDAO = new GerenteDAO();
	ArrayList<GerenteVO> gerentes = new ArrayList<GerenteVO>();
    
    public void cadastrarGerente(GerenteVO gerente) throws LoginExistsException{

		try {
			if(gerenteDAO.buscarLoginGerente(gerente.getLogin()) == null) {
				super.cadastrarUsuario(gerente);
				gerenteDAO.cadastrar(gerente);
			}
			
		} catch (Exception e) {
			throw new LoginExistsException();
		}

	}


	public void alterar(String nomeDoGerente){
		GerenteVO gerenteParaAlterar = new GerenteVO();
		
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
