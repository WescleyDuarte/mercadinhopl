package br.edu.ufersa.model.DAO;
import java.io.*;
import br.edu.ufersa.model.VO.*;
//import br.edu.ufersa.model.VO.*;
import java.util.ArrayList;

public class CaixaDAO {
    
    private static final String filepath = "Caixas.dat";
    
    public void cadastrar(CaixaVO caixa) {

        try{
            FileOutputStream fileOut = new FileOutputStream(filepath,true);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

            objectOut.writeObject(caixa);
            objectOut.flush();

            fileOut.close();
            objectOut.close();
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public static void cadastrarAuxiliar  (CaixaVO caixa){

        try{
            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

            objectOut.writeObject(caixa);
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
                CaixaVO caixa = (CaixaVO)objectIn.readObject();
                System.out.println(caixa.toString());
            }

            fileIn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public  CaixaVO buscarCaixa (int id){
        try{
            File arquivo = new File(filepath);
           
            if (arquivo.exists() && arquivo.isFile() && arquivo.canRead()){
                FileInputStream arquivoLeitura = new FileInputStream(arquivo);
                while(arquivoLeitura.available()>0){
                    ObjectInputStream objetoLeitura = new ObjectInputStream(arquivoLeitura);

                    CaixaVO caixa = (CaixaVO)objetoLeitura.readObject();
                    
                    if (caixa.getId()==id){
                        arquivoLeitura.close();
                        objetoLeitura.close();
                        return caixa;
                    }                    
                }
                System.out.println("Caixa nÃ£o registrado"); // aviso provisorio
                arquivoLeitura.close();
            }
        }catch(Exception e){
                e.printStackTrace();
            }
        return null;
    
    }

    public  CaixaVO buscarLoginCaixa(String str){
        try{
            File arquivo = new File(filepath);
           
            if (arquivo.exists() && arquivo.isFile() && arquivo.canRead()){
                FileInputStream arquivoLeitura = new FileInputStream(arquivo);
                while(arquivoLeitura.available()>0){
                    ObjectInputStream objetoLeitura = new ObjectInputStream(arquivoLeitura);

                    CaixaVO caixa = (CaixaVO)objetoLeitura.readObject();
                    
                   
                    if (caixa.getLogin().equalsIgnoreCase(str)){
                        arquivoLeitura.close();
                        objetoLeitura.close();
                        return  caixa;
                    }                    
                }
                System.out.println(" Caixa nÃ£o registrado");
                 // aviso provisorio
                arquivoLeitura.close();
            }
        }catch(Exception e){
                e.printStackTrace();
            }
        return null;
    
    }

    public ArrayList<CaixaVO> buscaExcludente(int id){
        int i=0;
        try{
            File arquivo = new File(filepath);

            ArrayList<CaixaVO> caixas = new ArrayList<CaixaVO>();

            if (arquivo.exists() && arquivo.isFile() && arquivo.canRead()){
                FileInputStream arquivoLeitura = new FileInputStream(arquivo);
                
                while(arquivoLeitura.available()>0){
                    ObjectInputStream objetoLeitura = new ObjectInputStream(arquivoLeitura);

                    CaixaVO caixa = (CaixaVO)objetoLeitura.readObject();
              
                        if(caixa.getId()!=id){
                            caixas.add(i,caixa);
                            i++;
                        }    
                }  
                arquivoLeitura.close();
                if(caixas != null){
                    System.out.println("caixa alterado com sucesso");
                    return caixas;
                    }    
            }
        }catch(Exception e){
                e.printStackTrace();
            }
        return null;
       
    }


}