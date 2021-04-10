package mercadinhopl.model.DAO;

import mercadinhopl.model.VO.*;

import java.io.*;
import java.util.ArrayList;


public class GerenteDAO {
    
    private static final String filepath = "Gerentes.dat";
    private String compStr; // colocar aqui o buscarCaixa e buscaExcludente
    boolean a= true; // foi preciso usar, talvez Deus saiba o porquê
    
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
            FileOutputStream fileOut = new FileOutputStream(filepath);
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

    
    public  GerenteVO buscarGerente(String str){
        try{
            File arquivo = new File(filepath);
           
            if (arquivo.exists() && arquivo.isFile() && arquivo.canRead()){
                FileInputStream arquivoLeitura = new FileInputStream(arquivo);
                while(arquivoLeitura.available()>0){
                    ObjectInputStream objetoLeitura = new ObjectInputStream(arquivoLeitura);

                    GerenteVO gerente = (GerenteVO)objetoLeitura.readObject();
                    
                    compStr = gerente.getNome();
                    if (compStr.equalsIgnoreCase(str)){
                        arquivoLeitura.close();
                        objetoLeitura.close();
                        return  gerente;
                    }                    
                }
                System.out.println(" gerente não registrado");
                 // aviso provisorio
                arquivoLeitura.close();
            }
        }catch(Exception e){
                e.printStackTrace();
            }
        return null;
    
    }

    public ArrayList<GerenteVO> buscaExcludente(String str){
        int i=0;
        try{
            File arquivo = new File(filepath);

            ArrayList<GerenteVO> gerentes = new ArrayList<GerenteVO>();

            if (arquivo.exists() && arquivo.isFile() && arquivo.canRead()){
                FileInputStream arquivoLeitura = new FileInputStream(arquivo);
                
                while(arquivoLeitura.available()>0){
                    ObjectInputStream objetoLeitura = new ObjectInputStream(arquivoLeitura);

                    GerenteVO gerente = (GerenteVO)objetoLeitura.readObject();
                    compStr =  gerente.getNome();

                    a=compStr.equalsIgnoreCase(str); // fiz assim pq ele n estava aceitando dentro com o boolean
                    System.out.println(a);
                        if(a==false){
                            
                            gerentes.add(i,gerente);
                            i++;
                         }    
                }                
                arquivoLeitura.close();
                if(gerentes != null){
                    System.out.println("Gerente alterado com sucesso");
                    return gerentes;
                    }    
            }
        }catch(Exception e){
                e.printStackTrace();
            }
        return null;
       
    }

}
