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
public class FaultsOverviewController {

	@Autowired
	private FaultDAO faultDAO;
	
	
	@RequestMapping(value="/faultsOverview")
	public ModelAndView showFaultsOverview(ModelAndView model) throws IOException{
		List<Fault> listFault = faultDAO.list();
	    model.addObject("listFault", listFault);
	    model.setViewName("faultsOverviewPage");
	    return model;
	}
	
	
}
