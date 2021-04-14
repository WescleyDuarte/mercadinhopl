package mercadinhopl.model.DAO;
import java.io.*;
import mercadinhopl.model.VO.*;
public class CompraDAO {
    
    private static final String filepath = "Compras.dat";

    public void cadastrar(CompraVO compra) {

        try{
            FileOutputStream fileOut = new FileOutputStream(filepath,true);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

            objectOut.writeObject(compra);
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
                CompraVO compra = (CompraVO)objectIn.readObject();
                System.out.println(compra.toString());
            }

            fileIn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
