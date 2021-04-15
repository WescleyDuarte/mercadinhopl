package br.edu.ufersa.model.DAO;

//import java.util.*;
import java.io.*;
//import br.edu.ufersa.model.BO.*;
import br.edu.ufersa.model.VO.*;

public class VendaDAO {
    
    private static final String filepath = "Vendas.dat";

    public void cadastrar(VendaVO venda) {

        try{
            FileOutputStream fileOut = new FileOutputStream(filepath,true);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

            objectOut.writeObject(venda);
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
                VendaVO venda = (VendaVO)objectIn.readObject();
                System.out.println(venda.toString());
                System.out.println("\n");
            }

            fileIn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    int codiguin = 0;
    public VendaVO buscarVenda (int codigo){
        try{
            File arquivo = new File(filepath);
           
            if (arquivo.exists() && arquivo.isFile() && arquivo.canRead()){
                FileInputStream arquivoLeitura = new FileInputStream(arquivo);
                while(arquivoLeitura.available()>0){
                    ObjectInputStream objetoLeitura = new ObjectInputStream(arquivoLeitura);

                    VendaVO venda = (VendaVO)objetoLeitura.readObject();
                    codiguin = venda.getCodigo();
                    if (codiguin == codigo){
                        arquivoLeitura.close();
                        objetoLeitura.close();
                        return venda;
                    }                    
                }
                System.out.println("Venda não registrada"); // aviso provisorio
                arquivoLeitura.close();
            }
        }catch(Exception e){
                e.printStackTrace();
            }
        return null;
    
    }
}
