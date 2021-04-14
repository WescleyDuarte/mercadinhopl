package mercadinhopl.model.BO;

import mercadinhopl.model.VO.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import mercadinhopl.model.DAO.GerenteDAO;

public class GerenteBO {

	static Scanner scanner = new Scanner(System.in);
	GerenteVO gerente = new GerenteVO();
	GerenteDAO gerenteDAO = new GerenteDAO();
	List<GerenteVO> gerentes = new ArrayList<GerenteVO>();
    
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
						
						if(gerenteDAO.buscarGerente(gerenteAux.getCpf())== null && gerenteAux.getCpf() > 10000000000L && gerenteAux.getCpf() < 99999999999L){
							gerente.setCpf(gerenteAux.getCpf());
							gerenteDAO.cadastrar(gerente);
							controlador++;
						}
							
					}
				}
			}
		}
	}




	public void alterar(long cpfDoGerente){

		GerenteVO gerenteParaAlterar = new GerenteVO();

		GerenteDAO buscador = new GerenteDAO();

		
		System.out.println(buscador.buscarGerente(cpfDoGerente).toString());

		if(buscador.buscarGerente(cpfDoGerente)!=null){// quer dizer que encontrou

			int controlador=0;

			while(controlador ==0){
				System.out.println("\nEntre com o nome do gerente: ");
				gerenteParaAlterar.setNome(scanner.next());
				if(gerenteParaAlterar.getNome() != null && gerenteParaAlterar.getNome()!=""){
					gerente.setNome(gerenteParaAlterar.getNome());
					controlador ++;
				}else{
					System.out.println("\nNome invalido, digite novamete!");
				}

				while(controlador==1){
					System.out.println("\nEntre com a idade do gerente: ");
					gerenteParaAlterar.setIdade(scanner.nextInt());
					if(gerenteParaAlterar.getIdade()>0){
						gerente.setIdade(gerenteParaAlterar.getIdade());
						controlador++;
					}else{
						System.out.println("\nIdade invalida, digite novamente pfv!");
					}

					while(controlador==2){

						System.out.println("\nEntre com o sexo do gerente: ");
						gerenteParaAlterar.setSexo(scanner.next());
						if(gerenteParaAlterar.getSexo().equalsIgnoreCase("Masculino") || gerenteParaAlterar.getSexo().equalsIgnoreCase("Feminino")){
							gerente.setSexo(gerenteParaAlterar.getSexo());
							controlador++;
						}else{
							System.out.println("\nSexo invalido, digite novamente!!");
						}

						while(controlador ==3){
							System.out.println("\nEntre com o CPF do gerente: "); // colocar a função valida cpf
							gerenteParaAlterar.setCpf(scanner.nextLong());
							
							if(gerenteDAO.buscaExcludente(gerenteParaAlterar.getCpf())== null && gerenteParaAlterar.getCpf() > 10000000000L && gerenteParaAlterar.getCpf() < 99999999999L){
								gerente.setCpf(gerenteParaAlterar.getCpf());
								
								
								gerentes = gerenteDAO.buscaExcludente(cpfDoGerente);

								GerenteDAO.cadastrarAuxiliar(gerente);
								controlador++;
								

							for(int i=0; gerentes.get(i)!=null;i++){

								gerenteDAO.cadastrar(gerentes.get(i));

								}

							}
						}
					}			
				}
			}
		}else{
			System.out.println("\n não foi possivel encontrar o Gerente para ser alterado");
		}
	}

	public void deletar(long cpfDoGerente){
		gerente= gerenteDAO.buscarGerente(cpfDoGerente);

		gerentes = gerenteDAO.buscaExcludente(cpfDoGerente);
		if(gerente!= null){
			for(int i= 0;gerentes.get(i)!=null;i++){
				
				gerente =	gerentes.get(i);
				if(i==0){
				GerenteDAO.cadastrarAuxiliar(gerente);
				}else{				
						gerenteDAO.cadastrar(gerentes.get(i));
					}
				}
				System.out.println("\nGerente deletado");
		}else{
			System.out.println("\nNão foi possivel encontrar um gerente");
		}
	}

	// public void buscar (long cpf){  // estanos vendo se quando for criar as interfaces vamos utilizar
	// 	// busca o gerente correspondente ao nome recebido
	// }
}
