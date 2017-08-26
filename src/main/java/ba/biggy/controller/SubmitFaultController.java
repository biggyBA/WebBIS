package ba.biggy.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ba.biggy.dao.FaultDAO;
import ba.biggy.model.Fault;

@Controller
public class SubmitFaultController {
	
	@Autowired
	private FaultDAO faultDAO;
	
	
	@RequestMapping(value="/submitFault")
	public ModelAndView showSubmitFault(ModelAndView model) throws IOException{
	    Fault fault = new Fault();
	    model.addObject("fault", fault);
	    model.setViewName("submitFaultPage");
	    return model;
	}
	
	
	@RequestMapping(value = "/saveFault", method = RequestMethod.POST)
	public ModelAndView saveFault(@ModelAttribute Fault fault) {
	    faultDAO.saveOrUpdate(fault);
	    return new ModelAndView("redirect:/faultsOverview");
	}
	
	
	
	
	/*
	 *  Needs to be replaced by real code
	 */
	@ModelAttribute("servicemanList")
	public Map<String, String> getServicemanList(){
	    Map<String, String> servicemanList = new HashMap<String, String>();
	    servicemanList.put("1", "Serviceman 1");
	    servicemanList.put("2", "Serviceman 2");
	    return servicemanList;
	}
	
	
	/*
	 *  Needs to be replaced by real code
	 */
	@ModelAttribute("usersList")
	public Map<String, String> getUsersList(){
	    Map<String, String> usersList = new HashMap<String, String>();
	    usersList.put("1", "User 1");
	    usersList.put("2", "User 2");
	    return usersList;
	}
	
	/*
	 *  Needs to be replaced by real code
	 */
	@ModelAttribute("typeOfServiceList")
	public Map<String, String> getTypeOfServiceList(){
	    Map<String, String> typeOfServiceList = new HashMap<String, String>();
	    typeOfServiceList.put("1", "Type 1");
	    typeOfServiceList.put("2", "Type 2");
	    return typeOfServiceList;
	}
	
	
	

}
