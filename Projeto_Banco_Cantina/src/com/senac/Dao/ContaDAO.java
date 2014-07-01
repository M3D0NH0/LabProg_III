package com.senac.Dao;

import java.util.List;

import com.senac.models.Conta;


public interface ContaDAO {
	
	public Conta insereSaldo(Conta conta);
	
	public void removerSaldo(Conta conta);
	
	public void atualizarSaldo(Conta conta);
	
	
}
