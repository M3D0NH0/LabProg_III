package com.senac.Dao;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.senac.conexao.PreparaConexao;
import com.senac.models.Login;

public class LoginDAOBD extends PreparaConexao implements LoginDAO{

	@Override
	public Login insereLoginCliente(Login login) {
		try {
			conexaoPrepared("INSERT INTO login(codcliente,usuario,senha,permissao) VALUES (?,?,?,?)");
			comando.setInt(1, login.getCodCliente());
			comando.setString(2, login.getUsuario());
			comando.setString(3, login.getSenha());
			comando.setInt(4, login.getPermissao());
			comando.executeUpdate();
			return login;
			
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(LoginDAOBD.class.getName()).log(Level.SEVERE, null, ex);
		}catch (SQLException ex) {
			Logger.getLogger(LoginDAOBD.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

	@Override
	public Login insereLoginFuncionario(Login login) {
		try {
			conexaoPrepared("INSERT INTO login(codfuncionario,usuario,senha,permissao) VALUES (?,?,?,?)");
			comando.setInt(1, login.getCodFuncionario());
			comando.setString(2, login.getUsuario());
			comando.setString(3, login.getSenha());
			comando.setInt(4, login.getPermissao());
			comando.executeUpdate();
			return login;
			
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(LoginDAOBD.class.getName()).log(Level.SEVERE, null, ex);
		}catch (SQLException ex) {
			Logger.getLogger(LoginDAOBD.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

	@Override
	public void modificaLogin(Login login) {
		
	}

	@Override
	public void removeLogin(Login login) {
		
	}
	
	
	
	
	
}
