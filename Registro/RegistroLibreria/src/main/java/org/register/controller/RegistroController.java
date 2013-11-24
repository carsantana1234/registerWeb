package org.register.controller;

import java.util.List;

import org.register.model.Registro;
import org.register.model.Visible;
import org.register.service.RegistroService;
import org.register.service.VisibleService;
import org.register.validator.RegistroValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/register")
public class RegistroController {
	
	@Autowired
	private VisibleService visibleService;
	
	@Autowired
	private RegistroService registroService;
	
	@Autowired
	private RegistroValidator registroValidator;
	
	@InitBinder
	private void initBin(WebDataBinder binder){
		binder.setValidator(registroValidator);
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true) );
	}
	
	@ModelAttribute("listaVisible")
	public List<Visible> registerContact() {
	    return  visibleService.getVisibleList();
	}
	
	@RequestMapping(value="/create",method=RequestMethod.GET)
	public ModelAndView newRegisterPage(){
		ModelAndView mav = new ModelAndView("registro-new", "registro", new Registro());
		
		return mav;
	}
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public ModelAndView createNewRegister(@ModelAttribute @Validated Registro regis , BindingResult bindingResult ,final RedirectAttributes redirectAttri){
		
		if(bindingResult.hasErrors())
			return new ModelAndView("registro-new");
		
		ModelAndView mav = new ModelAndView();
		registroService.create(regis);
		
		String mensaje = "El registro " + regis.getName() + " fue guardado correctamente";
		
		mav.setViewName("redirect:/success");
		
		redirectAttri.addFlashAttribute("atrimensaje",mensaje);
		
		return mav;
	}
	
	
	
	@RequestMapping(value="/listar", method=RequestMethod.GET)
	public ModelAndView findAll(){
		
		ModelAndView mav = new ModelAndView("registro-lista");
		List<?> registros = registroService.findAll();
		mav.addObject("registrosLista", registros);
		
		return mav;
		
	}
	
	@RequestMapping(value="/buscar", method=RequestMethod.GET)
	@Transactional(readOnly=true)
	public ModelAndView newfindByName(){
		ModelAndView mav = new ModelAndView("registro-buscar", "registro", new Registro());
		return mav;
	}
	
	@RequestMapping(value="/buscar", method=RequestMethod.POST)
	public ModelAndView findByName( @RequestParam("name") String name ){
		List<?> registros = registroService.findByName(name);
		ModelAndView mav = new ModelAndView("registro-lista");
		mav.addObject("registrosLista", registros);
		
		return mav;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	@Transactional(readOnly=true)
	public ModelAndView editRegistroPage(@PathVariable Integer id){
		ModelAndView mav = new ModelAndView("registro-edit");
		Registro reg = registroService.findById(id);
		mav.addObject("registro",reg);
		
		return mav;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
	@Transactional
	public ModelAndView editRegistro(@ModelAttribute @Validated Registro registro, BindingResult bindingResult ,final RedirectAttributes redirect){
		
		if(bindingResult.hasErrors())
			return new ModelAndView("registro-edit");
		
		ModelAndView mav = new ModelAndView("redirect:/success");
		String mensaje = "El registro " + registro.getId() + " se actualizo correctamente";
		registroService.update( registro );
		redirect.addFlashAttribute("atrimensaje", mensaje);
		
		return mav;
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	@Transactional
	public ModelAndView deleteRegistro(@PathVariable Integer id, final RedirectAttributes redirect){
		
		ModelAndView mav = new ModelAndView("redirect:/success");
		Registro registro = registroService.delete( id );
		String mensaje ="El registro ID " + registro.getId() + " fue eliminado correctamente ";
		
		redirect.addFlashAttribute("atrimensaje", mensaje);
		
		return mav;
		
	}
	
	

}
