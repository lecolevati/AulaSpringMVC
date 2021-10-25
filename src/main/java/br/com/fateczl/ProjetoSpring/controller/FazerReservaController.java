package br.com.fateczl.ProjetoSpring.controller;

import java.sql.SQLException;
import java.time.LocalDate;
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

import br.com.fateczl.ProjetoSpring.model.Prato;
import br.com.fateczl.ProjetoSpring.model.PratoReserva;
import br.com.fateczl.ProjetoSpring.model.Reserva;
import br.com.fateczl.ProjetoSpring.persistence.PratoDao;
import br.com.fateczl.ProjetoSpring.persistence.PratoReservaDao;
import br.com.fateczl.ProjetoSpring.persistence.ReservaDao;

@Controller
public class FazerReservaController {

	@Autowired
	PratoDao pDao;

	@Autowired
	ReservaDao rDao;
	
	@Autowired
	PratoReservaDao prDao;
	
	//GET
	@RequestMapping(name = "reserva", value = "/reserva", method = RequestMethod.GET)
	public ModelAndView init(ModelMap model) {
		List<Prato> listaPratos = new ArrayList<Prato>();
		String erro = "";
		try {
			listaPratos = pDao.listaPratos();
		} catch (ClassNotFoundException | SQLException e) {
			erro = e.getMessage();
		} finally {
			model.addAttribute("listaPratos", listaPratos);
			model.addAttribute("erro", erro);
		}
		return new ModelAndView("reserva");
	}
	
	//POST
	@RequestMapping(name = "reserva", value = "/reserva", method = RequestMethod.POST)
	public ModelAndView op(@RequestParam Map<String, String> allRequestParam, 
			ModelMap model) {
		Reserva r = new Reserva();
		List<PratoReserva> listaPratoReserva = new ArrayList<PratoReserva>();
		for (String key : allRequestParam.keySet()) {
			if (key.equals("codigoReserva")) {
				r.setCodigo(Integer.parseInt(allRequestParam.get(key)));
				r.setDtReserva(LocalDate.now().toString());
			} else {
				try {
					if (!allRequestParam.get(key).equals("")) {
						int numericKey = Integer.parseInt(key);
						
						Prato p = new Prato();
						p.setId(numericKey);
						
						PratoReserva pr = new PratoReserva();
						pr.setReserva(r);
						pr.setPrato(p);
						pr.setQuantidade(Integer.parseInt(allRequestParam.get(key)));
						
						listaPratoReserva.add(pr);
					}
				} catch (NumberFormatException e) {}
			}
		}
		try {
			rDao.insereReserva(r);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		for (PratoReserva pr : listaPratoReserva) {
			try {
				prDao.inserePratoReserva(pr);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		
		List<Prato> listaPratos = new ArrayList<Prato>();
		String erro = "";
		try {
			listaPratos = pDao.listaPratos();
		} catch (ClassNotFoundException | SQLException e) {
			erro = e.getMessage();
		} finally {
			model.addAttribute("listaPratos", listaPratos);
			model.addAttribute("erro", erro);
		}
		return new ModelAndView("reserva");
	}
	
}
