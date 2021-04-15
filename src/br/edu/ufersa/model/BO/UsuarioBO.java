package br.edu.ufersa.model.BO;

import br.edu.ufersa.model.VO.*;
import br.edu.ufersa.model.DAO.*;
import java.util.*;

public class UsuarioBO {

	Scanner scanner = new Scanner(System.in);
	UsuarioVO usuario = new UsuarioVO();
	UsuarioDAO usuarioDAO = new UsuarioDAO();
	ArrayList<UsuarioVO> usuarios = new ArrayList<UsuarioVO>();
    int controlador = 0;

	PessoaDAO pessoaDAO = new PessoaDAO();
	PessoaVO pessoaVO = new PessoaVO();

    public void cadastrarUsuario(){
		
	
		controlador= 0;
	
		while(controlador==0){
			
			System.out.println("\nEntre com um Id para o usuario: ");
			usuario.setId(scanner.nextInt());
			if(usuario.getId()>0 && usuarioDAO.buscarUsuarioPorID(usuario.getId())== null){
				
				controlador++;
			}else{
				System.out.println("\n Id invalido ou ja existe");
			}
		}

		while(controlador ==1){
			System.out.println("\nEntre com um Login para o usuario: ");
			usuario.setLogin(scanner.next());
			if(usuarioDAO.buscarLogin(usuario.getLogin())==null &&usuario.getLogin() != null && usuario.getLogin() !=""){
				
				controlador++;
			}else{
					System.out.println("\n Login invalido");
			}
		}

		while(controlador == 2){
					System.out.println("\nEntre com a senha para o usuario: ");
					usuario.setSenha(scanner.next());
					if(usuario.getSenha()!=null && usuario.getSenha()!=""){
						
						controlador++;
					}else{
						System.out.println("\nSenha invalida!!");
					}

		}

		while(controlador==3){
			System.out.println("\nEntre com Nome para o usuario: ");
			usuario.setNome(scanner.next());

			if(pessoaDAO.buscarPessoa(usuario.getNome())!=null){

				pessoaVO = pessoaDAO.buscarPessoa(usuario.getNome());
				usuario.setSexo(pessoaVO.getSexo());
				usuario.setIdade(pessoaVO.getIdade());
				controlador++;
			}else{
				System.out.println("\n Nome invalida!!");
			}
		}
		if(controlador==4){
			usuarioDAO.cadastrar(usuario);
		}
	}

	public void alterar(int id){

		usuario = usuarioDAO.buscarUsuarioPorID(id);

		System.out.println(usuario.toString());

		if(usuario.getId()==id){
			controlador=0;

			while(controlador==0){
			System.out.println("\nDigite o novo Login para o usuario: ");
			usuario.setLogin(scanner.next());
			
				if(usuarioDAO.buscarExcludente(id)==null){
					controlador++;
				}else{
					System.out.println("\n Login ja registrado ou login não pode ser igual ao anterior");
				}
			}
			while(controlador==1){
			System.out.println("\nDigite a nova Senha do usuario: ");
			usuario.setSenha(scanner.next());

				if(usuario.getSenha()!=null &&usuario.getSenha()!=""){
					controlador++;

					usuario.setNome(usuarioDAO.buscarUsuarioPorID(id).getNome());
					usuario.setIdade(usuarioDAO.buscarUsuarioPorID(id).getIdade());
					usuario.setSexo(usuarioDAO.buscarUsuarioPorID(id).getSexo());

					usuarios = usuarioDAO.buscarExcludente(id);
					UsuarioDAO.cadastrarAuxiliar(usuario);
				
					for(int i=0; usuarios.get(i)!=null;i++){
				
						usuarioDAO.cadastrar(usuarios.get(i));
						}
				}else{
						System.out.println("\nDigite uma senha valida!!!");
				}
			}
			
		}
	}


	public void deletar(int iD){
		usuarios = usuarioDAO.buscarExcludente(iD);

		for(int i=0;usuarios.get(i)!=null;i++){
			
			usuario = usuarios.get(i);
			if(i==0){
			UsuarioDAO.cadastrarAuxiliar(usuario);
			}else{				
				usuarioDAO.cadastrar(usuarios.get(i));
			}
		}
	}
}
