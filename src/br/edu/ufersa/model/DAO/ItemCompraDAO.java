package mercadinhopl.model.DAO;

import java.io.*;
import mercadinhopl.model.BO.*;
import mercadinhopl.model.VO.*;

public class ItemCompraDAO {

    private static final String filepath = "ItensCompra.dat";

    public void cadastrar(ItemCompraVO itemCompra) {

        try{
            FileOutputStream fileOut = new FileOutputStream(filepath,true);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

            objectOut.writeObject(itemCompra);
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
                ItemCompraVO itemCompra = (ItemCompraVO)objectIn.readObject();
                System.out.println(itemCompra.toString());
            }

            fileIn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
