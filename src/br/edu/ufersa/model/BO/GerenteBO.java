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

		GerenteVO gerenteAux = new GerenteVO();
		
		int controlador=0;
		while(controlador ==0){
			System.out.println("\nEntre com o nome do gerente: ");
			gerenteAux.setNome(scanner.next());
			if(gerenteAux.getNome() != null && gerenteAux.getNome()!=""){
				gerente.setNome(gerenteAux.getNome());
				controlador ++;
			}else{
				System.out.println("\nNome invalido, digite novamete!");
			}

			while(controlador==1){
				System.out.println("\nEntre com a idade do gerente: ");
				gerenteAux.setIdade(scanner.nextInt());
				if(gerenteAux.getIdade()>0){
					gerente.setIdade(gerenteAux.getIdade());
					controlador++;
				}else{
					System.out.println("\nIdade invalida, digite novamente pfv!");
				}

				while(controlador==2){

					System.out.println("\nEntre com o sexo do gerente: ");
					gerenteAux.setSexo(scanner.next());
					if(gerenteAux.getSexo().equalsIgnoreCase("Masculino") || gerenteAux.getSexo().equalsIgnoreCase("Feminino")){
						gerente.setSexo(gerenteAux.getSexo());
						controlador++;
					}else{
						System.out.println("\nSexo invalido, digite novamente!!");
					}

					while(controlador ==3){
						System.out.println("\nEntre com o CPF do gerente: "); // colocar a função valida cpf
						gerenteAux.setCpf(scanner.nextLong());
						
						if(gerenteDAO.validarGCPF(gerenteAux.getCpf())!= null && gerenteAux.getCpf() > 10000000000L && gerenteAux.getCpf() < 99999999999L){
							gerente.setCpf(gerenteAux.getCpf());
							gerenteDAO.cadastrar(gerente);
							controlador++;
						}
							
					}
				}
			}
		}
	}


	public void alterar(String nomeDoGerente){
		GerenteVO gerenteParaAlterar = new GerenteVO();

		GerenteDAO buscador = new GerenteDAO();

		gerenteParaAlterar = buscador.buscarGerente(nomeDoGerente);

		// fazer o busca do Gerente
		System.out.println(gerenteParaAlterar.toString());
		
		System.out.println("\nDigite o novo Nome para o Gerente: ");
		gerenteParaAlterar.setNome(scanner.next());
		System.out.println("\nDigite a nova Idade para o Gerente: ");
		gerenteParaAlterar.setIdade(scanner.nextInt());
		System.out.println("\nDigite o novo Sexo do Gerente: ");
		gerenteParaAlterar.setSexo(scanner.next());
		System.out.println("\nDigite o novo CPF do Gerente: ");
		gerenteParaAlterar.setCpf(scanner.nextInt());

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
