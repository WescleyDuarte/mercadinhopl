package br.edu.ufersa.model.BO;

import br.edu.ufersa.model.VO.*;
import br.edu.ufersa.model.DAO.*;
import java.util.*;
import java.util.ArrayList;

public class GerenteBO extends UsuarioBO{

    static Scanner scanner = new Scanner(System.in);
	private GerenteVO gerente = new GerenteVO();
	private	GerenteDAO gerenteDAO = new GerenteDAO();
	private ArrayList<GerenteVO> gerentes = new ArrayList<GerenteVO>();
    private int controlador;
	//private UsuarioDAO usuarioDAO = new UsuarioDAO();
	private CaixaDAO caixaDAO = new CaixaDAO();



    @Override
    public void cargo(){
        //Aqui teremos condição para relaização de alteração na nota( ou outra opção mais detalhada) // precisamos da interface grafica  para utilizar melhor
    }



    //Duvida aqui é fazer o BO de cada um e dale aqui? ou fazer tudo so em GERENTE E CAIXA?
	//ver o antigo BO do Usuario porque talvez precisamos dele ai altera aqui o cadastro (lembrar de alterar o controlador)
	// ou se no logi ele busca so esses campos para confirmar 
	// me parece diminuir coisas guardando tudo apenas em Caixa e Gerente

    public void cadastrarGerente() { //melhorar o tratamento futuramento com as outras opÃ§Ãµes de polimofismo
				
			controlador=0;
			while(controlador!=7){

				if(controlador==0){
					System.out.println("\nDigite o CPF do Gerente");
					gerente.setCpf(scanner.nextLong());

					if( gerente.getCpf()> 10000000000L && gerente.getCpf() < 99999999999L){
						controlador++;
					}

				if(controlador==1){
					System.out.println("\nDigite o Nome do Gerente");
					gerente.setNome(scanner.next());
				}

					if(gerente.getNome() != null && gerente.getNome()!=""){
					controlador ++;
					}

				if(controlador==2){
						System.out.println("\nDigite o Sexo do Gerente");
						gerente.setSexo(scanner.next());

					}

					if(gerente.getSexo().equalsIgnoreCase("Masculino") || gerente.getSexo().equalsIgnoreCase("Feminino")){
                    	controlador++;
                    }

				if(controlador==3){
						System.out.println("\nDigite o Idade do Gerente");
						gerente.setIdade(scanner.nextInt());

					}
					if(gerente.getIdade()>0){
						controlador++;
					}

				if(controlador==4){
					System.out.println("\nDigite o ID do Gerente");
					gerente.setId(scanner.nextInt());

				}
					if(gerenteDAO.buscarGerente(gerente.getId())==null && caixaDAO.buscarCaixa(gerente.getId())==null && gerente.getId()!=0 && gerente.getId()>0){ 
						controlador++;
					}
				
					// ESTOU EDITANDO AQUI AINDA
				if(controlador==5){
					System.out.println("\nDigite o Login do Gerente");
					gerente.setLogin(scanner.next());
	
					}

					//Criar uma Busca de Login No gerente e no Caixa
					if(gerenteDAO.buscarLoginGerente(gerente.getLogin())==null && caixaDAO.buscarLoginCaixa(gerente.getLogin())==null &&gerente.getLogin()!=null && gerente.getLogin()!=""){
						controlador++;
					}
				if(controlador==6){
					System.out.println("\nDigite o Senha do Gerente");
					gerente.setSenha(scanner.next());
				}
					if(gerente.getSenha()!=null && gerente.getSenha()!=""){
						controlador++;
						gerenteDAO.cadastrar(gerente);
					}

				}

				System.out.println("não foi possivel colocar os dados, insira novamente!");
			}
		}
			
	


	public void alterar(int id){
		
		if(gerenteDAO.buscarGerente(id)!=null){

			gerente = gerenteDAO.buscarGerente(id);

			System.out.println(gerente.toString());
			controlador=0;
			while(controlador!=7){

				if(controlador==0){
					System.out.println("\nDigite o CPF do Gerente");
					gerente.setCpf(scanner.nextInt());

					if( gerente.getCpf()> 10000000000L && gerente.getCpf() < 99999999999L){
						controlador++;
					}

				if(controlador==1){
					System.out.println("\nDigite o Nome do Gerente");
					gerente.setNome(scanner.next());
				}

					if(gerente.getNome() != null && gerente.getNome()!=""){
					controlador ++;
					}

				if(controlador==2){
						System.out.println("\nDigite o Sexo do Gerente");
						gerente.setSexo(scanner.next());

					}

					if(gerente.getSexo().equalsIgnoreCase("Masculino") || gerente.getSexo().equalsIgnoreCase("Feminino")){
                    	controlador++;
                    }

				if(controlador==3){
						System.out.println("\nDigite o Idade do Gerente");
						gerente.setIdade(scanner.nextInt());

					}
					if(gerente.getIdade()>0){
						controlador++;
					}

				if(controlador==4){
					System.out.println("\nDigite o ID do Gerente");
					gerente.setId(scanner.nextInt());

				}
					if(gerenteDAO.buscarGerente(gerente.getId())==null && caixaDAO.buscarCaixa(gerente.getId())==null && gerente.getId()!=0 && gerente.getId()>0){ 
						controlador++;
					}
				
					// ESTOU EDITANDO AQUI AINDA
				if(controlador==5){
					System.out.println("\nDigite o Login do Gerente");
					gerente.setLogin(scanner.next());
	
					}

					//Criar uma Busca de Login No gerente e no Caixa
					if(gerenteDAO.buscarLoginGerente(gerente.getLogin())==null && caixaDAO.buscarLoginCaixa(gerente.getLogin())==null &&gerente.getLogin()!=null && gerente.getLogin()!=""){
						controlador++;
					}
				if(controlador==6){
					System.out.println("\nDigite o Senha do Gerente");
					gerente.setSenha(scanner.next());
				}
					if(gerente.getSenha()!=null && gerente.getSenha()!=""){
						controlador++;
					}
				}

				System.out.println("não foi possivel colocar os dados, insira novamente!");
			}
			gerentes = gerenteDAO.buscaExcludente(id);

			GerenteDAO.cadastrarAuxiliar(gerente);

			for(int i=0; gerentes.get(i)!=null;i++){
				gerenteDAO.cadastrar(gerentes.get(i));
			}

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
}
