package mercadinhopl.model.BO;

import mercadinhopl.model.VO.*;
import mercadinhopl.model.DAO.*;
import java.io.*;
import java.util.*;

public class UsuarioBO {

	Scanner scanner = new Scanner(System.in);
	UsuarioVO usuario = new UsuarioVO();
	UsuarioDAO usuarioDAO = new UsuarioDAO();
    
    public void cadastrarUsuario(){
		
		System.out.println("Entre com um ID para o usuário: ");
		usuario.setId(scanner.nextInt());
		System.out.println("Entre com um login para o usuário: ");
		usuario.setLogin(scanner.next());
		System.out.println("Entre com uma senha para o usuário: ");
		usuario.setSenha(scanner.next());

		usuarioDAO.cadastrar(usuario);
		usuarioDAO.listar();
	}
	public void alterar(UsuarioVO usuario){
		//salvar alterações no BD
	}
	public void deletar(UsuarioVO usuario){
		//Deletar do BD
	}
}
