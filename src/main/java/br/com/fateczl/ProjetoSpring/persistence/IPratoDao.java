package br.com.fateczl.ProjetoSpring.persistence;

import java.sql.SQLException;
import java.util.List;

import br.com.fateczl.ProjetoSpring.model.Prato;

public interface IPratoDao {

	public Prato consultaPrato(Prato p) throws SQLException, ClassNotFoundException;
	public List<Prato> listaPratos() throws SQLException, ClassNotFoundException;
	
}
