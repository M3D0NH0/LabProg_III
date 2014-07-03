package com.senac.view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.senac.Dao.ClienteDAO;
import com.senac.Dao.ClienteDAOBD;
import com.senac.Dao.RelatorioDAO;
import com.senac.Dao.RelatorioDAOBD;
import com.senac.models.Cliente;
import com.senac.models.Relatorio;

public class RelatorioModelo extends AbstractTableModel{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String colunas[];
	List<Cliente> listaClientes;
	List<Relatorio> listaRelatorio;
	
	public RelatorioModelo(){
		listaRelatorio = new ArrayList<Relatorio>();
		listaClientes = new ArrayList<Cliente>();
	}
	
	public RelatorioModelo(String[] colunas){
		this.colunas = colunas;
		ClienteDAO daoCliente = new ClienteDAOBD();
		RelatorioDAO daoRelatorio = new RelatorioDAOBD();
		this.listaRelatorio = daoRelatorio.getTodosRelatorios();
		this.listaClientes = daoCliente.getTodosClientes();
	}
	
	public RelatorioModelo(String[] colunas, List<Cliente> listaClientes){
		this.colunas = colunas;
		this.listaClientes = listaClientes;
	}
	
	public int getRowCount(){
		return(listaRelatorio.size());
	}
	
	public int getColumnCount(){
		return(2);
	}
	
	public String getColumnname(int column){
		return colunas[column];
	}
	
	public Object getValueAt(int indexLinha, int indexColuna){
		if (indexColuna == 0) {
			return(listaRelatorio.get(indexLinha).getCodRelatorio());
		}else{
			return(listaRelatorio.get(indexLinha).getMatricula());
		}
	}
	
	public void addCliente(Cliente cliente){
		ClienteDAO daoCliente = new ClienteDAOBD();
		listaClientes.add(daoCliente.insere(cliente));
	}
	
	public void removeCliente(int linha){
		ClienteDAO daoCliente = new ClienteDAOBD();
		daoCliente.remover(listaClientes.get(linha));
		listaClientes.remove(linha);
	}
	
	public Cliente getCliente(int linha){
		return listaClientes.get(linha);
	}
	
	
	
	
	
}
