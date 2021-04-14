package br.edu.ufersa.model.DAO;
import java.io.*;
import br.edu.ufersa.model.VO.*;
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

    public CompraVO buscarCompra(int codigo) {
        try {
            File file = new File();

            if(file.exists() && file.isFile() && file.canRead()) {
                FileInputStream fileIn = new FileInputStream(filepath);
                while(fileIn.available() > 0) {
                    ObjectInputStream objectIn = new ObjectInputStream(fileIn);

                    CompraVO compra = (CompraVO)objectIn.readObject();

                    if(compra.getCodigoProduto() == codigo) {
                        fileIn.close();
                        objectIn.close();
                        return compra;
                    }
                }
            }else System.out.println("Erro no arquivo, compra nao pode ser buscada!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
