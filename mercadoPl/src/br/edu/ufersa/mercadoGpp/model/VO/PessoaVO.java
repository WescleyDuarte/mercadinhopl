package br.edu.ufersa.mercadoGpp.model.VO;

import java.io.Serializable;


public class PessoaVO implements Serializable{
    
    private static final long serialVersionUID = 10L;
    
    private String nome;
    private String sexo;
    private int idade;


//get

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

}