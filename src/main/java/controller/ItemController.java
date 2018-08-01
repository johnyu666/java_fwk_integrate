package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pojo.Item;
import service.BaseItemManager;

@RestController
public class ItemController {
	
	@Autowired
	private BaseItemManager manager;
	@RequestMapping(value="bases/{bid}/items",method=RequestMethod.POST
			,consumes="application/json")
	public Item addItem(@RequestBody Item item,@PathVariable String bid) {
		return manager.addItem(item, bid);
	}
	
	@RequestMapping(value="bases/{bid}/items",method=RequestMethod.GET
			,consumes="application/json")
	public List<Item> findAllItems(@PathVariable String bid) {
		return manager.findItemsByBase(bid);
	}
		
}
