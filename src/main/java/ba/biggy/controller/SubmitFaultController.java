package ba.biggy.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	    servicemanList.put("Serviceman 1", "Serviceman 1");
	    servicemanList.put("Serviceman 2", "Serviceman 2");
	    servicemanList.put("Serviceman 3", "Serviceman 3");
	    servicemanList.put("Serviceman 4", "Serviceman 4");
	    servicemanList.put("Serviceman 5", "Serviceman 5");
	    return servicemanList;
	}
	
	
	/*
	 *  Needs to be replaced by real code
	 */
	@ModelAttribute("usersList")
	public Map<String, String> getUsersList(){
	    Map<String, String> usersList = new HashMap<String, String>();
	    usersList.put("User 1", "User 1");
	    usersList.put("User 2", "User 2");
	    return usersList;
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
	@ModelAttribute("productTypeList")
	public Map<String, String> getProductTypeList(){
	    Map<String, String> productTypeList = new HashMap<String, String>();
	    productTypeList.put("7.5 kW", "7.5 kW");
	    productTypeList.put("11 kW", "11 kW");
	    productTypeList.put("10.5 kW", "10.5 kW");
	    productTypeList.put("20 kW", "20 kW");
	    productTypeList.put("35 kW", "35 kW");
	    productTypeList.put("50 kW", "50 kW");
	    productTypeList.put("75 kW", "75 kW");
	    productTypeList.put("100 kW", "100 kW");
	    return productTypeList;
	}
	
	
	
	
	

}
