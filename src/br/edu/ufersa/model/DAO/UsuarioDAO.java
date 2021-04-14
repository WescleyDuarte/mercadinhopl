package mercadinhopl.model.DAO;

import java.io.*;
import java.util.*;
import mercadinhopl.model.VO.*;


public class UsuarioDAO {
    
    private static final String filepath = "Usuarios.dat";

    public void cadastrar(UsuarioVO usuario) {

        try{
            FileOutputStream fileOut = new FileOutputStream(filepath,true);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

            objectOut.writeObject(usuario);
            objectOut.flush();

            fileOut.close();
            objectOut.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void cadastrarAuxiliar  (UsuarioVO usuario){

        try{
            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

            objectOut.writeObject(usuario);
            objectOut.flush();

            fileOut.close();
            objectOut.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void listar(){
        try{
            FileInputStream fileIn = new FileInputStream(filepath);

            while(fileIn.available() > 0){
                ObjectInputStream objectIn = new ObjectInputStream(fileIn);
                UsuarioVO usuario = (UsuarioVO)objectIn.readObject();
                System.out.println(usuario.toString());
            }

            fileIn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    private int codiguin=0;
    
    public UsuarioVO buscarUsuarioPorID (int codigo){ 
    
        try{
            File arquivo = new File(filepath);
           
            if (arquivo.exists() && arquivo.isFile() && arquivo.canRead()){
                FileInputStream arquivoLeitura = new FileInputStream(arquivo);
                while(arquivoLeitura.available()>0){
                    ObjectInputStream objetoLeitura = new ObjectInputStream(arquivoLeitura);

                    UsuarioVO usuario = (UsuarioVO)objetoLeitura.readObject();
                    codiguin = usuario.getId();
                    if (codiguin == codigo){
                        
                        arquivoLeitura.close();
                        objetoLeitura.close();
                        codiguin=0;
                        return usuario;
                    }                    
                }
                //System.out.println("usuario não registrado"); // aviso provisorio
                arquivoLeitura.close();
            }
        }catch(Exception e){
                e.printStackTrace();
        }
        return null;    
    }

    private String compStr;
    public UsuarioVO buscarLogin (String login){  // usada pra saber se existe algum login 
                                                  // e pra buscar o usuario e comparar a senha no Login tela
        try{
            File arquivo = new File(filepath);
           
            if (arquivo.exists() && arquivo.isFile() && arquivo.canRead()){
                FileInputStream arquivoLeitura = new FileInputStream(arquivo);
                while(arquivoLeitura.available()>0){
                    ObjectInputStream objetoLeitura = new ObjectInputStream(arquivoLeitura);

                    UsuarioVO usuario = (UsuarioVO)objetoLeitura.readObject();
                    compStr= usuario.getLogin();
                    if (compStr.equalsIgnoreCase(login)){
                        arquivoLeitura.close();
                        objetoLeitura.close();
                        return usuario;
                    }                    
                }
                //System.out.println("usuario não registrado"); // aviso provisorio
                arquivoLeitura.close();
            }
        }catch(Exception e){
                e.printStackTrace();
        }
        return null;    
    }

    public ArrayList<UsuarioVO> buscarExcludente(int codigo){
        int i=0;
        try{
            File arquivo = new File(filepath);

            ArrayList<UsuarioVO> usuarios = new ArrayList<UsuarioVO>();

            if (arquivo.exists() && arquivo.isFile() && arquivo.canRead()) {
                FileInputStream arquivoLeitura = new FileInputStream(arquivo);
                
                while(arquivoLeitura.available()>0) {
                    ObjectInputStream objetoLeitura = new ObjectInputStream(arquivoLeitura);

                    UsuarioVO usuario = (UsuarioVO)objetoLeitura.readObject();
                    codiguin = usuario.getId();

                    if(codiguin != codigo) {
                            
                        usuarios.add(i,usuario);
                        i++;
                        
                    }
                    System.out.println(codiguin);                            
                }
                
                arquivoLeitura.close();
                if(usuarios != null) {
                    System.out.println("Tipo alterado com sucesso");
                    codiguin=0;
                    return usuarios;
                }
            }
        }catch(Exception e){
                e.printStackTrace();
            }
        return null;
       
    }
}
