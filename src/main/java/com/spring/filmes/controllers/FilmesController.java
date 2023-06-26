package com.spring.filmes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.filmes.models.Filme;
import com.spring.filmes.repository.FilmesRepository;

@Controller
public class FilmesController {
	
	@Autowired
	private FilmesRepository fr;

	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value="/cadastrar-filme", method=RequestMethod.GET)
	public String cadastrarFilme() {
		return "cadastrar-filme";
	}
	
	@RequestMapping(value="/cadastrar-filme", method=RequestMethod.POST)
	public String cadastrarFilme(Filme filme) {
		
		fr.save(filme);
		
		return "redirect:/";
		
	}
	
	@RequestMapping("/lista")
	public ModelAndView lista() {
		
		ModelAndView mv = new ModelAndView("lista");
		
		Iterable<Filme> filmes = fr.findAll();
		mv.addObject("filmes", filmes);
		
		return mv;
		
	}
	
	@RequestMapping(value="/alterar-filme/{codigoFilme}", method = RequestMethod.GET)
		public ModelAndView formAlterarFilme(@PathVariable("codigoFilme") long codigoFilme) {
		Filme filme = fr.findByCodigoFilme(codigoFilme);	
		ModelAndView mv = new ModelAndView("/alterar-filme");
		
		mv.addObject("filme",filme);
		
		return mv;
	}
	
	
	@RequestMapping(value="/alterar-filme/{codigoFilme}",method=RequestMethod.POST)
	public String alterarFilme(@Validated Filme filme, BindingResult result, RedirectAttributes attributes) {
		
		fr.save(filme);
		
		return "redirect:/lista";
		
		
	}
}
