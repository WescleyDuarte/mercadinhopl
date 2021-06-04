package br.edu.ufersa.mercadoGpp.model.BO;

import br.edu.ufersa.mercadoGpp.model.VO.*;
import br.edu.ufersa.mercadoGpp.exception.AuthException;
import br.edu.ufersa.mercadoGpp.exception.LoginExistsException;
import br.edu.ufersa.mercadoGpp.model.DAO.*;

import java.sql.ResultSet;
import java.util.*;

public class UsuarioBO extends PessoaBO{

	Scanner scanner = new Scanner(System.in);
	UsuarioDAO usuarioDAO = new UsuarioDAO();
	ArrayList<UsuarioVO> usuarios = new ArrayList<UsuarioVO>();
    int controlador = 0;

    public void cadastrarUsuario(UsuarioVO usuario){
		super.cadastrarPessoa(usuario);
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

	public UsuarioVO auth(UsuarioVO usuVO) throws AuthException {
		//função que checa no arquivo se o usuário existe e se ele é gerente ou caixa
		return null;
	}

	int codiguin = 0;
	public int gerarCodigo() {

		Random random = new Random();

		do{
			codiguin = random.nextInt(100);
		}
		while(usuarioDAO.buscarUsuarioPorID(codiguin) != null);

		return codiguin;

	}
}