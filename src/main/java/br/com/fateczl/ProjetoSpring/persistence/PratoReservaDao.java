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
import br.com.fateczl.ProjetoSpring.model.PratoReserva;
import br.com.fateczl.ProjetoSpring.model.Reserva;

@Component
public class PratoReservaDao implements IPratoReservaDao {
	@Autowired
	GenericDao gDao;

	@Override
	public void inserePratoReserva(PratoReserva pr) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String sql = "INSERT INTO prato_reserva VALUES (?,?,?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, pr.getReserva().getCodigo());
		ps.setInt(2, pr.getPrato().getId());
		ps.setInt(3, pr.getQuantidade());
		ps.execute();
		ps.close();
		c.close();		
	}

	@Override
	public List<PratoReserva> listaPratoReserva(PratoReserva pr) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		List<PratoReserva> lista = new ArrayList<PratoReserva>();
		String sql = "SELECT r.codigo, CONVERT(CHAR(10), r.dt_reserva, 103) AS dt_reserva, p.id, p.prato, p.valor, pr.quantidade FROM prato p, prato_reserva pr, reserva r WHERE r.codigo = pr.codigo_reserva AND p.id = pr.id_prato AND r.codigo = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, pr.getReserva().getCodigo());
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Reserva r = new Reserva();
			r.setCodigo(rs.getInt("codigo"));
			r.setDtReserva(rs.getString("dt_reserva"));
			
			Prato p = new Prato();
			p.setId(rs.getInt("id"));
			p.setPrato(rs.getString("prato"));
			p.setValor(rs.getFloat("valor"));
			
			PratoReserva prRes = new PratoReserva();
			prRes.setPrato(p);
			prRes.setReserva(r);
			prRes.setQuantidade(rs.getInt("quantidade"));
			
			lista.add(prRes);
		}
		rs.close();
		ps.close();
		c.close();
		
		return lista;		
	}
}
