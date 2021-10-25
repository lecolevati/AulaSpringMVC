package br.com.fateczl.ProjetoSpring.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.fateczl.ProjetoSpring.model.PratoReserva;
import br.com.fateczl.ProjetoSpring.model.Reserva;
import br.com.fateczl.ProjetoSpring.persistence.PratoReservaDao;

@SpringBootTest
public class ListaReservaControllerTest {

	@Autowired
	PratoReservaDao prDao;
	
	@Test
	public void qtdPratosReserva() {
		Reserva r = new Reserva();
		r.setCodigo(1002);
		
		PratoReserva pr = new PratoReserva();
		pr.setReserva(r);
		
		try {
			List<PratoReserva> listaPratoReserva = prDao.listaPratoReserva(pr);
			assertEquals(listaPratoReserva.size(), 3);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
}
