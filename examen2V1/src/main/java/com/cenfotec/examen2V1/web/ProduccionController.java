package com.cenfotec.examen2V1.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
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
}
