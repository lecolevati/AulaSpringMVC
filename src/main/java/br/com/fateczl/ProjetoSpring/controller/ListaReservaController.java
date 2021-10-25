package br.com.fateczl.ProjetoSpring.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.fateczl.ProjetoSpring.model.PratoReserva;
import br.com.fateczl.ProjetoSpring.model.Reserva;
import br.com.fateczl.ProjetoSpring.persistence.PratoReservaDao;

@Controller
public class ListaReservaController {

	@Autowired
	PratoReservaDao prDao;
	
	@RequestMapping(name = "lista", value = "/lista", method = RequestMethod.GET)
	public ModelAndView init() {
		return new ModelAndView("lista");
	}

	@RequestMapping(name = "lista", value = "/lista", method = RequestMethod.POST)
	public ModelAndView op(@RequestParam Map<String, String> allRequestParam,
			ModelMap model) {
		List<PratoReserva> listaPratoReserva = new ArrayList<PratoReserva>();
		int codigoReserva = Integer.parseInt(allRequestParam.get("codigoReserva"));
		String erro = "";
		
		Reserva r = new Reserva();
		r.setCodigo(codigoReserva);
		
		PratoReserva pr = new PratoReserva();
		pr.setReserva(r);
		try {
			listaPratoReserva = prDao.listaPratoReserva(pr);
		} catch (ClassNotFoundException | SQLException e) {
			erro = e.getMessage();
		} finally {
			model.addAttribute("listaPratoReserva", listaPratoReserva);
			model.addAttribute("erro", erro);
		}
		return new ModelAndView("lista");
		
	}
	
}
