package br.edu.ufersa.mercadoGpp.model.BO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.ufersa.mercadoGpp.model.DAO.*;
import br.edu.ufersa.mercadoGpp.model.VO.*;

public class PessoaBO {    
    
    static Scanner scanner = new Scanner(System.in);
    private PessoaVO pessoa = new PessoaVO();
    private PessoaDAO pessoaDAO = new PessoaDAO();
	private int controlador = 0;

	List<PessoaVO> pessoas = new ArrayList<PessoaVO>();
        // passar logo pra pessoa n達o usar auxiliar
        //

    public void cadastrarPessoa(PessoaVO pessoa) {
        pessoaDAO.cadastrar(pessoa);
    }

    public void alterar(String nomeDaPessoa){

		System.out.println(pessoaDAO.buscarPessoa(nomeDaPessoa).toString());

		if(pessoaDAO.buscarPessoa(nomeDaPessoa)!=null){// quer dizer que encontrou
		controlador=0;

			while(controlador ==0){
				System.out.println("\nEntre com o nome do Pessoa: ");
				pessoa.setNome(scanner.next());

				if(pessoaDAO.buscaExcludente(pessoa.getNome())==null && pessoa.getNome() != null && pessoa.getNome()!=""){
					controlador ++;
				}else{
					System.out.println("\nNome invalido, digite novamete!");
				}

				while(controlador==1){
					System.out.println("\nEntre com a idade do Pessoa: ");
					pessoa.setIdade(scanner.nextInt());
					if(pessoa.getIdade()>0){
						
						controlador++;
					}else{
						System.out.println("\nIdade invalida, digite novamente pfv!");
					}

					while(controlador==2){

						System.out.println("\nEntre com o sexo do Pessoa: ");
						pessoa.setSexo(scanner.next());
						if(pessoa.getSexo().equalsIgnoreCase("Masculino") || pessoa.getSexo().equalsIgnoreCase("Feminino")){
								
							pessoas = pessoaDAO.buscaExcludente(nomeDaPessoa);
							pessoaDAO.cadastrarAuxiliar(pessoa);
							controlador++;
								
							for(int i=0; pessoas.get(i)!=null;i++){

								pessoaDAO.cadastrar(pessoas.get(i));

								}
							controlador++;
						}else{
							System.out.println("\nSexo invalido, digite novamente!!");
						}
					}
				}
			}			
		}else{
			System.out.println("\n pessoa n達o encontrada");
		}
	}
	
	public void deletar(String nomeDaPessoa){
		pessoa= pessoaDAO.buscarPessoa(nomeDaPessoa); // 1
		if(pessoa!= null){
			pessoas = pessoaDAO.buscaExcludente(nomeDaPessoa);
			for(int i= 0;pessoas.get(i)!=null;i++){
				
				pessoa =pessoas.get(i);	// a pessoa pesquisada em 1 n達o emporta mais
				if(i==0){
				pessoaDAO.cadastrarAuxiliar(pessoa);
				}else{				
						pessoaDAO.cadastrar(pessoas.get(i));
					}
				}
				System.out.println("\npessoa deletado");
		}else{
			System.out.println("\nN達o foi possivel encontrar um pessoa");
		}
	}

}
