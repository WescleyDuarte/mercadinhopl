package br.edu.ufersa.model.DAO;

import java.io.*;
//import java.util.*;

//import br.edu.ufersa.model.BO.*;
import br.edu.ufersa.model.VO.*;
//import br.edu.ufersa.model.DAO.*;

public class ItemCompraDAO {

    CompraVO compra = new CompraVO();
    //CompraDAO compraDAO = new CompraDAO();
    ProdutoVO produto = new ProdutoVO();
    ProdutoDAO produtoDAO = new ProdutoDAO();

    private static final String filepath = "ItensCompra.dat";

    /*public void cadastrar(ItemCompraVO itemCompra) {

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

    public void cadastrarAuxiliar(ItemCompraVO itemCompra) {
        try {
            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

            objectOut.writeObject(itemCompra);
            objectOut.flush();

            objectOut.close();
            fileOut.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    /*public void listar(){
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
    }*/
    
    public ItemCompraVO buscarItemCompra(int codigo) {
        try {
            File file = new File(filepath);

            if(file.exists() && file.isFile() && file.canRead()) {
                FileInputStream fileIn = new FileInputStream(filepath);
                while(fileIn.available() > 0) {
                    ObjectInputStream objectIn = new ObjectInputStream(fileIn);

                    ItemCompraVO itemCompra = (ItemCompraVO)objectIn.readObject();
                    produto = produtoDAO.buscarProdutoPorCodigo(codigo);
                    if(produto.getCodigo() == codigo) {
                        fileIn.close();
                        objectIn.close();
                        return itemCompra;
                    }
                }
                fileIn.close();
            }else System.out.println("Erro no arquivo, item nao pode ser buscado!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /*public List<ItemCompraVO> buscarExcludente(int codigoCompra, int codigoProduto) {
        int i = 0;
        File file = new File(filepath);

        compra = compraDAO.buscarCompra(codigo);
        List<ItemCompraVO> itensCompra = compra.getItemCompra();

        if(file.exists() && file.isFile() && file.canRead()) {
            FileInputStream fileIn = new FileInputStream(filepath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            while(fileIn.available() > 0) {
                ItemCompraVO itemCompra = (ItemCompraVO)objectIn.readObject();

                if(itemCompra.getCodigoProduto() == codigo) {
                    itensCompra.add(i, itemCompra);
                    i++;
                }
            }
            fileIn.close();
            objectIn.close();
            if(itensCompra != null) {
                return itensCompra;
            }
        }
    }*/
}