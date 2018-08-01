package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pojo.Base;
import service.BaseItemManager;

@RestController
@RequestMapping("bases")
public class BaseController {
	@Autowired
	private BaseItemManager manager;
	@RequestMapping(method=RequestMethod.POST,consumes="application/json")
	public Base addBase(@RequestBody Base base) {	
		return manager.addBase(base);
	}
	
	@RequestMapping(value= {"bid"},method=RequestMethod.DELETE,consumes="application/json")
	public String deleteBase(@PathVariable String bid) {	
		manager.deleteBase(bid);
		return "{}";
	}
	@RequestMapping(method=RequestMethod.GET)
	public List<Base> findAllBases(){
		return manager.findAllBases();
	}
}
