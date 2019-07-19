package com.cenfotec.examen2.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cenfotec.finca.domain.Finca;

//import com.cenfotec.finca.domain.Finca;
//import com.cenfotec.finca.repository.FincaRepository;

@Controller
public class FincaController {
	//@Autowired
	//FincaRepository repo;
	
	//@RequestMapping("/")
	@GetMapping("/finca")
	public String createFincaView(Model model) {
        model.addAttribute("finca", new Finca());
        return "finca";
    }
	
	/*@PostMapping("/finca")
	public String createFinca(@Valid Finca finca, BindingResult result) {
		repo.save(finca);
		return "finca";
	}*/
}
