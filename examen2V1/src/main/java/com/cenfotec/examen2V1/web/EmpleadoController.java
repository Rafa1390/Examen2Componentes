package com.cenfotec.examen2V1.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cenfotec.examen2V1.domain.Empleado;
import com.cenfotec.examen2V1.repository.EmpleadoRepository;

@Controller
public class EmpleadoController {
	@Autowired
	EmpleadoRepository repo;
	
	@PostMapping("/empleado_registro")
	public ModelAndView empleado_registro(@Valid Empleado empleado, BindingResult result) {
		repo.save(empleado);
		return new ModelAndView("redirect:/");
	}
}
