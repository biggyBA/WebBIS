package ba.biggy.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ba.biggy.model.Fault;


@Controller
public class HomeController {
	
	
	@RequestMapping(value="/")
	public ModelAndView showHomescreen(ModelAndView model) throws IOException{
	    
	    model.setViewName("homePage");
	 
	    return model;
	}
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value="/servicesheetArchive")
	public ModelAndView showServicesheetArchive(ModelAndView model) throws IOException{
	    
	    model.setViewName("servicesheetArchivePage");
	 
	    return model;
	}

}
