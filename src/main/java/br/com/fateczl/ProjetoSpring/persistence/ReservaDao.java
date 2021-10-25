package br.com.fateczl.ProjetoSpring.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fateczl.ProjetoSpring.model.Reserva;

@Component
public class ReservaDao implements IReservaDao {

	@Autowired
	GenericDao gDao;
	
	@Override
	public void insereReserva(Reserva r) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String sql = "INSERT INTO reserva VALUES (?,?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, r.getCodigo());
		ps.setString(2, r.getDtReserva());
		ps.execute();
		ps.close();
		c.close();
	}
}
