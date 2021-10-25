package br.com.fateczl.ProjetoSpring.persistence;

import java.sql.SQLException;
import java.util.List;

import br.com.fateczl.ProjetoSpring.model.PratoReserva;

public interface IPratoReservaDao {

	public void inserePratoReserva(PratoReserva pr) throws SQLException, ClassNotFoundException;
	public List<PratoReserva> listaPratoReserva(PratoReserva pr) throws SQLException, ClassNotFoundException;
	
}
