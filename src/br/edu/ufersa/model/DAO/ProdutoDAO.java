package br.edu.ufersa.model.DAO;
import java.io.*;
import java.util.*;

import br.edu.ufersa.model.VO.ProdutoVO;

public class ProdutoDAO{

    private static final String filepath = "Produtos.dat";

    public static void cadastrar (ProdutoVO produto) {

        try {

            FileOutputStream fileOut = new FileOutputStream(filepath, true);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

            objectOut.writeObject(produto);
            fileOut.close();
            objectOut.close();

            System.out.println("Objeto gravado com sucesso!");            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void cadastrarAuxiliar  (ProdutoVO produto){

        try{
            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

            objectOut.writeObject(produto);
            objectOut.flush();

            fileOut.close();
            objectOut.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void listar(){
        try{
        File arquivo = new File(filepath);
        
        if (arquivo.exists() && arquivo.isFile() && arquivo.canRead()){
            FileInputStream arquivoLeitura = new FileInputStream(arquivo);
            while(arquivoLeitura.available()>0){
                ObjectInputStream objetoLeitura = new ObjectInputStream(arquivoLeitura);
                ProdutoVO produto = (ProdutoVO)objetoLeitura.readObject();
                System.out.println(produto.toString());
            }
            arquivoLeitura.close();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private int codiguin; // codigo de comparação do produto

    public ProdutoVO buscarProdutoPorCodigo (int codigo){
        try{
            File arquivo = new File(filepath);
           
            if (arquivo.exists() && arquivo.isFile() && arquivo.canRead()){
                FileInputStream arquivoLeitura = new FileInputStream(arquivo);
                while(arquivoLeitura.available()>0){
                    ObjectInputStream objetoLeitura = new ObjectInputStream(arquivoLeitura);

                    ProdutoVO produto = (ProdutoVO)objetoLeitura.readObject();
                    codiguin = produto.getCodigo();
                    if (codiguin == codigo){
                        arquivoLeitura.close();
                        objetoLeitura.close();
                        return produto;
                    }                    
                }
                //System.out.println("Produto não registrado"); // aviso provisorio
                arquivoLeitura.close();
            }
        }catch(Exception e){
                e.printStackTrace();
        }
        return null;    
    }

    public ArrayList<ProdutoVO> buscaExcludente(int codigo){
        int i=0;
        try{
            File arquivo = new File(filepath);

            ArrayList<ProdutoVO> produtos = new ArrayList<ProdutoVO>();

            if (arquivo.exists() && arquivo.isFile() && arquivo.canRead()) {
                FileInputStream arquivoLeitura = new FileInputStream(arquivo);
                
                while(arquivoLeitura.available()>0) {
                    ObjectInputStream objetoLeitura = new ObjectInputStream(arquivoLeitura);

                    ProdutoVO produto = (ProdutoVO)objetoLeitura.readObject();
                    codiguin = produto.getCodigo();

                    if(codiguin != codigo) {
                            
                        produtos.add(i,produto);
                        i++;
                        
                    }
                    System.out.println(codiguin);                            
                }
                
                arquivoLeitura.close();
                if(produtos != null) {
                    System.out.println("Tipo alterado com sucesso");
                    return produtos;
                }
            }
        }catch(Exception e){
                e.printStackTrace();
            }
        return null;
       
    }
}