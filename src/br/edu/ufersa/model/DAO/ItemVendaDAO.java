package mercadinhopl.model.DAO;

/*import mercadinhopl.model.BO.*;
import mercadinhopl.model.VO.*;
import java.io.*;*/

public class ItemVendaDAO {
    
    /*
    private static final String filepath = "ItensVenda.dat";

    public void cadastrar(ItemVendaVO itemVenda) {

        try{
            FileOutputStream fileOut = new FileOutputStream(filepath,true);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

            objectOut.writeObject(itemVenda);
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
                ItemVendaVO itemVenda = (ItemVendaVO)objectIn.readObject();
                System.out.println(itemVenda.toString());
            }

            fileIn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    */
}
