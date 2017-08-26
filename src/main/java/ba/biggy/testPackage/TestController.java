package ba.biggy.testPackage;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ba.biggy.testPackage.TestModel;
import ba.biggy.testPackage.TestModelDAO;

@Controller
public class TestController {
	
	@Autowired
	private TestModelDAO testModelDAO;
	
	
	@RequestMapping(value="/test")
	public ModelAndView listContact(ModelAndView model) throws IOException{
	    TestModel testModel = new TestModel();
	    model.addObject("testModel", testModel);
	    model.setViewName("testPage");
	 
	    return model;
	}
	
	
	@RequestMapping(value = "/saveTest", method = RequestMethod.POST)
	public ModelAndView saveTest(@ModelAttribute TestModel testModel) {
	    testModelDAO.saveOrUpdate(testModel);
	    return new ModelAndView("redirect:/test");
	}
	

}