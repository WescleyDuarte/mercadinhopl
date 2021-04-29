package br.edu.ufersa.model.VO;

import java.io.Serializable;


public abstract class PessoaVO implements Serializable{
    
    private static final long serialVersionUID = 10L;
    
    private String nome;
    private String sexo;
    private int idade;


    //get
    public PessoaVO(){

    }
    public PessoaVO(String nome,String sexo,int idade){
        setNome(nome);
        setSexo(sexo);
        setIdade(idade);
    }

    public String getNome(){
        return nome;
    }

    public String getSexo(){
        return sexo;
    }

    public int getIdade(){
        return idade;
    }

    //set

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSexo(String sexo) {

        this.sexo = sexo;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    // TOSTRING
    public String toString() {
        String out = "";
        out = out + "\n" + "Nome: " + nome;
        out = out + "\n" + "Sexo: " + sexo;
        out = out + "\n" + "Idade: " + idade;
        return out;
}


}