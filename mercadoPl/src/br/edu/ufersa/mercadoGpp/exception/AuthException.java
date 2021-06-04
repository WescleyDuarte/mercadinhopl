package br.edu.ufersa.mercadoGpp.exception;

public class AuthException extends Exception {
    private static final long serialVersionUID = 1L;

	public AuthException() {
		super ("Login ou senha não encontrados");
    }
}
