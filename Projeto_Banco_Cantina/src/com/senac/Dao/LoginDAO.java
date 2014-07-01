package com.senac.Dao;

import java.util.List;

import com.senac.models.Login;

public interface LoginDAO {
	
	public Login insereLoginCliente(Login login);
	
	public Login insereLoginFuncionario(Login login);
	
	public void modificaLogin(Login login);
	
	public void removeLogin(Login login);
	
	public List<Login> getLogins();
	
}
