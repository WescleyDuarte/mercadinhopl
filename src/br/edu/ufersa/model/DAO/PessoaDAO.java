package br.edu.ufersa.model.DAO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufersa.model.VO.*;

public class PessoaDAO {
    
    private static final String filepath = "Pessoas.dat";
    
    public void cadastrar(PessoaVO pessoa) {

        try{
            FileOutputStream fileOut = new FileOutputStream(filepath,true);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

            objectOut.writeObject(pessoa);
            objectOut.flush();

            fileOut.close();
            objectOut.close();
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public void cadastrarAuxiliar (PessoaVO pessoa){

        try{
            FileOutputStream fileOut = new FileOutputStream(filepath); // não tem true
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

            objectOut.writeObject(pessoa);
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
                PessoaVO pessoa = (PessoaVO)objectIn.readObject();
                System.out.println(pessoa.toString());
            }

            fileIn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private String compNome;

    public  PessoaVO buscarPessoa(String nomeDaPessoa){
        try{
            File arquivo = new File(filepath);
           
            if (arquivo.exists() && arquivo.isFile() && arquivo.canRead()){
                FileInputStream arquivoLeitura = new FileInputStream(arquivo);
                while(arquivoLeitura.available()>0){
                    ObjectInputStream objetoLeitura = new ObjectInputStream(arquivoLeitura);

                    PessoaVO pessoa = (PessoaVO)objetoLeitura.readObject();
                    compNome = pessoa.getNome();

                    if (compNome.equalsIgnoreCase(nomeDaPessoa)){ // trocar aqui
                        arquivoLeitura.close();
                        objetoLeitura.close();
                        return  pessoa;
                    }                    
                }
                System.out.println(" Pessoa não registrada");
                 // aviso provisorio
                arquivoLeitura.close();
            }
        }catch(Exception e){
                e.printStackTrace();
            }
        return null;
    
    }

    public List<PessoaVO> buscaExcludente(String nomeDaPessoa){
        int i=0;
            try{
                File arquivo = new File(filepath);
    
                List<PessoaVO> pessoas = new ArrayList<PessoaVO>();
    
                if (arquivo.exists() && arquivo.isFile() && arquivo.canRead()){
                    FileInputStream arquivoLeitura = new FileInputStream(arquivo);
                    
                    while(arquivoLeitura.available()>0){
                        ObjectInputStream objetoLeitura = new ObjectInputStream(arquivoLeitura);
    
                        PessoaVO pessoa = (PessoaVO)objetoLeitura.readObject();
                        compNome =  pessoa.getNome();

                            if(compNome.equalsIgnoreCase(nomeDaPessoa)){
                                pessoas.add(i,pessoa);
                                i++;
                             }    
                    }                
                    arquivoLeitura.close();
                    if(pessoas != null){
                        System.out.println("pessoas encontrados com sucesso");
                        return pessoas;
                        }    
                }
            }catch(Exception e){
                    e.printStackTrace();
                }
            return null;
        }

}

