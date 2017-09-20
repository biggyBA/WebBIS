package ba.biggy.testPackage;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import ba.biggy.model.Fault;
import ba.biggy.testPackage.TestModel;
import ba.biggy.testPackage.TestModelDAO;

@Controller
public class TestController {
	
	@Autowired
	private TestModelDAO testModelDAO;
	
	
	@RequestMapping(value="/test")
	public ModelAndView listContact(ModelAndView model) throws IOException{
		Fault fault = new Fault();
	    model.addObject("fault", fault);
	    model.setViewName("testPage");
	 
	    return model;
	}
	
	
	@RequestMapping(value = "/saveTest", method = RequestMethod.POST)
	public ModelAndView saveTest(@ModelAttribute TestModel testModel) {
	    testModelDAO.saveOrUpdate(testModel);
	    return new ModelAndView("redirect:/test");
	}
	
	
	@RequestMapping(value = "/testJson")
		public ModelAndView testJson(){
			RestTemplate restTemplate = new RestTemplate();
			String url = "http://localhost:8080/WebServiceMySQL/getAllFaults";
			List<Fault> faults = restTemplate.getForObject(url, List.class);
			return new ModelAndView ("testPage", "faults", faults);
		}
	
	
	@RequestMapping(value = "/testPost", method = RequestMethod.POST)
	public ResponseEntity<Fault> createCustomer(@ModelAttribute Fault fault) {

		
		

		return new ResponseEntity<Fault>(fault, HttpStatus.OK);
	}
	
	
	
	@RequestMapping("/user")
    public ResponseEntity<String> handleUserRequest (RequestEntity<Fault> requestEntity) {
        Fault user = requestEntity.getBody();
        System.out.println("request body: " + user);
        System.out.println("request headers " + requestEntity.getHeaders());
        System.out.println("request method : " + requestEntity.getMethod());

        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.put("Cache-Control", Arrays.asList("max-age=3600"));

        ResponseEntity<String> responseEntity = new ResponseEntity<>("abc",
                                                                     headers,
                                                                     HttpStatus.OK);
        return responseEntity;
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