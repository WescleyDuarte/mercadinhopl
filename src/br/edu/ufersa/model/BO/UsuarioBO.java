package mercadinhopl.model.BO;

import mercadinhopl.model.VO.*;
import mercadinhopl.model.DAO.*;
import java.util.*;

public class UsuarioBO {

	Scanner scanner = new Scanner(System.in);
	UsuarioVO usuario = new UsuarioVO();
	UsuarioDAO usuarioDAO = new UsuarioDAO();
	ArrayList<UsuarioVO> usuarios = new ArrayList<UsuarioVO>();
    int controlador = 0;
    public void cadastrarUsuario(){
		
		UsuarioVO usuarioAux = new UsuarioVO();
		controlador= 0;

		while(controlador==0){
			
			System.out.println("\nEntre com um Id para o usuario: ");
			usuarioAux.setId(scanner.nextInt());
			if(usuarioAux.getId()>0 && usuarioDAO.buscarUsuarioPorID(usuarioAux.getId())== null){
				usuario.setId(usuarioAux.getId());
				controlador++;
			}else{
				System.out.println("\n Id invalido ou ja existe");
			}

			while(controlador ==1){
				System.out.println("\nEntre com um Login para o usuario: ");
				usuarioAux.setLogin(scanner.next());
				if(usuarioDAO.buscarLogin(usuarioAux.getLogin())==null &&usuarioAux.getLogin() != null && usuarioAux.getLogin() !=""){
					usuario.setLogin(usuarioAux.getLogin());
					controlador++;
				}else{
					System.out.println("\n Login invalido");
				}

				while(controlador == 2){
					System.out.println("\nEntre com a senha para o usuario: ");
					usuarioAux.setSenha(scanner.next());
					if(usuarioAux.getSenha()!=null && usuarioAux.getSenha()!=""){
						usuario.setSenha(usuarioAux.getSenha());
						usuarioDAO.cadastrar(usuario);
						controlador++;
					}
				}
			}
		}	
	}

	public void alterar(int id){

		UsuarioVO usuarioParaAlterar = new UsuarioVO();

		usuarioParaAlterar = usuarioDAO.buscarUsuarioPorID(id);

		System.out.println(usuarioParaAlterar.toString());

		if(usuarioParaAlterar.getId()==id){
			controlador=0;

			while(controlador==0){
			System.out.println("\nDigite o novo Login para o usuario: ");
			usuarioParaAlterar.setLogin(scanner.next());
			
			if(usuarioDAO.buscarLogin(usuarioParaAlterar.getLogin())==null){
				controlador++;
				}else{
					System.out.println("\n Login ja registrado ou login não pode ser igual ao anterior");
			}
				while(controlador==1){
				System.out.println("\nDigite a nova Senha do usuario: ");
				usuarioParaAlterar.setSenha(scanner.next());

					if(usuarioParaAlterar.getSenha()!=null &&usuarioParaAlterar.getSenha()!=""){
						controlador++;
						usuarios = usuarioDAO.buscarExcludente(id);
						UsuarioDAO.cadastrarAuxiliar(usuarioParaAlterar);

						for(int i=0; usuarios.get(i)!=null;i++){

							usuarioDAO.cadastrar(usuarios.get(i));
						}
					}else{
						System.out.println("\nDigite uma senha valida!!!");
					}
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
