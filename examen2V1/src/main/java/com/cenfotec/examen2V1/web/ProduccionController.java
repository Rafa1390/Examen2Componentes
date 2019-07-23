package com.cenfotec.examen2V1.web;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cenfotec.examen2V1.domain.Produccion;
import com.cenfotec.examen2V1.repository.ProduccionRepository;

@Controller
public class ProduccionController {
	@Autowired
	ProduccionRepository repo;
	
	@PostMapping("/produccion_registro")
	public ModelAndView produccion_registro(@Valid Produccion prod, BindingResult result) {
		repo.save(prod);
		return new ModelAndView("redirect:/");
	}
	
	@PostMapping("/produccion_registro_busqueda")
	public ModelAndView produccion_registro_busqueda(@Valid Produccion prod, BindingResult result) {
		
		return new ModelAndView("redirect:/produccion_lista_mes/" + prod.getId_finca());
	}
	
	@RequestMapping(value="/produccion_lista_mes/{id}", method = RequestMethod.GET)
    public String produccion_lista_mes(@PathVariable Long id,ModelMap mp){
		List<Produccion> produccionBD = null;
		List<Produccion> listaProduccion = new ArrayList<Produccion>();
		List<Produccion> listaMes = new ArrayList<Produccion>();
		
		produccionBD = repo.findAll();
		
		for(Produccion bd : produccionBD) {
			if(bd.getId_finca() == id) {
				listaProduccion.add(bd);
			}
		}
		
		LocalDate fechaAct = LocalDate.now();
		
		for(Produccion lp : listaProduccion) {
			if(lp.getFecha().getMonth() == fechaAct.getMonth()) {
				listaMes.add(lp);
			}
		}
		
        mp.put("producciones", listaMes);
        return "produccion_lista_mes";
    }
}
