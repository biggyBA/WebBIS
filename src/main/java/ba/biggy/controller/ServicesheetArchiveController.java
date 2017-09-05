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
public class ServicesheetArchiveController {
	
	@Autowired
	private FaultDAO faultDAO;
	
	@RequestMapping(value="/servicesheetArchive")
	public ModelAndView showServicesheetArchive(ModelAndView model) throws IOException{
		List<Fault> faultsDone = faultDAO.listDoneFaults();
	    model.addObject("faultsDone", faultsDone);
	    model.setViewName("servicesheetArchivePage");
	 
	    return model;
	}
	
	
	@RequestMapping(value="/enterServicesheet")
	public ModelAndView showEnterServicesheet(ModelAndView model) throws IOException{
		List<Fault> faultsDone = faultDAO.listDoneFaults();
	    model.addObject("faultsDone", faultsDone);
	    model.setViewName("enterServicesheetPage");
	 
	    return model;
	}

}
