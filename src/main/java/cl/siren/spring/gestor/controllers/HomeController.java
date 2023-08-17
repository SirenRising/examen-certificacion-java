package cl.siren.spring.gestor.controllers;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;

@Controller
@RequestMapping(path = "/")
public class HomeController {

	@GetMapping
    public String paginaInicio(@PathVariable Optional<String> nombre, HttpServletRequest request, Model modelo) {
        
		// Langind
        return "home";
    }

}
