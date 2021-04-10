package mercadinhopl.model.DAO;

import java.io.*;
import java.util.*;
import mercadinhopl.model.VO.*;
import mercadinhopl.model.BO.*;

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
}
