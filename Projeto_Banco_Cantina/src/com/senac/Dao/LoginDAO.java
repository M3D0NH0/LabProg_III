package com.senac.Dao;

import com.senac.models.Login;

public interface LoginDAO {
	
	public Login insereLoginCliente(Login login);
	
	public Login insereLoginFuncionario(Login login);
	
	public void modificaLogin(Login login);
	
	public void removeLogin(Login login);
	
	public Login getLogin(String usuario, String senha);
	
}
