package ba.biggy.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ba.biggy.dao.FaultDAO;
import ba.biggy.model.Fault;

@Controller
public class FaultsOverviewController {

	@Autowired
	private FaultDAO faultDAO;
	
	
	@RequestMapping(value="/faultsOverview")
	public ModelAndView showFaultsOverview(ModelAndView model) throws IOException{
		List<Fault> faultsToDo = faultDAO.listToDoFaults();
		int faultCount = faultDAO.toDoFaultCount();
		model.addObject("faultCount", faultCount);
	    model.addObject("faultsToDo", faultsToDo);
	    model.setViewName("faultsOverviewPage");
	    return model;
	}
	
	
	
	@RequestMapping(value = "/editFault", method = RequestMethod.GET)
	public ModelAndView editFault(HttpServletRequest request) {
		int faultId = Integer.parseInt(request.getParameter("id"));
		Fault fault = faultDAO.getFaultById(faultId);
		ModelAndView model = new ModelAndView("editFaultPage");
		model.addObject("fault", fault);
		return model;
	}
	
	
	
	@RequestMapping(value = "/deleteFault", method = RequestMethod.GET)
	public ModelAndView deleteFault(HttpServletRequest request) {
	    int faultId = Integer.parseInt(request.getParameter("id"));
	    faultDAO.delete(faultId);
	    return new ModelAndView("redirect:/faultsOverview");
	}
	
	@RequestMapping(value = "archiveFault", method = RequestMethod.GET)
	public ModelAndView archiveFault (HttpServletRequest request) {
		int faultId = Integer.parseInt(request.getParameter("id"));
		faultDAO.archiveFault(faultId);
		return new ModelAndView ("redirect:/faultsOverview");
	}
	
	
	/*
	 *  Needs to be replaced by real code
	 */
	@ModelAttribute("typeOfServiceList")
	public Map<String, String> getTypeOfServiceList(){
	    Map<String, String> typeOfServiceList = new HashMap<String, String>();
	    typeOfServiceList.put("Urgent", "Urgent");
	    typeOfServiceList.put("Not urgent", "Not urgent");
	    return typeOfServiceList;
	}
	
	
	/*
	 *  Needs to be replaced by real code
	 */
	@ModelAttribute("servicemanList")
	public Map<String, String> getServicemanList(){
	    Map<String, String> servicemanList = new HashMap<String, String>();
	    servicemanList.put("Serviceman 1", "Serviceman 1");
	    servicemanList.put("Serviceman 2", "Serviceman 2");
	    servicemanList.put("Serviceman 3", "Serviceman 3");
	    servicemanList.put("Serviceman 4", "Serviceman 4");
	    servicemanList.put("Serviceman 5", "Serviceman 5");
	    return servicemanList;
	}
	
	
	
}
