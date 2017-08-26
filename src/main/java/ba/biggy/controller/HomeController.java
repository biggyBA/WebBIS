package ba.biggy.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ba.biggy.dao.FaultDAO;
import ba.biggy.model.Fault;


@Controller
public class HomeController {
	
	@Autowired
	private FaultDAO faultDAO;
	
	@RequestMapping(value="/")
	public ModelAndView showHomescreen(ModelAndView model) throws IOException{
		List<Fault> faultsToDo = faultDAO.listToDoFaults();
	    model.addObject("faultsToDo", faultsToDo);
	    model.setViewName("homePage");
	 
	    return model;
	}
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value="/servicesheetArchive")
	public ModelAndView showServicesheetArchive(ModelAndView model) throws IOException{
	    
	    model.setViewName("servicesheetArchivePage");
	 
	    return model;
	}

}
