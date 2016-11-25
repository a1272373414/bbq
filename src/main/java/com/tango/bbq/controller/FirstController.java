package com.tango.bbq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FirstController {
  
  @RequestMapping("/monitor")
  public String home(Model model) {
//	  Map<String, String> map = new HashMap<String, String>();
//	  map.put("testKey", "testValue");
//	  model.addAttribute(map);
	  model.addAttribute("testkey","testvalue");
      return "index";
  }
}
