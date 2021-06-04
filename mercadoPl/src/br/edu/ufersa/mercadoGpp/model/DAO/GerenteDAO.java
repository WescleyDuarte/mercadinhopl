package br.edu.ufersa.mercadoGpp.model.DAO;

import br.edu.ufersa.mercadoGpp.model.VO.*;

import java.io.*;
import java.util.ArrayList;


public class GerenteDAO {
    
    private static final String filepath = "Gerentes.dat";
    private String compStr; // colocar aqui o buscarCaixa e buscaExcludente
    private boolean a= true; // foi preciso usar, talvez Deus saiba o porquê
    
    public void cadastrar(GerenteVO gerente) {

        try{
            FileOutputStream fileOut = new FileOutputStream(filepath,true);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

            objectOut.writeObject(gerente);
            objectOut.flush();

            fileOut.close();
            objectOut.close();
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public static void cadastrarAuxiliar (GerenteVO gerente){

        try{
            FileOutputStream fileOut = new FileOutputStream(filepath); // não tem true
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

            objectOut.writeObject(gerente);
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
                GerenteVO gerente = (GerenteVO)objectIn.readObject();
                System.out.println(gerente.toString());
            }

            fileIn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    
    public  GerenteVO buscarLoginGerente(String str){
        try{
            File arquivo = new File(filepath);
           
            if (arquivo.exists() && arquivo.isFile() && arquivo.canRead()){
                FileInputStream arquivoLeitura = new FileInputStream(arquivo);
                while(arquivoLeitura.available()>0){
                    ObjectInputStream objetoLeitura = new ObjectInputStream(arquivoLeitura);

                    GerenteVO gerente = (GerenteVO)objetoLeitura.readObject();
                    
                    compStr = gerente.getLogin();
                    if (compStr.equalsIgnoreCase(str)){
                        arquivoLeitura.close();
                        objetoLeitura.close();
                        return  gerente;
                    }                    
                }
                arquivoLeitura.close();
            }
        }catch(Exception e){
                e.printStackTrace();
            }
        return null;
    
    }

    public ArrayList<GerenteVO> buscaExcludente(GerenteVO gerente){
        try{
            File arquivo = new File(filepath);

            if (arquivo.exists() && arquivo.isFile() && arquivo.canRead()){
                FileInputStream arquivoLeitura = new FileInputStream(arquivo);
                
                while(arquivoLeitura.available()>0){
                    ObjectInputStream objetoLeitura = new ObjectInputStream(arquivoLeitura);

                    GerenteVO gerenteAux = (GerenteVO)objetoLeitura.readObject();
                    if(gerente.getId() == gerenteAux.getId()) {
                    }
                       
                }                
                arquivoLeitura.close();   
            }
        }catch(Exception e){
                e.printStackTrace();
            }
        return null;
       
    }
}
