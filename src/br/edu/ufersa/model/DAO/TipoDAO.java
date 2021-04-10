package mercadinhopl.model.DAO;

import java.io.*;
import java.util.ArrayList;

import mercadinhopl.model.VO.TipoVO;

public class TipoDAO {

    private static final String filepath = "Tipos.dat" ;

    public static void cadastrar  (TipoVO tipo){

        try{
            FileOutputStream fileOut = new FileOutputStream(filepath,true);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

            objectOut.writeObject(tipo);
            objectOut.flush();

            fileOut.close();
            objectOut.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void cadastrarAuxiliar  (TipoVO tipo){

        try{
            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

            objectOut.writeObject(tipo);
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
                TipoVO tipo = (TipoVO)objetoLeitura.readObject();
                System.out.println(tipo.toString());
            }
            arquivoLeitura.close();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private String compStr; // String de comparação do tipo caso vou precisar

    //tinha aparecido aqui uma mensagem de erro de algumas coisas que vc tinha testado (acho que ja ta tudo ok) R.

    public TipoVO buscarTipo (String str){
        try{
            File arquivo = new File(filepath);
           
            if (arquivo.exists() && arquivo.isFile() && arquivo.canRead()){
                FileInputStream arquivoLeitura = new FileInputStream(arquivo);
                while(arquivoLeitura.available()>0){
                    ObjectInputStream objetoLeitura = new ObjectInputStream(arquivoLeitura);

                    TipoVO tipo = (TipoVO)objetoLeitura.readObject();
                    
                    compStr = tipo.getnome();
                    if (compStr.equalsIgnoreCase(str)){
                        arquivoLeitura.close();
                        objetoLeitura.close();
                        return tipo;
                    }                    
                }
                System.out.println("Tipo não registrado"); // aviso provisorio
                arquivoLeitura.close();
            }
        }catch(Exception e){
                e.printStackTrace();
            }
        return null;
    
    }
    // private Vector<ItemVendaVO> itemVenda = new Vector<ItemVendaVO>();

    boolean a= true;
    public ArrayList<TipoVO> buscaExcludente(String str){
        int i=0;
        try{
            File arquivo = new File(filepath);

            ArrayList<TipoVO> tipos = new ArrayList<TipoVO>();

            if (arquivo.exists() && arquivo.isFile() && arquivo.canRead()){
                FileInputStream arquivoLeitura = new FileInputStream(arquivo);
                
                while(arquivoLeitura.available()>0){
                    ObjectInputStream objetoLeitura = new ObjectInputStream(arquivoLeitura);

                    TipoVO tipo = (TipoVO)objetoLeitura.readObject();
                    compStr = tipo.getnome();

                    a=compStr.equalsIgnoreCase(str); // fiz assim pq ele n estava aceitando dentro com o boolean
                    System.out.println(a);
                    if(a==false){
                            
                        tipos.add(i,tipo);
                        i++;
                            
                    }  
                            
                }
                
                arquivoLeitura.close();
                if(tipos != null){
                    System.out.println("Tipo alterado com sucesso");
                    return tipos;
                    }    
            }
        }catch(Exception e){
                e.printStackTrace();
            }
        return null;
       
    }
}

