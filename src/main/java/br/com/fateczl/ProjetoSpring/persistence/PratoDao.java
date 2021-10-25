package br.com.fateczl.ProjetoSpring.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fateczl.ProjetoSpring.model.Prato;

@Component
public class PratoDao implements IPratoDao {

	@Autowired
	GenericDao gDao;
	
	@Override
	public Prato consultaPrato(Prato p) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String sql = "SELECT id, prato, valor FROM prato WHERE id = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, p.getId());
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			p.setPrato(rs.getString("prato"));
			p.setValor(rs.getFloat("valor"));
		}
		rs.close();
		ps.close();
		c.close();
		
		return p;
	}
	
	@Override
	public List<Prato> listaPratos() throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		List<Prato> lista = new ArrayList<Prato>();
		String sql = "SELECT id, prato, valor FROM prato";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Prato p = new Prato();
			p.setId(rs.getInt("id"));
			p.setPrato(rs.getString("prato"));
			p.setValor(rs.getFloat("valor"));
			
			lista.add(p);
		}
		rs.close();
		ps.close();
		c.close();
		
		return lista;
	}
}
