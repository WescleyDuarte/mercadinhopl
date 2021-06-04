package br.edu.ufersa.mercadoGpp.model.BO;

//import java.io.*;
import java.util.*;

import javax.swing.JOptionPane;

import br.edu.ufersa.mercadoGpp.model.VO.*;
import br.edu.ufersa.mercadoGpp.model.DAO.*;


public class TipoBO {

    static Scanner scanner = new Scanner(System.in);
	TipoVO tipo = new TipoVO();
	TipoDAO tipoDAO = new TipoDAO();
	ArrayList<TipoVO> tipos = new ArrayList<TipoVO>();



	int codiguin = 0;

	public int gerarCodigo() {

		Random random = new Random();

		do{
			codiguin = random.nextInt(100);
		}
		while(tipoDAO.buscarTipoPorCod(codiguin) != null);

		return codiguin;

	}
	int controlador = 0;
	public void cadastrarTipo(TipoVO tipoVO){

	//criar um try catch.??
	
	
	if(tipoDAO.buscarTipo(tipoVO.getnome())==null && tipoVO.getnome()!="" ){
		tipo.setNome(tipoVO.getnome());
		controlador++;
		}

	if(tipoVO.getFormaDeVenda().equalsIgnoreCase("KG") || tipoVO.getFormaDeVenda().equalsIgnoreCase("Unidade")){
		tipo.setFormaDeVenda(tipoVO.getFormaDeVenda());
		controlador++;
		}
	if(controlador==2){
		TipoDAO.cadastrar(tipo);
		JOptionPane.showMessageDialog(null, "Tipo Cadastrado com sucesso");

	}else{
		JOptionPane.showMessageDialog(null, "Algum dado esta incorreto tente novamente");
	}

	}

	// Arrumar o Alterar
	public void alterar(TipoVO tipoVO){

		tipo.setCodigo(tipoVO.getCodigo());
		if((tipoVO.getFormaDeVenda().equalsIgnoreCase("KG") || tipoVO.getFormaDeVenda().equalsIgnoreCase("Unidade"))){
			
			tipo.setFormaDeVenda(tipoVO.getFormaDeVenda());

		}
		if(tipoDAO.buscarTipo(tipoVO.getnome())!=null && tipoVO.getnome()!=""){

			tipo.setNome(tipoVO.getnome());
		}
			
		if(tipo.getnome()!=null && tipo.getFormaDeVenda()!=null){

			tipos = tipoDAO.buscaExcludente(tipoVO.getnome());
		
			TipoDAO.cadastrarAuxiliar(tipo);

			for(int i=0;tipos.get(i)!=null;i++){

				TipoDAO.cadastrar(tipos.get(i));
			}
			JOptionPane.showMessageDialog(null, "Tipo Alterado com sucesso");
		}else{
			JOptionPane.showMessageDialog(null, "Algum dado esta incorreto tente novamente");
		}
		
	}

	public void deletar(int codiguin){
		
		if(tipoDAO.buscarTipoPorCod(codiguin)!=null){

			tipo = tipoDAO.buscarTipoPorCod(codiguin);

			tipos = tipoDAO.buscaExcludente(tipo.getnome());

			for(int i=0;tipos.get(i)!=null;i++){
			
				tipo = tipos.get(i);
				if(i==0){
				TipoDAO.cadastrarAuxiliar(tipo);
				}else{				
						TipoDAO.cadastrar(tipos.get(i));
				}
			}
			JOptionPane.showMessageDialog(null, "Tipo Cadastrado com sucesso");
		}else{
			JOptionPane.showMessageDialog(null, "Algum dado esta incorreto tente novamente");
		}
	}


	public TipoVO buscarNome(String nomeTipo){
		
		return tipoDAO.buscarTipo(nomeTipo);
	}

	public TipoVO buscarCodigo(int codigo){

		return tipoDAO.buscarTipoPorCod(codigo);
	}
}
