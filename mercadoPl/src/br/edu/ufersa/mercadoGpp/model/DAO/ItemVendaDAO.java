package br.edu.ufersa.mercadoGpp.model.DAO;


import br.edu.ufersa.mercadoGpp.model.VO.*;
import java.io.*;

public class ItemVendaDAO {

    private static final String filepath = "ItensVenda.dat";
    
    VendaVO venda = new VendaVO();
    ProdutoVO produto = new ProdutoVO();
    ProdutoDAO produtoDAO = new ProdutoDAO();

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

    public ItemVendaVO buscarItemVenda(int codigo) {
        try {
            File file = new File(filepath);

            if(file.exists() && file.isFile() && file.canRead()) {
                FileInputStream fileIn = new FileInputStream(filepath);
                while(fileIn.available() > 0) {
                    ObjectInputStream objectIn = new ObjectInputStream(fileIn);

                    ItemVendaVO itemVenda = (ItemVendaVO)objectIn.readObject();
                    produto = produtoDAO.buscarProdutoPorCodigo(codigo);
                    if(produto.getCodigo() == codigo) {
                        fileIn.close();
                        objectIn.close();
                        return itemVenda;
                    }
                }
                fileIn.close();
            }else System.out.println("Erro no arquivo, item nao pode ser buscado!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
