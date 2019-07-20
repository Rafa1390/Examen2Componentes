package com.cenfotec.examen2V1.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping(value="/empleado_modificar/{id}")
	public String empleado_id(@PathVariable Long id, ModelMap mp){
		Empleado empleado = repo.getOne(id);
		mp.addAttribute("empleado", empleado);
	    return "empleado_modificar";
	}
	
	@RequestMapping(value="/empleado_editar", method=RequestMethod.POST)
	public ModelAndView empleado_editar(@ModelAttribute("empleado") Empleado empleado){
	    Empleado empAct = repo.getOne(empleado.getId());
	    empAct.setId(empleado.getId());
	    empAct.setId_finca(empleado.getId_finca());
	    empAct.setCedula(empleado.getCedula());
	    empAct.setNombre(empleado.getNombre());
	    empAct.setApellido(empleado.getApellido());
	    empAct.setRol(empleado.getRol());
	    empAct.setEstado(empleado.getEstado());
	    repo.save(empAct);
	    return new ModelAndView("redirect:/empleado_lista/" + empleado.getId_finca());
	}
}
