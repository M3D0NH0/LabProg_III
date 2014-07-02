package com.senac.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.senac.conexao.PreparaConexao;
import com.senac.models.Login;

public class LoginDAOBD extends PreparaConexao implements LoginDAO{

	@Override
	public Login insereLoginCliente(Login login) {
		try {
			conexaoPrepared("INSERT INTO login(matricula,usuario,senha,permissao) VALUES (?,?,?,?)");
			comando.setInt(1, login.getMatricula());
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

	@Override
	public Login getLogin(String usuario, String senha) {
		try{
			
			conexaoPrepared("select * from login where usuario=? and senha=?");
			comando.setString(1, usuario);
			comando.setString(2, senha);
			ResultSet resultado = comando.executeQuery();
			
			if(!resultado.next()) return null;
			
			return new Login(
				resultado.getInt("codlogin"),
				resultado.getString("usuario"),
				resultado.getString("senha"),
				resultado.getInt("permissao"),
				resultado.getInt("matricula"),
				resultado.getInt("codfuncionario")
			);
		}catch(ClassNotFoundException ex){
			Logger.getLogger(LoginDAOBD.class.getName()).log(Level.SEVERE, null, ex);
		}catch (SQLException ex) {
			Logger.getLogger(LoginDAOBD.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			fecharPrepared();
		}
		
		return null;
	}
	
	
	
}
