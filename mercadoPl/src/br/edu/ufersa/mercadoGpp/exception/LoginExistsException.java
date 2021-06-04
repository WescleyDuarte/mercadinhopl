package br.edu.ufersa.mercadoGpp.exception;

public class LoginExistsException extends Exception{
    private static final long serialVersionUID = 1L;

    public LoginExistsException() {
        super("Login já existe!");
    }
    
}
