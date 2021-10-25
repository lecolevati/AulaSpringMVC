package br.com.fateczl.ProjetoSpring.persistence;

import java.sql.SQLException;

import br.com.fateczl.ProjetoSpring.model.Reserva;

public interface IReservaDao {

	public void insereReserva(Reserva r) throws SQLException, ClassNotFoundException;
	
}
